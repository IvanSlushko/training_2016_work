package com.ivanslushko.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletExample extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();

		out.println("<head><title>TEST TITLE NAME</title>");// название окн
		out.println("<h1>Hello world</h1>");// большой размер
		out.println("<h2>today ....................</h2>");// меньше

		out.println("<br/><hr/>"); // line

		out.println("<BLOCKQUOTE> 124521212231… </BLOCKQUOTE>");

		System.out.println("Servlet executed!!!!");
	}

}