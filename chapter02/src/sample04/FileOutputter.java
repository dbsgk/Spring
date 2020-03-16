package sample04;

import java.io.FileWriter;
import java.io.IOException;

//결과를 파일로 출력하려는 애.
public class FileOutputter implements Outputter{
	private String filePath, fileName;
	
	public void setFilePath(String filePath) {
		System.out.println("setFilePath(String filePath)");
		this.filePath = filePath;
	}
	
	public void setFileName(String fileName) {
		System.out.println("setFileName(String fileName)");
		this.fileName = fileName;
	}
	//파일경로, 파일명 setter로 생성.
	
	@Override
	public void output(String message) {
		try {
			FileWriter fileWriter = new FileWriter(filePath+fileName);
			fileWriter.write(message);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	 IOStrean
	 * byte
	 OutputStream
	 FileOutputStream
	 *문자
	 FileWriter
	 
	 */
}
