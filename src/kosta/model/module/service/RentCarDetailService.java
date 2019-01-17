package kosta.model.module.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kosta.model.module.dao.RentCarDetailDao;
import kosta.model.module.vo.RentCarDetail;
import kosta.model.module.vo.RentCarDetailSearch;
import kosta.model.module.vo.RentCarDetailListModel;


public class RentCarDetailService {
	private static RentCarDetailDao dao;
	private static RentCarDetailService rentCarDetailService = new RentCarDetailService();
	private static final int PAGE_SIZE = 10;
	
	public static RentCarDetailService getInstance(){
		dao = dao.getInstance();
		
		return rentCarDetailService;
		
	}
	
	
	//목록
	public RentCarDetailListModel getRentCarDetailList(int requestPage, HttpServletRequest request)throws Exception{
		/*
		//검색
		String schType = request.getParameter("schType");
		String schWord = request.getParameter("schWord");
		
		HttpSession session = request.getSession();
		RentCarDetailSearch search = new RentCarDetailSearch();
		
		if(schType != null && schWord != null){
			session.removeAttribute("search");
			search.setSchType(schType);
			search.setSchWord(schWord);
			session.setAttribute("search", search);
		}else if(null != (RentCarDetailSearch)session.getAttribute("search")){
			search = (RentCarDetailSearch)session.getAttribute("search");
		}
		*/
		RentCarDetailSearch search = new RentCarDetailSearch();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("area") != null){
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey('%' + request.getParameter("searchKey") + '%');
			session.setAttribute("search", search);
		}else if ((RentCarDetailSearch)session.getAttribute("search") != null) {
			search = (RentCarDetailSearch)session.getAttribute("search");
		}
				
		//페이지
		//총글개수
		int totalCount = dao.getRentCarDetailListCnt(search);
		
		//총 페이지수
		int totalPageCount = totalCount/PAGE_SIZE;
		
		//게시글 나머지
		if(totalCount%PAGE_SIZE>0){
			totalPageCount++;
		}
		
		//시작페이지, 마지막 페이지
		int startPage = requestPage - (requestPage-1)%PAGE_SIZE;
		int endPage = startPage + (PAGE_SIZE-1);
		
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		//시작행 구하기 :(현재페이지-1) * 페이지 당 글 개수
		int startRow = (requestPage-1) * PAGE_SIZE;
		
		List<RentCarDetail> list = dao.getRentCarDetailList(search, startRow);
		RentCarDetailListModel listModel = new RentCarDetailListModel(list, requestPage, totalPageCount, startPage, endPage);
				
		return listModel;
	}
	
	
	
	//상세정보 -- 오잉?
	/*public RentCarDetail getRentCarDetail(HttpServletRequest request)throws Exception{
		String car_id = request.getParameter("car_id") == null ? "" : request.getParameter("car_id");
		RentCarDetail rentCarDetail = dao.getRentCarDetail(car_id);
		
		if("view".equals(request.getParameter("mode"))){
			String 
		}
		
	}*/
	
	
	//등록
	public int setRentCarDetail(HttpServletRequest request)throws Exception{
		
		RentCarDetail rentCarDetail = new RentCarDetail();
		
		/*
		System.out.println("Car_id :" + Integer.parseInt(request.getParameter("car_id")));
		System.out.println(request.getParameter("car_id").getClass());
		int carId = Integer.parseInt(request.getParameter("car_id"));		
		rentCarDetail.setCar_id(carId);		
		System.out.println("#통과 ?");
		*/
		
		rentCarDetail.setCar_id(request.getParameter("car_id"));
		rentCarDetail.setModelName(request.getParameter("modelName"));
		rentCarDetail.setCarModel(request.getParameter("carModel"));
		rentCarDetail.setCondition(request.getParameter("condition"));
		rentCarDetail.setPrice(Integer.parseInt(request.getParameter("price")));
		rentCarDetail.setYear(Integer.parseInt(request.getParameter("year")));
		rentCarDetail.setOil_Type(request.getParameter("oil_Type"));
		
		
		return dao.setRentCarDetail(rentCarDetail);
		
		
	}
	

}
