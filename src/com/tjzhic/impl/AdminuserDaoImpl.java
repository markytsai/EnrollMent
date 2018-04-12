package com.tjzhic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tjzhic.dao.AdminuserDao;
import com.tjzhic.db.ConnectionFactory;
import com.tjzhic.entity.Adminuser;


public class AdminuserDaoImpl implements AdminuserDao {

    //添加管理员
    public int add(Adminuser adminuser) {
        int rows = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        try {
            String sql = "insert into adminuser(adminname,adminpass,admingroup) values(?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, adminuser.getAdminname());
            pre.setString(2, adminuser.getAdminpass());
            pre.setString(3, adminuser.getAdmingroup());
            rows = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    //按用户名删除管理员
    public int deleteByAdminname(String adminname) {
        int rows = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        try {
            String sql = "delete from adminuser where adminname=?";
            pre = con.prepareStatement(sql);
            pre.setString(1, adminname);
            rows = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    //查找所有管理员
    public ArrayList<Adminuser> findAll() {
        // TODO Auto-generated method stub
        ArrayList<Adminuser> adminusers = new ArrayList<Adminuser>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            pre = con.prepareStatement("select adminname,admingroup from adminuser");
            rs = pre.executeQuery();
            while (rs.next()) {
                Adminuser adminuser = new Adminuser();
                adminuser.setAdminname(rs.getString(1));
                adminuser.setAdmingroup(rs.getString(2));
                adminusers.add(adminuser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adminusers;
    }

    //按照用户名查找管理员
    public Adminuser findByAdminname(String adminname) {
        // TODO Auto-generated method stub
        Adminuser adminuser = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            pre = con.prepareStatement("select adminname,admingroup from adminuser where adminname=? limit 1");
            pre.setString(1, adminname);
            rs = pre.executeQuery();
            while (rs.next()) {
                adminuser = new Adminuser();
                adminuser.setAdminname(rs.getString(1));
                adminuser.setAdmingroup(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adminuser;
    }

    //验证管理员登录操作
    public Adminuser validateLogin(String adminname, String adminpass) {
        Adminuser adminuser = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            pre = con.prepareStatement("select adminname,admingroup from adminuser where adminname=? and adminpass=? limit 1");
            pre.setString(1, adminname);
            pre.setString(2, adminpass);
            rs = pre.executeQuery();
            while (rs.next()) {
                adminuser = new Adminuser();
                adminuser.setAdminname(rs.getString(1));
                adminuser.setAdmingroup(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adminuser;
    }

    //修改个人密码
    public int passModify(String adminname, String newpass) {
        int rows = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        try {
            String sql = "update adminuser set adminpass=? where adminname=?";
            pre = con.prepareStatement(sql);
            pre.setString(1, newpass);
            pre.setString(2, adminname);
            rows = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

}
