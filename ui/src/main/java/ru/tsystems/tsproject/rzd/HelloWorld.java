package ru.tsystems.tsproject.rzd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int procCount = 0;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procCount++;
        System.out.println("This is servlet. " + " Param from filter = " + request.getAttribute("attributeFromFilter"));
        System.out.println("Servlet ini param: " + getServletConfig().getInitParameter("servletParam1Name"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>qwertyuiop</h1>");
        out.println("<h1>Servlet proc count is " + procCount + "</h1>");
        out.println("<h2>This is servlet. " + " Param from filter = " + request.getAttribute("attributeFromFilter") + "</h2>");
        out.println("<h2>Servlet ini param: " + getServletConfig().getInitParameter("servletParam1Name") + "</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
