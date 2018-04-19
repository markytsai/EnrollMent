package com.tjzhic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tjzhic.impl.GradeDaoImpl;
import com.tjzhic.impl.ReginfoDaoImpl;
import com.tjzhic.entity.Grade;
import com.tjzhic.entity.Reginfo;
import com.tjzhic.entity.SupGrade;

public class StuGrade extends HttpServlet {

  /**
   * Constructor of the object.
   */
  public StuGrade() {
    super();
  }

  /**
   * Destruction of the servlet. <br>
   */
  public void destroy() {
    super.destroy(); // Just puts "destroy" string in log
    // Put your code here
  }

  /**
   * The doGet method of the servlet. <br>
   *
   * This method is called when a form has its tag value method equals to get.
   * 
   * @param request the request send by the client to the server
   * @param response the response send by the server to the client
   * @throws ServletException if an error occurred
   * @throws IOException if an error occurred
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.doPost(request, response);
  }

  /**
   * The doPost method of the servlet. <br>
   *
   * This method is called when a form has its tag value method equals to post.
   * 
   * @param request the request send by the client to the server
   * @param response the response send by the server to the client
   * @throws ServletException if an error occurred
   * @throws IOException if an error occurred
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  HttpSession session =  request.getSession();
	  String username = (String)session.getAttribute("username");
	  ReginfoDaoImpl reginfoImp =  new ReginfoDaoImpl();
	  Reginfo reginfo = reginfoImp.findByUser(username);
	  String testcardnum = reginfo.getTestcardnum();
	  GradeDaoImpl gradeImp = new GradeDaoImpl();
	  ArrayList<SupGrade> supgrades = gradeImp.findByCardnum(testcardnum);
	  request.setAttribute("grade", supgrades);
	  request.getRequestDispatcher("/stu/grade.jsp").forward(request, response);
  }

  /**
   * Initialization of the servlet. <br>
   *
   * @throws ServletException if an error occurs
   */
  public void init() throws ServletException {
    // Put your code here
  }

}
