package tim.now.shared_library.SftpUtility;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.util.*;

public class SFTP_Put_New {

	protected String FileToBeSend = "";
	protected String RomoteDirectory = "";
	protected String Host = "";
	protected int Port = 0;
	protected String Status = "";
	protected String Message = "";
	protected String User = "";
	protected String Password = "";
	protected String id_rsaFile = "";
	protected boolean flagKeyAuthentication = false;
	protected int channel_timeout = 0;
	public SFTP_Put_New() {
	}
	public void invoke() throws Exception {
		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp c = null;
		try {	if(isFlagKeyAuthentication()){
					jsch.addIdentity(getId_rsaFile());
					session = jsch.getSession(getUser(), getHost(), getPort());
					}
				else{
					session = jsch.getSession(getUser(), getHost(), getPort());
					session.setPassword(getPassword());
					}

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect(getChannel_timeout());
			c = (ChannelSftp) channel;
			channel.put(getFileToBeSend(), getRomoteDirectory());

			setStatus("OK");			
			channel.exit();
			
		} catch (Exception e) {
			e.printStackTrace();
			setStatus("KO");
			setMessage(e.getMessage());
		} finally {
			if (c != null)
				c.disconnect();
			if (session != null)
				session.disconnect();
		}
	}
	public String getFileToBeSend() {
			return FileToBeSend;
		}
	public void setFileToBeSend(String val) {
			FileToBeSend = val;
		}
	public String getRomoteDirectory() {
			return RomoteDirectory;
		}
	public void setRomoteDirectory(String val) {
			RomoteDirectory = val;
		}
	public String getHost() {
			return Host;
		}
	public void setHost(String val) {
			Host = val;
		}
	public int getPort() {
			return Port;
		}
	public void setPort(int val) {
			Port = val;
		}
	public String getStatus() {
			return Status;
		}
	public void setStatus(String val) {
			Status = val;
		}
	public String getMessage() {
			return Message;
		}
	public void setMessage(String val) {
			Message = val;
		}
	public String getUser() {
			return User;
		}
	public void setUser(String val) {
			User = val;
		}
	public String getPassword() {
			return Password;
		}
	public void setPassword(String val) {
			Password = val;
		}
	public String getId_rsaFile() {
			return id_rsaFile;
		}
	public void setId_rsaFile(String val) {
			id_rsaFile = val;
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

}
