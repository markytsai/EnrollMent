package com.tjzhic.servlet;

import com.tjzhic.dao.StuDao;
import com.tjzhic.entity.Stu;
import com.tjzhic.impl.StuDaoImpl;
import com.tjzhic.util.Encrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name="StuRegister",urlPatterns="/register.do")
public class StuRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();

        StuDao stuDao = new StuDaoImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirmpass");
        String code = request.getParameter("code");
        String regip = request.getRemoteAddr();
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("confirmpass", confirmPass);
        request.setAttribute("code", code);

        String mess = validateForm(username, password, confirmPass, code);
        System.out.println("mess = " + mess);

        System.out.println("code vs sessioncode");
        System.out.println(code + " " + session.getAttribute("sessioncode").toString());
        if (! "".equals(mess)) {
            request.setAttribute("stuAddMess", mess);
            request.getRequestDispatcher("/register1.jsp").forward(request, response);
        } else {
            Stu stu = new Stu();
            stu.setUsername(username);
            stu.setPassword(Encrypt.SHA(password));
            stu.setRegip(regip);
            String sessioncode = session.getAttribute("sessioncode").toString();

            if (!code.equals(sessioncode)) {
                request.setAttribute("stuAddMess", "*验证码错误6！");
                request.getRequestDispatcher("/register1.jsp").forward(request, response);
            } else if (stuDao.findByUsername(username) != null) {


                request.setAttribute("stuAddMess", "* 用户名已存在！");
                request.getRequestDispatcher("/register1.jsp").forward(request, response);
            }else if (stuDao.add(stu) != 0) {
                request.setAttribute("stuLoginMess", "* 注册成功，请登录！");
                request.removeAttribute("username");
                request.removeAttribute("password");
                request.removeAttribute("confirmpass");
                request.removeAttribute("code");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else {
                request.setAttribute("stuAddMess", "* 用户注册失败！");
                request.getRequestDispatcher("/register1.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String validateForm(String username, String password, String confirmPass, String code) {
        if (username == null || !username.matches("\\w{6,20}")) {
            return "*用户名不合法";
        } else if (password == null || !password.matches("\\w{6,20}")) {
            return "*密码不合法";
        } else if (!password.equals(confirmPass)) {
            return "*两次输入密码不一致，请重新输入！";
        } else if (code == null || !code.matches("\\d{4}")) {
            return "*验证码错误5";
        } else {
            return "";
        }
    }
}
