package tim.now.shared_library.SftpUtility;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;

import java.text.SimpleDateFormat;
import java.util.*;

public class SFTP_GetJava_Code_SFTP_Get {
	
	protected static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

	protected String pass = "";	
	protected int result = 0;
	protected String desc = "";
	protected boolean flagKeyAuthentication = false;
	protected String host = "";
	protected int port = 0;
	protected String user = "";
	protected String RemotFile = "";
	protected String LocalFile = "";
	protected String id_rsaFile = "";
	protected int channel_timeout = 0;
	protected String lastModifyDateString = "";

	protected Date lastModifyDate = null;
	public String gethost() {
		return host;
	}

	public void sethost(String val) {
		host = val;
	}

	public int getport() {
		return port;
	}

	public void setport(int val) {
		port = val;
	}

	public String getuser() {
		return user;
	}

	public void setuser(String val) {
		user = val;
	}

	public String getpass() {
		return pass;
	}

	public void setpass(String val) {
		pass = val;
	}

	
	public int getresult() {
		return result;
	}

	public void setresult(int val) {
		result = val;
	}

	public String getdesc() {
		return desc;
	}

	public void setdesc(String val) {
		desc = val;
	}
	
	public void setLastModifyDateString(String val) {
		lastModifyDateString = val;
	}
	
	public String getLastModifyDateString() {
		return lastModifyDateString;
	}
	
	/****** END SET/GET METHOD, DO NOT MODIFY *****/
	public SFTP_GetJava_Code_SFTP_Get() {
	}

	public void invoke() throws Exception {
		/*
		 * Available Variables: DO NOT MODIFY In : String host In : int port In
		 * : String user In : String pass In : String RemoteFile In : String
		 * LocalFile Out : int result Out : String desc : boolean flagKeyAuthentication : String id_rsaFile: Available Variables: DO
		 * NOT MODIFY ****
		 */
		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp c = null;
		try {if(isFlagKeyAuthentication()){
			jsch.addIdentity(getId_rsaFile()); 
			session = jsch.getSession(getuser(), gethost(), getport());
			}
		else{
			session = jsch.getSession(getuser(), gethost(), getport());
			session.setPassword(getpass());
			}
			desc = "success";
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect(getChannel_timeout());
			c = (ChannelSftp) channel;
			c.get(RemotFile, LocalFile);
			
			/*
			 * Ricaviamo gli attributi del file remoto (in particolare la data di ultima modifica)
			*/
			
			SftpATTRS fileAttrs = (SftpATTRS) c.lstat(RemotFile);
			
			if(fileAttrs != null){
				
				//getMtime() ricava la data UTC in secondi
				int dateSeconds = fileAttrs.getMTime();
				
				if(dateSeconds > 0){
					//Ricava la data come Date
					setLastModifyDate(new Date(dateSeconds * 1000L));
				}			
				
				if(lastModifyDate != null){					
					//Trasforma la data nel formato opportuno e la setta
					String dateFormatted = new SimpleDateFormat(DATE_FORMAT).format(lastModifyDate);		
					setLastModifyDateString(dateFormatted);
				}
			}				
			
			//System.out.println("File Trasferito: "+RemotFile);
		} catch (Exception e) {
			//System.out.println("entrato nel catch");
			e.printStackTrace();
			result = 1;
			desc = e.getMessage();
			if (c != null)
				c.disconnect();
			if (session != null)
				session.disconnect();
			//System.out.println("abbattute connessioni");

		} finally {
			if (c != null)
				c.disconnect();
			if (session != null)
				session.disconnect();
			//System.out.println("OKKKKKK");
		}

	}

	public boolean isFlagKeyAuthentication() {
			return flagKeyAuthentication;
		}
	public void setFlagKeyAuthentication(boolean val) {
			flagKeyAuthentication = val;
		}

	public String getHost() {
			return host;
		}
	public void setHost(String val) {
			host = val;
		}

	public int getPort() {
			return port;
		}
	public void setPort(int val) {
			port = val;
		}

	public String getUser() {
			return user;
		}
	public void setUser(String val) {
			user = val;
		}

	public String getRemotFile() {
			return RemotFile;
		}
	public void setRemotFile(String val) {
			RemotFile = val;
		}

	public String getLocalFile() {
			return LocalFile;
		}
	public void setLocalFile(String val) {
			LocalFile = val;
		}

	public String getId_rsaFile() {
			return id_rsaFile;
		}
	public void setId_rsaFile(String val) {
			id_rsaFile = val;
		}

	public int getChannel_timeout() {
			return channel_timeout;
		}
	public void setChannel_timeout(int val) {
			channel_timeout = val;
		}

	public Date getLastModifyDate() {
			return lastModifyDate;
		}
	public void setLastModifyDate(Date val) {
			lastModifyDate = val;
		}

}
