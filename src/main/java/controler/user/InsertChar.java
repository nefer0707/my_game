package controler.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.chars.CharsBean;
import model.service.Chars;

@WebServlet("/InsertChar")
public class InsertChar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		try {
			new Chars().insert_Chars(request.getParameter("char_name"), request.getParameter("img"), uid);
			List<CharsBean> mychars = new Chars().select_CharsByUID(uid);
			request.setAttribute("mychars", mychars);
			request.getRequestDispatcher("/view/acc/ChooseChar.jsp").forward(request, response);
		} catch (Exception e) {
			String text = "角色已滿或輸入錯誤。";
			request.setAttribute("text", text);
			List<CharsBean> mychars;
			try {
				mychars = new Chars().select_CharsByUID(uid);
				request.setAttribute("mychars", mychars);
				request.getRequestDispatcher("/view/acc/ChooseChar.jsp").forward(request, response);
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
