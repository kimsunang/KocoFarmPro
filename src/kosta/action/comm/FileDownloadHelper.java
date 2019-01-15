package kosta.action.comm;
import java.io.*;

public class FileDownloadHelper {
	public static void copy(String filePath, OutputStream os)	throws IOException
	{
		FileInputStream is = null;
		try {
			is = new FileInputStream(filePath);
			byte[] data = new byte[8096];
			int len = -1;
			while ((len = is.read(data)) != -1) {
				os.write(data, 0, len);
			}
		}catch(Exception ae){
			System.out.println("Exception 발생");
		}		
		finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
			}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					
				}
		}
	}	
}