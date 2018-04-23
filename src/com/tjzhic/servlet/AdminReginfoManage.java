package com.tjzhic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjzhic.dao.RecordDao;
import com.tjzhic.impl.RecordDaoImpl;
import com.tjzhic.impl.ReginfoDaoImpl;
import com.tjzhic.entity.Major;
import com.tjzhic.entity.Reginfo;
import com.tjzhic.entity.School;
import com.tjzhic.util.PageModel;

/**
 * 管理员历史记录管理
 */
public class AdminReginfoManage extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public AdminReginfoManage() {
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
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        this.doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize").toString());
        int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo").toString());
        RecordDao recordDao = new RecordDaoImpl();

        ArrayList<Major> majors = (ArrayList<Major>) this.getServletContext().getAttribute("majors");
        request.setAttribute("majors", majors);
        String majorName = request.getParameter("mname");

        String isconfirm = request.getParameter("isconfirm");
        if (majorName != null && isconfirm != null) {
            PageModel<Reginfo> pm = recordDao.pageReginfo(majorName, isconfirm, pageSize, pageNo);
            pm.setPageNav(request.getRequestURI());
            request.setAttribute("pm", pm);
        }
        request.getRequestDispatcher("/jadmin/infomanage.jsp").forward(request, response);
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
