package tim.now.shared_library.SftpUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.util.*;

public class ShellCommand {

	protected String Host = "";
	protected String User = "";
	protected String Command = "";

	protected String Status = "";
	protected String Message = "";
	protected String Password = "";
	protected boolean flagKeyAuthentication = false;
	protected String id_rsaFile = "";
	protected int port = 0;
	protected int channel_timeout = 0;
	public ShellCommand() {
	}

	public void invoke() throws Exception {
		
		String remoteOutput = "";
		try {

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");

			JSch jsch = new JSch();
			Session session = null;

			if (isFlagKeyAuthentication()) {
				jsch.addIdentity(getId_rsaFile());
				session = jsch.getSession(getUser(), getHost(), getPort());
			} else {
				session = jsch.getSession(getUser(), getHost(), getPort());
				session.setPassword(getPassword());
			}

			session.setConfig(config);
			session.connect();

			//System.out.println("Connected");

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(getCommand());

			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();

			// the remote side can be read from getExtInputStream. So that we
			// can decide if there is an error.
			InputStream remoteInpStr = channel.getExtInputStream();

			channel.connect(getChannel_timeout());

			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					/*System.out.println("exit-status: "
							+ channel.getExitStatus());*/

					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(remoteInpStr));

					String temp = null;
					while ((temp = bufferedReader.readLine()) != null) {
						remoteOutput = temp;
						//System.out.println(remoteOutput);
					}

					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
					setStatus("KO");
					setMessage(ee.getMessage());
				}
			}
			channel.disconnect();
			session.disconnect();

			if (remoteOutput.startsWith("bash:")
					|| remoteOutput.startsWith("*** EXCEPTION")) {
				setStatus("KO");
				setMessage(remoteOutput);
			} else
				setStatus("OK");

		} catch (IOException e) {
			setStatus("KO");
			setMessage(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			setStatus("KO");
			setMessage(e.getMessage());
			e.printStackTrace();
		}

	}

	public String getHost() {
		return Host;
	}

	public void setHost(String val) {
		Host = val;
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

	public String getCommand() {
		return Command;
	}

	public void setCommand(String val) {
		Command = val;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String val) {
		Status = val;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String val) {
		Password = val;
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

	public int getPort() {
		return port;
	}

	public void setPort(int val) {
		port = val;
	}

	public int getChannel_timeout() {
			return channel_timeout;
		}
	public void setChannel_timeout(int val) {
			channel_timeout = val;
		}

}
