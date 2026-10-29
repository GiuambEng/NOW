package tim.now.gui_creazioneOrdine_XMLTOEXCEL;
public class ReplaceCharacter {
protected static String stringToModify;

//main per testare il metodo
public static void main(String args[]){
//	ReplaceCharacter a = new ReplaceCharacter();
//	a.setStringToModify("ciao_bella%cemop"); 
//	a.setStringToModify(stringStartEndWithToModify(a.getStringToModify(),"STARTWITH")  );
//	System.out.println(a.getStringToModify());
}
public static String stringStartEndWithToModify(String inputLike,String tipoLike){
	 // Stringa da modificare
	stringToModify = inputLike.replaceAll("_","\\\\_");	
	stringToModify = stringToModify.replaceAll("%","\\\\%");	

	
	 if(tipoLike.equals("STARTWITH")){
	 stringToModify= stringToModify+"%'" + " escape '\\' ";
	}else // ENDWITH
	{stringToModify= "'%"+stringToModify+"'"  + " escape '\\' ";}
	
	 return stringToModify;
}


public String getStringToModify(){
	return ReplaceCharacter.stringToModify;
}

@SuppressWarnings("static-access")
public void  setStringToModify(String stringToModify){
 this.stringToModify=stringToModify;
}
}
