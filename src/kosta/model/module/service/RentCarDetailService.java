package kosta.model.module.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.parser.JSONParser;
import kosta.model.module.dao.RentCarDetailDao;
import kosta.model.module.vo.RentCarDetail;
import kosta.model.module.vo.RentCarDetailListModel;
import kosta.model.module.vo.RentCarDetailSearch;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//import org.json.simple.parser.JSONParser;

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
	
	
	//등록
	public int setRentCarDetail(HttpServletRequest request)throws Exception{
		
		RentCarDetail rentCarDetail = new RentCarDetail();
			
		rentCarDetail.setCarId(request.getParameter("car_id"));
		//rentCarDetail.setcarId(request.getParameter("car_id"));
		//rentCarDetail.setCar_id(request.getParameter("car_id"));
		rentCarDetail.setModelName(request.getParameter("modelName"));
		rentCarDetail.setCarModel(request.getParameter("carModel"));
		rentCarDetail.setCondition(request.getParameter("condition"));
		rentCarDetail.setPrice(Integer.parseInt(request.getParameter("price")));
		rentCarDetail.setYear(Integer.parseInt(request.getParameter("year")));
		//rentCarDetail.setoilType(request.getParameter("oil_Type"));
		rentCarDetail.setOilType(request.getParameter("oil_Type"));
		return dao.setRentCarDetail(rentCarDetail);

	}
	
	
	//차량번호 목록
	public List<RentCarDetail> getCar_idList(){
		List<RentCarDetail> list = dao.getCar_idList();
		
		return list;
		
	}
	
	//ajax에 따른 데이터
	public void getAjaxData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ajaxMode = request.getParameter("ajaxMode");
		String car_id = request.getParameter("id") == null ? "": request.getParameter("id");
		
		JSONArray jsonArr = new JSONArray();
		
		List<RentCarDetail> list = dao.getCar_idList();
//		jsonArr = JSONArray.fromObject(list);
		
		/*
		for(int i = 0; i<list.size(); i++){
			
		}
		*/
		List myList = new ArrayList();
		
		if("getCarId".equals(ajaxMode)){
			
			List<RentCarDetail> Car_idlist = dao.getCar_idList();
		
			for(int i = 0 ; i < Car_idlist.size(); ++i){
				
				
				myList.add(Car_idlist.get(i).getCarId());
				
				
			}
			
			// re: -1 > 아이디 중복 / 1: 사용 가능한 아이디
			int re = -1;
			for(int i =0; i<myList.size(); i++){				
				if(car_id.equals(myList.get(i))){
					re = 1;
					break;
				}
			}
			
			jsonArr = JSONArray.fromObject(re);
		//response.getWriter().print(myList);
		
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(jsonArr);

	}
}