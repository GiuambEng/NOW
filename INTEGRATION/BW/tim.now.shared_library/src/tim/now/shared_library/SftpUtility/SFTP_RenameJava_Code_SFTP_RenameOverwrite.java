package tim.now.shared_library.SftpUtility;

import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class SFTP_RenameJava_Code_SFTP_RenameOverwrite {

	protected int port = 0;
	protected String pass = "";
	protected String id_rsaFile = "";
	protected String desc = "";
	protected int result = 0;
	protected boolean flagKeyAuthentication = false;
	protected int channel_timeout = 0;
	protected String host = "";
	protected String user = "";
	protected String source = "";
	protected String dest = "";

	public int getPort() {
		return port;
	}

	public void invoke() throws Exception {

		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp c = null;
		
		try {
			if (isFlagKeyAuthentication()) {
				jsch.addIdentity(getId_rsaFile());
				session = jsch.getSession(getUser(), getHost(), getPort());
			} else {
				session = jsch.getSession(getUser(), getHost(), getPort());
				session.setPassword(getPass());
			}

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			
			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect(getChannel_timeout());
			c = (ChannelSftp) channel;
			
			String destDirectoryPath = dest.substring(0, dest.lastIndexOf('/'));
			String newFileName = dest.substring(dest.lastIndexOf('/') + 1, dest.length());

			/* Delete, if any, existing file with the target filename in order to overwrite */
			@SuppressWarnings("unchecked")
			Vector<LsEntry> files = c.ls(destDirectoryPath);
			for (LsEntry file : files) {
				if (newFileName.equals(file.getFilename())) {
					 c.rm(dest);
					 break;
				}
			}
			/* End of delete existing file with the target filename */
			
			channel.rename(source, dest);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
			desc = e.getMessage();
		} finally {
			if (c != null)
				c.disconnect();
			if (session != null)
				session.disconnect();
		}

	}

	public void setPort(int val) {
		port = val;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String val) {
		pass = val;
	}

	public String getId_rsaFile() {
		return id_rsaFile;
	}

	public void setId_rsaFile(String val) {
		id_rsaFile = val;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String val) {
		desc = val;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int val) {
		result = val;
	}

	public boolean isFlagKeyAuthentication() {
		return flagKeyAuthentication;
	}

	public void setFlagKeyAuthentication(boolean val) {
		flagKeyAuthentication = val;
	}

	public int getChannel_timeout() {
		return channel_timeout;
	}

	public void setChannel_timeout(int val) {
		channel_timeout = val;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String val) {
		host = val;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String val) {
		user = val;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String val) {
		source = val;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String val) {
		dest = val;
	}

}
