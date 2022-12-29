package controler.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.service.Chars;
import model.service.Item;
import model.service.Job;
import model.service.Skill;

@WebServlet("/ChangeJob")
public class ChangeJob extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int char_id = (int) session.getAttribute("char_id");
		int job_id = Integer.parseInt(request.getParameter("job_id"));
		Item itemfun = new Item();
		Chars charfun = new Chars();
		Job jobfun = new Job();
		Skill skillfun = new Skill();
		try {

			request.setAttribute("job_msg", jobfun.changjob(char_id, job_id));
			request.setAttribute("skills", skillfun.select_skillList_by_char_id(char_id));
			request.setAttribute("jobs", jobfun.select_for_jobLise_by_char_id(char_id));
			request.setAttribute("myjob", jobfun.selecet_job_for_char_id(char_id));
			request.setAttribute("myitems", itemfun.select_item_bag_all(char_id));
			request.setAttribute("myequipments", itemfun.select_equipment_all(char_id));
			request.setAttribute("mychar", charfun.select_CharsBycharID(char_id));
			request.setAttribute("mychar_q", charfun.selectChar_qBycharid(char_id));
			request.getRequestDispatcher("/view/user/MySkillAndJob.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
