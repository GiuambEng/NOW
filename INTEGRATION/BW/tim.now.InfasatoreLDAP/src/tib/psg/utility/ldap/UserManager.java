package tib.psg.utility.ldap;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;

import com.tibco.security.AXSecurityException;
import com.tibco.security.ObfuscationEngine;

public class UserManager {
	private static DirContext getContext(Hashtable<String, String> ldapEnv) throws NamingException {
		DirContext ctx = null;		
		ctx = new InitialDirContext(ldapEnv);
		//System.out.println("connected");
		//System.out.println(ctx.getEnvironment());		     		
		return ctx;
	}
	
	private static Hashtable<String, String> setParameters(String ldapURL, String adminDN, String adminPassword, String entryDNtail){
		Hashtable<String, String> ldapEnv = new Hashtable<String,String>();		
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		ldapEnv.put(Context.PROVIDER_URL, ldapURL);
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		
		// start RU_775
		ldapEnv.put(Context.SECURITY_PROTOCOL, "ssl");
		// fine RU_775
		
		ldapEnv.put(Context.SECURITY_PRINCIPAL, adminDN);
		String clearPassword = null;//adminPassword;
		try {
			clearPassword = new String (ObfuscationEngine.decrypt(adminPassword));
		} catch (AXSecurityException e1) {
			e1.printStackTrace();
		}
		ldapEnv.put(Context.SECURITY_CREDENTIALS, clearPassword);		
		return ldapEnv;
	}

	public static Result createUser(String ldapURL, String adminDN, String adminPassword, String entryDNtail, String uid,String nome, String 
			funzioneaziendale, String mail, String matricola, String useralias, String codoloagcom) {
		if(uid==null || uid.length()==0) return new Result("99", "KO - Missing mandatory field Uid", null);
		Hashtable<String, String> ldapEnv = setParameters(ldapURL, adminDN, adminPassword, entryDNtail);
		/* object classes definition */
		Attribute oc = new BasicAttribute("objectClass");
        //oc.add("person");
        oc.add("x-Persona"); 
		/* User entry definition */
        BasicAttributes entry = new BasicAttributes();
        entry.put(oc);
        entry.put(new BasicAttribute("cn", uid));
        entry.put(new BasicAttribute("sn", uid));
        if(nome!=null && !nome.isEmpty())
        	entry.put(new BasicAttribute("x-Nome", nome));
        if(funzioneaziendale!=null && !funzioneaziendale.isEmpty())
        	entry.put(new BasicAttribute("x-FunzioneAziendale", funzioneaziendale));
        if(mail!=null && !mail.isEmpty())
        	entry.put(new BasicAttribute("x-Mail", mail));
        if(matricola!=null && !matricola.isEmpty())
        	entry.put(new BasicAttribute("x-Matricola", matricola));
        if(useralias!=null && !useralias.isEmpty())
        	entry.put(new BasicAttribute("x-UserAlias", useralias));
        if(codoloagcom!=null && !codoloagcom.isEmpty())
        	entry.put(new BasicAttribute("x-CodOloAgcom", codoloagcom));
        entry.put(new BasicAttribute("userPassword","password"));//richiesta dal committente
        
        String entryDN = "cn=" + uid + entryDNtail ;
        
        DirContext ctx = null;
        
        try {
        	ctx = getContext(ldapEnv);
        	//adding the user to the ldap
           	ctx.createSubcontext(entryDN, entry);			
			return new Result("00", "OK", null);
		} catch (NamingException e) {
			e.printStackTrace();
			return new Result("98", "KO - " + e.getMessage(), null);
		}finally{//closing the connection       
	    	try {
	    		if (ctx != null)
	    			ctx.close();
			} catch (NamingException e) {
				//ignoring, unnecessary to signal faults in case of error closing connection
			}
        }
	}
	
	public static Result retrieveUserByUID(String ldapURL, String adminDN, String adminPassword, String entryDNtail, String uid){
		if(uid==null || uid.length()==0) return new Result("99", "KO - Missing mandatory field Uid", null);
		Hashtable<String, String> ldapEnv = setParameters(ldapURL, adminDN, adminPassword, entryDNtail);
		DirContext ctx = null;Attributes attr=null;User utente=null;
		try{
			ctx = getContext(ldapEnv);
			//retrieval operation
			attr = ctx.getAttributes("cn=" + uid +entryDNtail);
			utente=new User();
			//setting attributes to the "User" object
			utente.setUid(attr.get("cn").get().toString());
			if(attr.get("x-Nome")!=null && attr.get("x-Nome").size()>0)
			utente.setNome(attr.get("x-Nome").get().toString());
			if(attr.get("x-FunzioneAziendale")!=null && attr.get("x-FunzioneAziendale").size()>0)
			utente.setFunzioneAziendale(attr.get("x-FunzioneAziendale").get().toString());
			if(attr.get("x-Mail")!=null && attr.get("x-Mail").size()>0)
			utente.setMail(attr.get("x-Mail").get().toString());			
			if(attr.get("x-Matricola")!=null && attr.get("x-Matricola").size()>0)
			utente.setMatricola(attr.get("x-Matricola").get().toString());
			if(attr.get("x-UserAlias")!=null && attr.get("x-UserAlias").size()>0)
			utente.setUSerAlias(attr.get("x-UserAlias").get().toString());
			if(attr.get("x-CodOloAgcom")!=null && attr.get("x-CodOloAgcom").size()>0)
			utente.setCodOloAgcom(attr.get("x-CodOloAgcom").get().toString());
			return new Result("00", "OK", utente);
		}catch(NamingException e){
			return new Result("97", "KO - " + e.getMessage(), null);
		}finally {
        	try {
        		if (ctx != null)
        			ctx.close();
			} catch (NamingException e) {
				//ignoring, unnecessary to signal faults in case of error closing connection
			}
        }		
	}
	
