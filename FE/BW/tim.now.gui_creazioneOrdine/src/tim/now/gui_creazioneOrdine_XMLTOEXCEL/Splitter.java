package tim.now.gui_creazioneOrdine_XMLTOEXCEL;

public class Splitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String SplitXml (String toSplit, String start, String end){
		String s;
		s=toSplit.split(start)[1];
		s=s.split(end)[0];
		return s;		
	}  

}
