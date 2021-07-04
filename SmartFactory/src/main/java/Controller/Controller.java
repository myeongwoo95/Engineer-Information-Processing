package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SmartFactoryDAO;
import VO.Tbl_productVO;
import VO.Tbl_viewworkVO;

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
		
		SmartFactoryDAO sfdao = SmartFactoryDAO.getInstance();
		
		switch(doExe) {
		case "/index.do":
			request.setCharacterEncoding("utf-8");
			viewPage = "index.jsp";
			break;
			
		case "/viewproduct.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_productVO> vplist = sfdao.getViewProduct();
			request.setAttribute("list", vplist);
			
			viewPage = "viewproduct.jsp";
			break;
		
		case "/viewworkorder.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_viewworkVO> vwolist = sfdao.getViewWorkOrder();
			request.setAttribute("list", vwolist);
			
			viewPage = "viewworkorder.jsp";
			break;
			
				
		case "/insertworkprocess.do":
			request.setCharacterEncoding("utf-8");
			
			viewPage = "insertworkprocess.jsp";
			break;
			
		case "/insertworkprocesspro.do":
			request.setCharacterEncoding("utf-8");
			
			response.sendRedirect("index.do");
			break;
			
		case "/viewworkprocess.do":
			request.setCharacterEncoding("utf-8");
			
			viewPage = "viewworkprocess.jsp";
			break;
			
		}
		
		
		if(viewPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
	}
}
