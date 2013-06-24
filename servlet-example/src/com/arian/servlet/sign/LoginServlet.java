package com.arian.servlet.sign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arian.listener.OnlineUserBindingListener;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "登陆处理", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doIt4Request(request, response);
        doIt4Request2(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
//        doIt4Request(request, response);
        doIt4Request2(request, response);
    }

//    @SuppressWarnings("unchecked")
//    protected void doIt4Request(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        // 取得登录的用户名
//        String username = request.getParameter("username");
//        // 把用户名保存进session
//        request.getSession().setAttribute("username", username);
//        // 把用户名放入在线列表
//        List<String> onlineUserList = (List<String>) getServletContext().getAttribute("onlineUserList");
//        // 第一次使用前，需要初始化
//        if (onlineUserList == null) {
//            onlineUserList = new ArrayList<String>();
//            getServletContext().setAttribute("onlineUserList", onlineUserList);
//        }
//        onlineUserList.add(username);
//        // 成功
//        response.sendRedirect(request.getContextPath() + "/result.jsp");
//    }

    /**
     * @throws IOException 
     * 
     */
    private void doIt4Request2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 取得登录的用户名
        String username = request.getParameter("username");
        // 把用户名放入在线列表
        request.getSession().setAttribute("onlineUserBindingListener", new OnlineUserBindingListener(username));
        // 成功
        response.sendRedirect(request.getContextPath() + "/result.jsp");

    }
}
