package tim.now.gui_integration_XMLTOEXCEL;

public class ReplaceMoreString
{
    public static void main(String[] args)
    {
    	
    }
    
    public static String replaceAllString(String OldString, String[] OldChar, String[] NewChar)
    {
    	String NewString = OldString;
    	
    	
    	for(int i=0; i < OldChar.length; i++)
    	{
    		//System.out.println("Replace NewString = " + NewString + " - OldChar[i]: " + OldChar[i] + " - NewChar[i]" + NewChar[i]);
    		NewString = NewString.replace(OldChar[i], NewChar[i]);	
    	}
    	
    	//System.out.println("Replace NewString = " + NewString);
        return NewString;
    }
}