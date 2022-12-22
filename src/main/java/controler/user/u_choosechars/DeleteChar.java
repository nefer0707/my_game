package controler.user.u_choosechars;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.chars.CharsBean;
import model.service.Chars;



@WebServlet("/DeleteChar")
public class DeleteChar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session =request.getSession();
		int uid = (int) session.getAttribute("uid");
		int char_id = Integer.parseInt(request.getParameter("char_id"));
		try {
			new Chars().delete_Chars(char_id);
			List<CharsBean> mychars = new Chars().select_CharsByUID(uid);
			request.setAttribute("mychars", mychars);	
			request.getRequestDispatcher("/view/acc/ChooseChar.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
