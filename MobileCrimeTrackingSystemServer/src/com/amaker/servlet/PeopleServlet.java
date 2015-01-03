package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.PeopleDao;
import com.amaker.dao.impl.PeopleDaoImpl;

/**
 * 
 * @author KeXU
 */
public class PeopleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idno = request.getParameter("idno");
		PeopleDao dao = new PeopleDaoImpl();
		String msg = dao.getString(idno);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(msg);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}
	
	public PeopleServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
