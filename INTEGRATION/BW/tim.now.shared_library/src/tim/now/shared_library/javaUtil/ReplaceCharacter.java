package tim.now.shared_library.javaUtil;

public class ReplaceCharacter
{
    public static void main(String[] args)
    {
    	
    }
    
    public static String replaceAllChar(String OldString, String OldChar, String NewChar)
    {
        String NewString = OldString.replace(OldChar, NewChar);
        return NewString;
    }
}