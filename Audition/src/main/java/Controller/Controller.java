package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.artistDAO;
import VO.Tbl_artistVO;
import VO.Tbl_mentoPointVO;
import VO.Tbl_rankVO;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executeDO(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executeDO(request, response);
	}
	
	protected void executeDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI(); 
		String conText = request.getContextPath();
		String doExe = url.substring(conText.length());
		
		String viewPage = null;
		
		artistDAO adao = artistDAO.getInstance(); 
		
		switch(doExe) {
		case "/index.do":
			request.setCharacterEncoding("utf-8");
			
			viewPage = "index.jsp";
			break;
			
		case "/insert.do":
			request.setCharacterEncoding("utf-8");
			
			viewPage = "insert.jsp";
			break;
		
		case "/insertpro.do":
			request.setCharacterEncoding("utf-8");
			
			Tbl_artistVO avo = new Tbl_artistVO();
			
			avo.setArtist_id(request.getParameter("artist_id"));
			avo.setArtist_name(request.getParameter("artist_name"));
			
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String birth = year + month + day;
			
			avo.setArtist_birth(birth);
			avo.setArtist_gender(request.getParameter("gender"));
			avo.setTalent(request.getParameter("talent"));
			avo.setAgency(request.getParameter("agency"));
			
			adao.insertVO(avo);
			
			response.sendRedirect("participantlist.do");
			break;
			
		case "/participantlist.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_artistVO> alist = adao.getParticipantList();
			request.setAttribute("list", alist);
			
			viewPage = "participantlist.jsp";
			break;
					
		case "/mentopointlist.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_mentoPointVO> mplist =  adao.getMentoPointList();
			request.setAttribute("list", mplist);
			
			viewPage = "mentopointlist.jsp";
			break;
			
		case "/participanrank.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_rankVO> rlist =  adao.getRankList();
			request.setAttribute("list", rlist);
			
			viewPage = "participanrank.jsp";
			break;
			
		}
		
		if(viewPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
	}
}
