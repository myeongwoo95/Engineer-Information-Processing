package Controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CustDAO;
import DAO.InjectionDAO;
import DAO.OrderDAO;
import VO.Tbl_custVO;
import VO.Tbl_orderVO;
import VO.VaccinCountVO;
import VO.VaccinHistoryVO;

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
		
		CustDAO cdao = CustDAO.getInstance();
		InjectionDAO idao = InjectionDAO.getInstance();
		OrderDAO odao = OrderDAO.getInstance();
		
		String viewPage = null;
		
		switch(doExe) {
		case "/index.do":
			viewPage = "index.jsp";
			break;
			
		case "/view.do":
			viewPage = "view.jsp";
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			
			List<Tbl_custVO> clist = cdao.getList();
			
			request.setAttribute("year", year);
			request.setAttribute("list", clist);
			break;
			
		case "/insert.do":
			viewPage = "insert.jsp";
			break;
			
		case "/insertpro.do":
			request.setCharacterEncoding("utf-8");
			Tbl_orderVO ovo= new Tbl_orderVO();
			
			ovo.setP_seno(Integer.parseInt(request.getParameter("p_seno")));
			ovo.setP_no(request.getParameter("p_no"));
			ovo.setI_code(request.getParameter("i_code"));
			ovo.setP_date(request.getParameter("p_date"));
			
			odao.setVO(ovo);
			response.sendRedirect("index.do");
			break;
			
		case "/vaccinelist.do":
			
			List<VaccinCountVO> vaccinCountList = odao.getVaccionCountList();
			request.setAttribute("list", vaccinCountList);
			viewPage = "vaccinelist.jsp";
			break;
			
		case "/vaccinationlist.do":
			
			List<VaccinHistoryVO> vaccinHistoryList = odao.getVaccionhistoryList();
			request.setAttribute("list", vaccinHistoryList);
			viewPage = "vaccinationlist.jsp";
			break;
			
			
		}
		


		if(viewPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
		
	}

}
