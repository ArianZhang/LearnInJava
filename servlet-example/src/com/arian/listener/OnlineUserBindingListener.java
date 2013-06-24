package com.arian.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class OnlineUserBindingListener
 * 
 */
@WebListener
public class OnlineUserBindingListener implements HttpSessionBindingListener {

    String username;

    public OnlineUserBindingListener(String username) {
        this.username = username;
    }

    /**
     * Default constructor.
     */
    public OnlineUserBindingListener() {
    }

    /**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
        
        // 从在线列表中删除用户名
        List onlineUserList = (List) application.getAttribute("onlineUserList");
        onlineUserList.remove(this.username);
        System.out.println(this.username + "退出。");
    }

    /**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
        // 把用户名放入在线列表
        List onlineUserList = (List) application.getAttribute("onlineUserList");
        // 第一次使用前，需要初始化
        if (onlineUserList == null) {
            onlineUserList = new ArrayList();
            application.setAttribute("onlineUserList", onlineUserList);
        }
        onlineUserList.add(this.username);
    }

}
