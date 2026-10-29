package tim.now.shared_library.SftpUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;

public class SFTP_DirDetailJavaCode {

	protected String Host = "";
	protected String User = "";
	protected String Password = "";
	protected String DirectoryPath = "";
	protected String Filter = "";
	protected boolean flagKeyAuthentication = false;
	protected String id_rsaFile = "";
	protected int channel_timeout = 0;
	protected String[] ListOfFiles = null;
	protected String Message = "";
	protected String Status = "";
	protected int Port = 0;
	public SFTP_DirDetailJavaCode() {
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
				session.setPassword(getPassword());
			}

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);

			session.connect();

			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");

			channel.connect(getChannel_timeout());
			c = (ChannelSftp) channel;

			SftpATTRS attrs = null;

			String fileInfo;

			// Check the choice of the request

			if (getFilter().isEmpty()) {

				ListOfFiles = new String[1];
				attrs = channel.stat(getDirectoryPath());
				/*String lastModifiedUnformated = c.lstat(getDirectoryPath()).getMtimeString();
				SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
				Date parsedDate = sdf.parse(lastModifiedUnformated);
				SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
				String lastModifiedFormated = print.format(parsedDate);*/
				
			    long lastModifiedUnformated=attrs.getMTime(); 
			    lastModifiedUnformated=lastModifiedUnformated*1000;
			    Date parsedDate =new Date(lastModifiedUnformated);
			    SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			    String lastModifiedFormated = print.format(parsedDate);

				String fileName = getDirectoryPath().substring(
						getDirectoryPath().lastIndexOf('/')+ 1 );
				fileInfo = fileName + "|" + getDirectoryPath() + "||"
						+ attrs.getSize() + "|||" + lastModifiedFormated;

				ListOfFiles[0] = fileInfo;
			}
			else{
				
				Vector <ChannelSftp.LsEntry> v = c.ls (getDirectoryPath() + "*" + getFilter());
				/*
				Vector<ChannelSftp.LsEntry> v = c.ls(getDirectoryPath());
				int sizeOfFiles = 0;
				for (ChannelSftp.LsEntry entry : v) {
					attrs = entry.getAttrs();
					if (!attrs.isDir() && entry.getFilename().endsWith(getFilter())) {
						sizeOfFiles++;
					}
				}
				*/
				int ind = 0;
				ListOfFiles = new String[v.size()];
				//ListOfFiles = new String[sizeOfFiles];

				for (ChannelSftp.LsEntry entry : v) {
					attrs = entry.getAttrs();
					if (!attrs.isDir() && entry.getFilename().endsWith(getFilter())) {

						/*String lastModifiedUnformated = c.lstat(getDirectoryPath() + entry.getFilename()).getMtimeString();
						SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
						Date parsedDate = sdf.parse(lastModifiedUnformated);
						SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
						String lastModifiedFormated = print.format(parsedDate);*/
						
					    long lastModifiedUnformated=attrs.getMTime(); 
					    lastModifiedUnformated=lastModifiedUnformated*1000;
					    Date parsedDate =new Date(lastModifiedUnformated);
					    SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
					    String lastModifiedFormated = print.format(parsedDate);

						fileInfo = entry.getFilename() + "|" + getDirectoryPath()
								+ entry.getFilename() + "||" + attrs.getSize()
								+ "|||" + lastModifiedFormated;

						ListOfFiles[ind] = fileInfo;
						ind++;
					}
				}				
			}		

			setStatus("OK");

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
	public String getHost() {
			return Host;
		}
	public void setHost(String val) {
			Host = val;
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
	public String getDirectoryPath() {
			return DirectoryPath;
		}
	public void setDirectoryPath(String val) {
			DirectoryPath = val;
		}
	public String getFilter() {
			return Filter;
		}
	public void setFilter(String val) {
			Filter = val;
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
	public int getChannel_timeout() {
			return channel_timeout;
		}
	public void setChannel_timeout(int val) {
			channel_timeout = val;
		}
	public String[] getListOfFiles() {
			return ListOfFiles;
		}
	public void setListOfFiles(String[] val) {
			ListOfFiles = val;
		}
	public String getMessage() {
			return Message;
		}
	public void setMessage(String val) {
			Message = val;
		}
	public String getStatus() {
			return Status;
		}
	public void setStatus(String val) {
			Status = val;
		}
	public int getPort() {
			return Port;
		}
	public void setPort(int val) {
			Port = val;
		}

}
