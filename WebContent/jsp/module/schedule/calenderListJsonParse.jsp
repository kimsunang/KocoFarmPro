<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kosta.model.module.vo.ScheduleCalenderList" %>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
	List<ScheduleCalenderList> category_list;
%>
<% 
	category_list = (List<ScheduleCalenderList>)request.getAttribute("calenderList");
	out.println(JSONArray.fromObject(category_list).toString());
%>