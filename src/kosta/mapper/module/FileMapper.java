package kosta.mapper.module;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.model.module.vo.Files;

public interface FileMapper {

	//파일등록
	int setFile(Files file);
	//파일삭제
	int delFile(String file_name);
	//파일수정
	int upFile(Files file);
	//파일리스트
	List<Files> getFileList(Files file);
	
}
