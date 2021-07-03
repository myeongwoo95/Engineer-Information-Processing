package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HsManagermentDAO;
import VO.Tbl_gradeVO;
import VO.Tbl_scoreVO;
import VO.Tbl_statisticsbyclassVO;
import VO.Tbl_studentVO;



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
		
		HsManagermentDAO hsDao = HsManagermentDAO.getInstance();
		
		
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
			
			Tbl_studentVO svo = new Tbl_studentVO();
			
			svo.setSyear(request.getParameter("syear"));
			svo.setSclass(request.getParameter("sclass"));
			svo.setSno(request.getParameter("sno"));
			svo.setSname(request.getParameter("sname"));
			svo.setBirth(request.getParameter("sbirth"));
			svo.setGender(request.getParameter("gender"));
			svo.setTel1(request.getParameter("tel1"));
			svo.setTel2(request.getParameter("tel2"));
			svo.setTel3(request.getParameter("tel3"));
			
			hsDao.insertVO(svo);
			response.sendRedirect("index.do");
			
			break;
			
		case "/insertgrade.do":
			request.setCharacterEncoding("utf-8");
			
			viewPage = "insertgrade.jsp";
			break;
			
		case "/insertgradepro.do":
			request.setCharacterEncoding("utf-8");
			
			Tbl_scoreVO ssvo = new Tbl_scoreVO();
			
			ssvo.setSyear(request.getParameter("syear"));
			ssvo.setSclass(request.getParameter("sclass"));
			ssvo.setSno(request.getParameter("sno"));	
			ssvo.setKor(Integer.parseInt(request.getParameter("kor")));
			ssvo.setEng(Integer.parseInt(request.getParameter("eng")));
			ssvo.setMat(Integer.parseInt(request.getParameter("mat")));
			
			hsDao.insertScoreVO(ssvo);
			response.sendRedirect("viewgrade.do");
			break;
			
		case "/viewgrade.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_gradeVO> glist = hsDao.getScoreView();
			request.setAttribute("list", glist);
			
			viewPage = "viewgrade.jsp";
			break;
			
		case "/statisticsbyclass.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_statisticsbyclassVO> slist = hsDao.getStatisticsByClass();
			request.setAttribute("list", slist);
			
			viewPage = "statisticsbyclass.jsp";
			break;
		}
		
		if(viewPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
	}
}
