package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userdao.UserDaoImpl;
import userdao.userdaoimpl.UserDao;

/**
 * Servlet implementation class loginUserServlet
 */
public class loginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		UserDaoImpl userdaoimpl = new UserDao();
		int haha = userdaoimpl.login(number, name);
		if (haha == 1) {
			System.out.println(name + " 恭喜，登陆成功。");
			request.getSession().invalidate();
			HttpSession session = request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("number", number);
			request.getRequestDispatcher("selectUserServlet").forward(request, response);
			// response.sendRedirect("/index.jsp");
		} else {
			if (haha == 0) {
				request.getSession().setAttribute("ok", "密码错误");
			} else {
				request.getSession().setAttribute("ok", "账号错误,没有此账号");
			}
			System.out.println("Attribute中的数据  :" + request.getSession().getAttribute("ok"));
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
