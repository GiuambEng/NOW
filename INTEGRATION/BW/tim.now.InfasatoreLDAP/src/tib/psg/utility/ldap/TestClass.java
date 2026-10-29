package tib.psg.utility.ldap;

public class TestClass {
//			MAY ( userPassword $ telephoneNumber $ seeAlso $ description $ x-UserAlias $ x-Nome $ x-Matricola $ x-FunzioneAziendale $ x-Mail $ x-CodOloAgcom) )
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//System.out.println(UserManager.createUser("ldap://localhost:389", "cn=Manager,dc=maxcrc,dc=com", "secret", ",ou=people,dc=maxcrc, dc=com", "bzanetti2","33458", , null, null, null, null));
		
		System.out.println(UserManager.createUser("ldap://localhost:389", "cn=Manager,dc=maxcrc,dc=com", "secret", ",ou=People,dc=maxcrc,dc=com", "street", "Paperino", "Consulente", "ciao@com", "12341", "pap", "TLC"));
		//System.out.println(UserManager.deleteUserByUid("ldap://localhost:389", "cn=Manager,dc=maxcrc,dc=com", "secret", ",ou=People,dc=maxcrc,dc=com", "paperino"));
		//System.out.println(UserManager.retrieveUserByUID("ldap://localhost:389", "cn=Manager,dc=maxcrc,dc=com", "secret", ",ou=People,dc=maxcrc,dc=com", "paperino2"));
		//System.out.println(UserManager.updateUserByUid(ldapURL, adminDN, adminPassword, entryDNtail, uid, nome, funzioneaziendale, mail, matricola, useralias, codoloagcom));
		
	}

}
