package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.VehicleDao;
import com.amaker.dao.impl.VehicleFaultInfoDaoImpl;
import com.amaker.entity.VehicleFaultInfo;

/**
 * 
 * @author KeXu
 */
public class VehicleFaultInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String idno = request.getParameter("idno");
		String license = request.getParameter("license");
		String faultRecord = request.getParameter("faultRecord");

		String createTime = request.getParameter("createTime");
		double penalty = Double.parseDouble(request.getParameter("penalty"));
		
		VehicleFaultInfo v = new VehicleFaultInfo();

		v.setName(name);
		v.setCreateTime(createTime);
		v.setIdno(idno);

		v.setFaultRecord(faultRecord);
		v.setPenalty(penalty);
		v.setLicense(license);
		VehicleDao dao = new VehicleFaultInfoDaoImpl();
		if (dao.save(v))

			out.print("1");
		else

			out.print("0");

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		
	}
	public VehicleFaultInfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
