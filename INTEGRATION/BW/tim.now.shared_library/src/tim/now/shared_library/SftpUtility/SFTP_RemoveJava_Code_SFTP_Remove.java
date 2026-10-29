package tim.now.shared_library.SftpUtility;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.util.*;

public class SFTP_RemoveJava_Code_SFTP_Remove {
	protected String pass = "";
	protected int result = 0;
	protected String desc = "";
	protected boolean flagKeyAuthentication = false;
	protected String id_rsaFile = "";
	protected String host = "";
	protected int port = 0;
	protected String user = "";
	protected String RemoteFile = "";
	protected int channel_timeout = 0;
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

	/****** END SET/GET METHOD, DO NOT MODIFY *****/
	public SFTP_RemoveJava_Code_SFTP_Remove() {
	}

	public void invoke() throws Exception {
		/*
		 * Available Variables: DO NOT MODIFY In : String host In : int port In
		 * : String user In : String pass In : String RemoteFile Out : int
		 * result Out : String desc Available Variables: DO NOT MODIFY ****
		 */
		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp c = null;

		try {if(isFlagKeyAuthentication()){
			jsch.addIdentity(getId_rsaFile()); 
			session = jsch.getSession(user, host, port);
			}
		else{
			session = jsch.getSession(user, host, port);
			session.setPassword(pass);
			}


			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect(getChannel_timeout());
			channel.rm(RemoteFile);
			channel.disconnect();
			session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
			desc = e.getMessage();
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

	public String getId_rsaFile() {
			return id_rsaFile;
		}
	public void setId_rsaFile(String val) {
			id_rsaFile = val;
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

	public String getRemoteFile() {
			return RemoteFile;
		}
	public void setRemoteFile(String val) {
			RemoteFile = val;
		}

	public int getChannel_timeout() {
			return channel_timeout;
		}
	public void setChannel_timeout(int val) {
			channel_timeout = val;
		}

}
