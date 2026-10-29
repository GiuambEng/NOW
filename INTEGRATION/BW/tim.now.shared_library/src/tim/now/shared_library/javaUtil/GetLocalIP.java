package tim.now.shared_library.javaUtil;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetLocalIP
{
    public static void main(String[] args) 
    {
    	
    }
    
    public static String getIp() throws UnknownHostException
    {
    	InetAddress address = InetAddress.getLocalHost(); 
        String hostIP = address.getHostAddress() ;
    	
        return hostIP;
    }
}
