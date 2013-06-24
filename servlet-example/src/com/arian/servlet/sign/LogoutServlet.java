package com.arian.servlet.sign;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arian.listener.OnlineUserBindingListener;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(description = "用户注销", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doIt4Request2(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doIt4Request2(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     */
//    @SuppressWarnings("unchecked")
//    private void doIt4Request(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // 取得登录的用户名
//        String username = (String) request.getSession().getAttribute("username");
//        // 销毁session
//        request.getSession().invalidate();
//        // 从在线列表中删除用户名
//        List<String> onlineUserList = (List<String>) getServletContext().getAttribute("onlineUserList");
//        onlineUserList.remove(username);
//        // 成功
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
//    }
    
    private void doIt4Request2(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.getSession().invalidate();
        // 成功
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

}
