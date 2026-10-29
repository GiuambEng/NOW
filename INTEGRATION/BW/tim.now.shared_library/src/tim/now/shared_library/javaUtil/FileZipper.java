/**
 * 
 */
package tim.now.shared_library.javaUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;

/**
 * @author Mikias
 *
 */
public class FileZipper {

	protected String FILE_TOBE_ZIPPED_PATH = "";
	protected String ZIPPED_FILE_PATH = "";
	protected String RESULT = "";

	public String getFILE_TOBE_ZIPPED_PATH() {
		return FILE_TOBE_ZIPPED_PATH;
	}

	public void setFILE_TOBE_ZIPPED_PATH(String val) {
		FILE_TOBE_ZIPPED_PATH = val;
	}

	public String getZIPPED_FILE_PATH() {
		return ZIPPED_FILE_PATH;
	}

	public void setZIPPED_FILE_PATH(String val) {
		ZIPPED_FILE_PATH = val;
	}

	public String getRESULT() {
		return RESULT;
	}

	public void setRESULT(String val) {
		RESULT = val;
	}
	
	protected void setZipDirectory(){
		if(getZIPPED_FILE_PATH() == ""){
			setZIPPED_FILE_PATH(getFILE_TOBE_ZIPPED_PATH().substring(0,
				getFILE_TOBE_ZIPPED_PATH().lastIndexOf(".")).concat(".gz"));
		}
		else{
			setZIPPED_FILE_PATH(ZIPPED_FILE_PATH.toString().concat(
					getFILE_TOBE_ZIPPED_PATH().substring(
							getFILE_TOBE_ZIPPED_PATH().lastIndexOf("\\"),
							getFILE_TOBE_ZIPPED_PATH().lastIndexOf(".")).concat(
							".gz")));
		}
	}	

	public FileZipper() {
	}

	public void invoke() throws Exception {
		
		setZipDirectory();
		
		byte[] buffer = new byte[102400];

		try {

			Path path = FileSystems.getDefault().getPath(
					getFILE_TOBE_ZIPPED_PATH());

			File fileToBeZipped = new File(path.toString());

			if (fileToBeZipped.exists()) {

				GZIPOutputStream gzos = new GZIPOutputStream(
						new FileOutputStream(getZIPPED_FILE_PATH()));

				FileInputStream in = new FileInputStream(
						getFILE_TOBE_ZIPPED_PATH());
				//System.out.println("got the source");

				int len;
				while ((len = in.read(buffer)) > 0) {
					gzos.write(buffer, 0, len);
				}

				in.close();

				gzos.finish();
				gzos.close();

				setRESULT("Successfully Zipped"); 
			} else
				setRESULT("The file to be Zipped doesn't exist ");

		} catch (IOException ex) {
			setRESULT("Error : " + ex.getMessage());
		}		
	}
}
