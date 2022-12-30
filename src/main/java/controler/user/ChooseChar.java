package controler.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.service.Chars;
import model.service.Job;

@WebServlet("/ChooseChar")
public class ChooseChar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Job jobfun = new Job();
		int char_id = Integer.parseInt(request.getParameter("char_id"));
		session.setAttribute("char_id", char_id);
		Chars charsfun = new Chars();
		try {
			request.setAttribute("myjob", jobfun.selecet_job_for_char_id(char_id));
			request.setAttribute("mychar", charsfun.select_CharsBycharID(char_id));
			request.setAttribute("mychar_q", charsfun.selectChar_qBycharid(char_id));
			request.getRequestDispatcher("/view/user/MainPage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
