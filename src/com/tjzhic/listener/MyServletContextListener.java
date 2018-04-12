package com.tjzhic.listener;

import com.tjzhic.dao.*;
import com.tjzhic.entity.*;
import com.tjzhic.impl.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebListener()
public class MyServletContextListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public MyServletContextListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        SchoolDao schoolDao = new SchoolDaoImpl();
        MajorDao majorDao = new MajorDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        StageDao stageDao = new StageDaoImpl();

        CurrstageDao currstageDao = new CurrstageDaoImpl();

        School school = schoolDao.getSchool();

        ArrayList<Major> majors = majorDao.findAll();
        ArrayList<Course> courses = courseDao.findAll();
        ArrayList<Stage> stage = stageDao.findAll();
        Currstage currstage = currstageDao.findCurrent();

        sce.getServletContext().setAttribute("school", school);
        sce.getServletContext().setAttribute("majors", majors);
        sce.getServletContext().setAttribute("courses", courses);
        sce.getServletContext().setAttribute("stages", stage);
        sce.getServletContext().setAttribute("currstage", currstage);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("school");
        sce.getServletContext().removeAttribute("majors");
        sce.getServletContext().removeAttribute("courses");
        sce.getServletContext().removeAttribute("stages");
        sce.getServletContext().removeAttribute("currstage");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
