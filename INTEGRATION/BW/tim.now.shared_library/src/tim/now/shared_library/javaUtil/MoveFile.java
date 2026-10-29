package tim.now.shared_library.javaUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveFile {

	protected String fileToBeMovedWithPath = "";
	protected String destinationPathWithFileName = "";
	protected String status = "OK";
	protected String message = "";

	public MoveFile() {
	}

	public void invoke() throws Exception {
		Path pathOfFileToBeMoved = FileSystems.getDefault().getPath(
				fileToBeMovedWithPath);

		Path destinationPath = FileSystems.getDefault().getPath(
				destinationPathWithFileName);

		File _fileToBeMoved = new File(pathOfFileToBeMoved.toString());

		if (_fileToBeMoved.exists()) {

			try {
				Files.move(pathOfFileToBeMoved, destinationPath,
						StandardCopyOption.REPLACE_EXISTING);
			} catch (DirectoryNotEmptyException e) {
				setStatus("KO");
				setMessage("Destination Path is not correct. Make sure you put the destination path with the name of the file.");
			} catch (NullPointerException e) {
				setStatus("KO");
				setMessage("Source or Destination file path is null.");
			} catch (IOException e) {
				setStatus("KO");
				setMessage("Source or Destination file path is Invalid. Or an IO error occurs moving the file");
			}
		} else {
			setStatus("KO");
			setMessage("File To be Moved is not found.");
		}
	}

	public String getFileToBeMovedWithPath() {
		return fileToBeMovedWithPath;
	}

	public void setFileToBeMovedWithPath(String val) {
		fileToBeMovedWithPath = val;
	}

	public String getDestinationPathWithFileName() {
		return destinationPathWithFileName;
	}

	public void setDestinationPathWithFileName(String val) {
		destinationPathWithFileName = val;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String val) {
		status = val;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String val) {
		message = val;
	}

}
