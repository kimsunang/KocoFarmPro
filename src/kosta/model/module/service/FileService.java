package kosta.model.module.service;

import java.io.File;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.module.dao.FileDao;
import kosta.model.module.vo.Files;


public class FileService {
	
	private static FileDao dao;
	private static FileService fileService = new FileService();
	
	public static FileService getInstance(){
//			dao = dao.getInstance();
	
		 return fileService;
	}
	
	public int setFile(HttpServletRequest request)throws Exception{
		/* 파일 업로드(경로, 파일크기, 인코딩, 파일 이름 중첩 정책) */
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20MB
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		
		System.out.println("파일 서비스 ");
		
		Files file = new Files();
	   	System.out.println("file_name");
		file.setFile_name(multi.getParameter("file_name"));
		file.setFile_path(multi.getParameter("file_path"));
		file.setEmp_id(multi.getParameter("file_id"));
		file.setFile_extention(multi.getParameter("file_extention"));
		file.setFile_date(multi.getParameter("file_date"));
		file.setFile_icon_image(multi.getParameter("file_icon_image"));
		
		
		// 파일 업로드
		if(multi.getFilesystemName("file_name") != null){
			String file_id = multi.getFilesystemName("file_id");
			file.setFile_id(file_id);
		}else{
			file.setFile_id("");
		}
		
		int re = dao.setFile(file);
		
		return re;
	}
	
	/* 수정 */
	public int upFile(HttpServletRequest request)throws Exception{
		/* 파일 업로드(경로, 파일크기, 인코딩, 파일 이름 중첩 정책) */
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20MB
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		Files file = new Files();
		file.setFile_name(multi.getParameter("file_name"));
		file.setFile_path(multi.getParameter("file_path"));
		file.setEmp_id(multi.getParameter("file_id"));
		file.setFile_extention(multi.getParameter("file_extention"));
		file.setFile_date(multi.getParameter("file_date"));
		file.setFile_icon_image(multi.getParameter("file_icon_image"));
		
		String file_id = null;
		
		// 파일 업로드
		if(multi.getFilesystemName("file_id") != null){
			file_id = multi.getFilesystemName("file_id");
		}else{
			file_id = multi.getParameter("file_id");
		}
		
		file.setFile_id(file_id);
		int re = dao.upFile(file);
		
		return re;
	}
	//삭
	public int delFile(HttpServletRequest request)throws Exception{
		String fileId = request.getParameter("file") == null ? "" : request.getParameter("file");
		
		int re = dao.delFile(fileId);
		
		return re;
	}
	
	
}
