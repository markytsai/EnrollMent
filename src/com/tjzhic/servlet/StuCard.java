package com.tjzhic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tjzhic.impl.CourseDaoImpl;
import com.tjzhic.impl.MajorDaoImpl;
import com.tjzhic.impl.ReginfoDaoImpl;
import com.tjzhic.entity.Course;
import com.tjzhic.entity.Currstage;
import com.tjzhic.entity.Reginfo;

public class StuCard extends HttpServlet {

  /**
   * Constructor of the object.
   */
  public StuCard() {
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

    Currstage stage = (Currstage)this.getServletContext().getAttribute("currstage");
    ReginfoDaoImpl regimpl = new ReginfoDaoImpl();
	  HttpSession session = request.getSession();
	  Reginfo reg = regimpl.findByUser((String)session.getAttribute("username"));
	  MajorDaoImpl majimp = new MajorDaoImpl();
	  CourseDaoImpl courseImpl = new CourseDaoImpl();
	  ArrayList<Course> courses = courseImpl.findByCmname(reg.getMname());
	  request.setAttribute("courses", courses);
	  request.setAttribute("reginfo", reg);
	  request.getRequestDispatcher("/stu/card.jsp").forward(request, response);
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
