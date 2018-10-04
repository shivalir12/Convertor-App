package com.nc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private ServletConfig config;
	private ServletContext context;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		this.context=config.getServletContext();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String companyName=config.getInitParameter("company name");
		String supportEmail = context.getInitParameter("support");
		String username=req.getParameter("name");
		String profile=req.getParameter("profile");
		PrintWriter out=resp.getWriter();
		if(username!=null)
		{
			out.println("Hello "+username+"!");
			out.println("<b>Your " +profile+ " is created successfully");
            out.println("<br/> your company"+companyName);		
		}
		else {
			out.println("Hello world!");
		}
		Enumeration<String> en=req.getParameterNames();
		while(en.hasMoreElements())
		{
			String currEle=en.nextElement();
			out.println(currEle +"->"+req.getParameter(currEle));
		}
		}
}