	public static Result deleteUserByUid(String ldapURL, String adminDN, String adminPassword, String entryDNtail, String uid){
		if(uid==null || uid.length()==0) return new Result("99", "KO - Missing mandatory field Uid", null);
		Hashtable<String, String> ldapEnv = setParameters(ldapURL, adminDN, adminPassword, entryDNtail);
		DirContext ctx = null;
		try{
			ctx = getContext(ldapEnv);
			//this is he delete operation
			ctx.destroySubcontext("cn=" + uid +entryDNtail);
		}catch(NamingException e){
			return new Result("96", "KO - " + e.getMessage(), null);
		}finally {
        	try {
        		if (ctx != null)
        			ctx.close();
			} catch (NamingException e) {
				//ignoring, unnecessary to signal faults in case of error closing connection
			}
		}
		return new Result("00", "OK", null);
	}
		
	public static Result updateUserByUid(String ldapURL, String adminDN, String adminPassword, String entryDNtail, String uid,String nome, String 
			funzioneaziendale, String mail, String matricola, String useralias, String codoloagcom){
		if(uid==null || uid.length()==0) return new Result("99", "KO - Missing mandatory field Uid", null);
		Hashtable<String, String> ldapEnv = setParameters(ldapURL, adminDN, adminPassword, entryDNtail);
		DirContext ctx = null;
		try{
			ctx = getContext(ldapEnv);
		}catch(NamingException e){
			return new Result("99", e.getMessage(), null);
		}	
		try {
			//adding all attributes of the element in a BasicAttributes type so I can handpick them.
			Attributes a = ctx.getAttributes("cn=" + uid +entryDNtail);
			BasicAttributes attrlist= new BasicAttributes();
			NamingEnumeration<? extends Attribute> en=a.getAll();
			while(en.hasMore()){
				Attribute t=en.next();
				attrlist.put(t);
			}
			//filter the useful parameters into an arraylist, so that parameters such as Uid and ObjectClass aren't removed
			ArrayList<Attribute> usefulls=new ArrayList<Attribute>();
			Attribute temp=null;
			temp=attrlist.get("x-UserAlias");
			if(temp!=null) usefulls.add(temp);
			temp=attrlist.get("x-Nome");
			if(temp!=null) usefulls.add(temp);
			temp=attrlist.get("x-Matricola");
			if(temp!=null) usefulls.add(temp);
			temp=attrlist.get("x-FunzioneAziendale");
			if(temp!=null) usefulls.add(temp);
			temp=attrlist.get("x-Mail");
			if(temp!=null) usefulls.add(temp);
			temp=attrlist.get("x-CodOloAgcom");
			if(temp!=null) usefulls.add(temp);
			//creating the modification list array
			ModificationItem[] mods = new ModificationItem[usefulls.size()];
			int i=0;
			for(Object ob:usefulls){
				mods[i]=new ModificationItem(DirContext.REMOVE_ATTRIBUTE, (BasicAttribute)ob);
				i++;
			}
			//submitting the update
			ctx.modifyAttributes("cn=" + uid +entryDNtail, mods);
			//we have now removed all personal attributes, leaving a person object with the only mandatory fields, we must now add what we received
						
			attrlist = new BasicAttributes();
			if(nome!=null && nome.length()>0){
				attrlist.put(new BasicAttribute("x-Nome",nome));
			}
			if(funzioneaziendale!=null && funzioneaziendale.length()>0){
				attrlist.put(new BasicAttribute("x-FunzioneAziendale",funzioneaziendale));
			}
			if(mail!=null && mail.length()>0){
				attrlist.put(new BasicAttribute("x-Mail",mail));
			}
			if(matricola!=null && matricola.length()>0){
				attrlist.put(new BasicAttribute("x-Matricola",matricola));
			}
			if(useralias!=null && useralias.length()>0){
				attrlist.put(new BasicAttribute("x-UserAlias",useralias));
			}
			if(codoloagcom!=null && codoloagcom.length()>0){
				attrlist.put(new BasicAttribute("x-CodOloAgcom",codoloagcom));
			}
			//creating mods array
			mods=new ModificationItem[attrlist.size()];
			en=attrlist.getAll();
			i=0;
			while(en.hasMore()){
				mods[i]=new ModificationItem(DirContext.ADD_ATTRIBUTE, en.next());
				i++;
			}
			//submitting mods
			ctx.modifyAttributes("cn=" + uid +entryDNtail, mods);
			return new Result("00", "OK", null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			return new Result("99","KO  - "+e.getMessage(),null);
		}finally {
        	try {
        		if (ctx != null)
        			ctx.close();
			} catch (NamingException e) {
				//ignoring, unnecessary to signal faults in case of error closing connection
			}
		}
	}

}