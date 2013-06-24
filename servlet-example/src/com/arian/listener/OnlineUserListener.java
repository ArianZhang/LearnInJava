package com.arian.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineUserListener
 * 
 */
@WebListener
public class OnlineUserListener implements HttpSessionListener {

    /**
     * Default constructor.
     */
    public OnlineUserListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("新建session:" + event.getSession().getId());
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        session.removeAttribute("onlineUserBindingListener");
//        ServletContext application = session.getServletContext();
//        // 取得登录的用户名
//        String username = (String) session.getAttribute("username");
//        // 从在线列表中删除用户名
//        List onlineUserList = (List) application.getAttribute("onlineUserList");
//        onlineUserList.remove(username);
//        System.out.println(username + "已经退出！");
    }

}
