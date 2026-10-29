package tim.now.gui_integration_XMLTOEXCEL;

public class XmlTagFix {
	protected static String xmlTemp = "";

	public static void main(String[] args){
//		convertedXmlString(xmlTemp);
//		System.out.println(xmlTemp);
	}
	
	public static void convertedXmlString(String xmlString){
		
		xmlTemp = xmlString.replaceAll("&lt;", "<");		
		
		xmlTemp.replaceAll("&gt;" , ">");
	}

	public String getXmlTemp() {
			return xmlTemp;
		}
	public void setXmlTemp(String val) {
			xmlTemp = val;
		}

}
