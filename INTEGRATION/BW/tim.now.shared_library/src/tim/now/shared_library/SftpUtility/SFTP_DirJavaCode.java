package tim.now.shared_library.SftpUtility;

import java.util.Iterator;
import java.util.Vector;
import java.util.Collections;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import java.util.*;


public class SFTP_DirJavaCode {
	protected String pass = "";
	protected String[] list = null;
	protected int result = 0;
	protected String desc = "";
	protected String password = "";
	protected int ind=0;
	protected String host = "";
	protected int port = 0;
	protected String user = "";
	protected String path = "";
	protected boolean flagKeyAuthentication = false;
	protected String id_rsaFile = "";
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

	public String getpath() {
		return path;
	}

	public void setpath(String val) {
		path = val;
	}

	public String[] getlist() {
		return list;
	}

	public void setlist(String[] val) {
		list = val;
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
	public SFTP_DirJavaCode() {
	}

	public void invoke() throws Exception {
		/*
		 * Available Variables: DO NOT MODIFY In : String host In : int port In
		 * : String user In : String pass In : String path Out : String[] list
		 * Out : int result Out : String desc Available Variables: DO NOT MODIFY
		 * ****
		 */
		/**
		 * Inizializzo il framework e creo la session
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

			/**
			 * Eseguo la configurazione del server
			 */
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);

			/**
			 * Eseguo la connessione della sessione
			 */
			session.connect();

			/**
			 * Creo il channel sftp
			 */
			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");

			/**
			 * Eseguo la connessione con un timeout di 3 secondi
			 */
			channel.connect(getChannel_timeout());
			c = (ChannelSftp) channel;
			
			Vector<ChannelSftp.LsEntry> v = c.ls(path);
			Vector<String> tempList = new Vector<String>();
			
			
			
			for(ChannelSftp.LsEntry entry : v) {
				/*entry.getFilename();*/
				//System.out.println(entry.getFilename());
				String fileName = entry.getFilename();
				/*String comp[] = {".",".."};*/
				/*if((!fileName.equalsIgnoreCase(comp[0])) || (!fileName.equalsIgnoreCase(comp[1]))){
					System.out.println("NELL'IF "+entry.getFilename().toString());
					list[ind]=fileName;
					ind++;*/
				if(".".equalsIgnoreCase(fileName) || "..".equalsIgnoreCase(fileName))
					continue;
				else if(!entry.getAttrs().isDir())
				{
					tempList.add(fileName);
				}
				}
			Collections.sort(tempList);
			list = new String[tempList.size()];									/*modificata lunghezza list*/
			//System.out.println("lunghezza list: " + list.length);
			for(String fileNameTemp : tempList)
			{
				list[ind]=fileNameTemp;
				ind++;
			}
			/*for(ind=0; ind<v.size())*/
			
			/*
														 * modified vector to
														 * vector<?> because
														 * there was Generic
														 * type warnings and i
														 * don't know the data
														 * type c.ls(path)
														 */
			/*
			if (v.size() > 0) {
				Iterator<LsEntry> i = v.iterator(); 
				
				
													 * modified to iterator
													 * because there was Generic
													 * type warnings for time
													 * temporary solution i used
													 * suppressWarnings not good
													 
				list = new String[v.size()];
				System.out.println("lunghezza list: " + list.length);
				int j = 0;
				while (i.hasNext()) {
					list[j] = i.next().toString();
					j++;
				}
				
			}
			*/

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

	public String getPassword() {
			return password;
		}
	public void setPassword(String val) {
			password = val;
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

	public String getPath() {
			return path;
		}
	public void setPath(String val) {
			path = val;
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

}
