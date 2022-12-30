package controler.acc;

import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.chars.CharsBean;
import model.bean.community.AccountBean;
import model.service.Acc;
import model.service.Chars;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Acc accfun = new Acc();
		Chars charsfun = new Chars();
		try {
			AccountBean acc = accfun.login_SelectAccount(account, password);
			List<CharsBean> mychars = charsfun.select_CharsByUID(acc.getUid());
			if (accfun.isUser(account, password)) {
				session.setAttribute("uid", acc.getUid());
				request.setAttribute("mychars", mychars);
				request.getRequestDispatcher("/view/acc/ChooseChar.jsp").forward(request, response);
			} else if (accfun.isManager(account, password)) {	
				//轉後台
			} else {
				throw new RuntimeErrorException(null);
			}
		} catch (Exception e) {
			String text = "帳號或密碼錯誤。";
			request.setAttribute("text", text);
			request.getRequestDispatcher("/view/acc/Login.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
