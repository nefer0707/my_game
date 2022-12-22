package controler.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.service.Chars;

@WebServlet("/Rest")
public class Rest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Rest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int char_id = (int) session.getAttribute("char_id");
		Chars charfun = new Chars();
		try {
			String text = charfun.rest(char_id);
			request.setAttribute("mychar_q", charfun.selectChar_qBycharid(char_id));
			request.setAttribute("mychar", charfun.select_CharsBycharID(char_id));
			request.setAttribute("text", text);
			request.getRequestDispatcher("/view/user/Rest.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
