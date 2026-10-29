package tim.now.shared_library.SftpUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DirectShellCommand {

       protected String Command = "";

       protected String Status = "";
       protected String Message = "";
       
       public DirectShellCommand() {
       }

       public void invoke() throws Exception {
             
             String remoteOutput = "";
             try {

                    Process p = Runtime.getRuntime().exec(getCommand());   
                 
                    InputStream in = p.getInputStream();

                    
                    byte[] tmp = new byte[1024];
                    while (true) {
                           while (in.available() > 0) {
                                  int i = in.read(tmp, 0, 1024);
                                  if (i < 0)
                                        break;
                                  System.out.print(new String(tmp, 0, i));
                           }
                           if (!p.isAlive()) {
                                 /* System.out.println("exit-status: "
                                               + p.exitValue());*/

                                  BufferedReader bufferedReader = new BufferedReader(
                                               new InputStreamReader(in));

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

       public String getMessage() {
             return Message;
       }

       public void setMessage(String val) {
             Message = val;
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
}

