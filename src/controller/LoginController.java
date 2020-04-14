package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email+" "+password);
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao userDao = new UserDao();
		boolean validateUser = userDao.loginUser(user);
		if(validateUser) {
			System.out.println("login sucess");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		
		else {
			System.out.println("Failed");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
