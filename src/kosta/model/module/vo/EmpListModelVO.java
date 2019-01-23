package kosta.model.module.vo;

import java.util.List;

public class EmpListModelVO {
	private List<EmpVO> list;
	private int requestPage;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	private int totalCount;
	private int pageSize;
	
	public EmpListModelVO(){}

	public EmpListModelVO(List<EmpVO> list, int requestPage, int totalPageCount, int startPage, int endPage,
			int totalCount, int pageSize) {
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
	}

	public List<EmpVO> getList() {
		return list;
	}

	public void setList(List<EmpVO> list) {
		this.list = list;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}