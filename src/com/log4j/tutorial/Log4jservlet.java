package com.log4j.tutorial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@WebServlet("/Log4jservlet")
public class Log4jservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;

	public void init() {
		logger = Logger.getRootLogger();
		BasicConfigurator.configure();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.setLevel(Level.FATAL);
		logger.debug("Logging Debug message");
		logger.error("Logging error message by KP");
		logger.info("Logging information message");
		logger.warn("Logging warning message");
		logger.fatal("Logging Fatal message");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Log4j Tutorial </title>");
		writer.println("<body>");
		writer.println("Log4j w/no configuration file");
		writer.println("Logger Name:" + logger.getName());
		writer.println("</body>");
		writer.println("</html>");
	}

}
