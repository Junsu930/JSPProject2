package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.vo.Person;

@WebServlet("/forEach")
public class ForEachServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Person> pList = new ArrayList<>();
		
		pList.add(new Person("김뽕두", 23, "서울시 왕랑구"));
		pList.add(new Person("낄똥뿡", 30, "경기도 의정부시"));
		pList.add(new Person("끼로리", 32, "인천광역시 룽룽구"));
		pList.add(new Person("차차차", 55, "경기도 의왕시"));
		pList.add(new Person("레미롱", 21, "강원도 강강시"));
		
		req.setAttribute("pList", pList);
		
		// 요청 위임
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forEach.jsp");
		
		dispatcher.forward(req, resp);
	
	}
	
}
