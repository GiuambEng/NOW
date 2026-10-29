package tim.now.gui_creazioneOrdine_stringManipulation;

public class CheckProgressivo {

	public static boolean IsProgressivo(String [] nomiFile, String fileDaInserire){
		
		int fileNum=Integer.parseInt
				(fileDaInserire.substring(27).toUpperCase().replace(".CSV", ""));
		int currentNum;
		
		for (int i=0;i<nomiFile.length;i++){
		
			currentNum=Integer.parseInt
					(nomiFile[i].substring(27).toUpperCase().replace(".CSV", ""));
			if (currentNum > fileNum){
				return false;
			}
		
		}
		
		return true;
		
	}
}
