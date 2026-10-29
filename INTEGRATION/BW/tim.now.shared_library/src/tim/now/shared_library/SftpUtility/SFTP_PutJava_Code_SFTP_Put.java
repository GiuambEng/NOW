package tim.now.shared_library.SftpUtility;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class SFTP_PutJava_Code_SFTP_Put {

	/****** START SET/GET METHOD, DO NOT MODIFY *****/
	protected String host = "";
	protected int port = 0;
	protected String user = "";
	protected String pass = "";
	protected String RemoteFile = "";
	protected String directoryput = "";
	protected int result = 0;
	protected String desc = "";

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

	public String getRemoteFile() {
		return RemoteFile;
	}

	public void setRemoteFile(String val) {
		RemoteFile = val;
	}

	public String getdirectoryput() {
		return directoryput;
	}

	public void setdirectoryput(String val) {
		directoryput = val;
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
	public SFTP_PutJava_Code_SFTP_Put() {
	}

	public void invoke() throws Exception {
		/*
		 * Available Variables: DO NOT MODIFY In : String host In : int port In
		 * : String user In : String pass In : String RemoteFile In : String
		 * directoryput Out : int result Out : String desc Available Variables:
		 * DO NOT MODIFY ****
		 */
		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp c = null;
		try {
			session = jsch.getSession(user, host, port);
			session.setPassword(pass);

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect(3000);
			c = (ChannelSftp) channel;
			channel.put(RemoteFile, directoryput);
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

}
