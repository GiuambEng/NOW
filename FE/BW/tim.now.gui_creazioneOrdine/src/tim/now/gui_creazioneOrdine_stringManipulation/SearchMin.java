package tim.now.gui_creazioneOrdine_stringManipulation;

import java.util.ArrayList;

public class SearchMin {
	
	public static int GetNextMin(String [] array){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//costruzione array di numeri
		for (int i = 0;i<array.length;i++){
			if (IsNumber(array[i])){
				list.add(Integer.parseInt(array[i]));
			}
		}
		
		int minDisponibile;
		
		for (minDisponibile = 2;minDisponibile<=4000;minDisponibile++){
			if (!list.contains(minDisponibile)) break;
		}
		
		return minDisponibile;
	}
	
	private static boolean IsNumber (String s){
		
		try{
			Integer.parseInt(s);
			return true;
		}
		catch (Exception e){
			return false;
		} 
	}
	
}
