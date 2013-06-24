package com.arian.servlet.asyn;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsynServlet
 */
@WebServlet(urlPatterns = { "/AsynServlet" }, asyncSupported = true)
public class AsynServlet extends HttpServlet {

    Integer count = 0;
    final Object o = new Object();

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsynServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        synchronized (o) {
            count++;
            response.getWriter().println(count + " start " + count);
            System.out.println(count + " start " + count);
            new Thread(new MyRunable(response)).start();
            System.out.println((count) + " end!" + count);
            response.getWriter().println(count + " end!" + count);
        }
    }

    public Integer getCount() {
        return count;
    }

    class MyRunable implements Runnable {

        int count = getCount();
        HttpServletResponse response;

        public MyRunable(HttpServletResponse response) {
            this.response = response;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.err.println(count + " hello! " + count);
                    response.getWriter().println(count + " hello! " + count);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    response.getWriter().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
