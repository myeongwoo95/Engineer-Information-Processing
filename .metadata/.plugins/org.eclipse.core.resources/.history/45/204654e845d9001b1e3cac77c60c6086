package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CompanyDAO;
import DAO.InoutDAO;
import DAO.ProductDAO;
import VO.Tbl_companyVO;
import VO.Tbl_inoutVO;
import VO.Tbl_productVO;
import VO.Tbl_salesVO;

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
		
		CompanyDAO CompanyDAO = new CompanyDAO();
		InoutDAO InoutDAO = new InoutDAO(); 
		ProductDAO ProductDAO = new ProductDAO();
		
		switch(doExe) {
		case "/index.do":
			
			viewPage = "index.jsp";
			break;
			
		case "/view.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_productVO> list = ProductDAO.getList();
			request.setAttribute("list", list);
			
			viewPage = "view.jsp";
			
			
			break;
			
		case "/inputoutputlist.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_inoutVO> inoutList = InoutDAO.getinoutList();
			request.setAttribute("list", inoutList);
			
			viewPage = "inputoutputlist.jsp";
			break;
			
		case "/insert.do":
			request.setCharacterEncoding("utf-8");
			List<Tbl_companyVO> CompnayList = CompanyDAO.getList();
			int maxTno = InoutDAO.getMaxTno();
			maxTno+=1;
			
			request.setAttribute("list", CompnayList);
			request.setAttribute("maxTno", maxTno);
			
			viewPage = "insert.jsp";
			break;
			
		case "/insertpro.do":
			request.setCharacterEncoding("utf-8");
			
			String t_no = request.getParameter("t_no");
			String p_code = request.getParameter("p_code");
			String t_type = request.getParameter("t_type");
			int t_cnt = Integer.parseInt(request.getParameter("t_cnt"));
			String t_date = request.getParameter("t_date");
			String c_code = request.getParameter("c_code");
			
			Tbl_inoutVO ivo = new Tbl_inoutVO();
			ivo.setT_no(t_no);
			ivo.setP_code(p_code);
			ivo.setT_type(t_type);
			ivo.setT_cnt(t_cnt);
			ivo.setT_date(t_date);
			ivo.setC_code(c_code);
			
			int result = InoutDAO.insert(ivo);
		
			response.setCharacterEncoding("utf-8");
			
			if(result==1) {
				response.getWriter().print("success");
			}else {
				response.getWriter().print("fail");
			}
			
			break;
			
		case "/saleslist.do":
			request.setCharacterEncoding("utf-8");
			
			List<Tbl_salesVO> salesList = InoutDAO.getSalesList();
			request.setAttribute("list", salesList);
			
			viewPage = "saleslist.jsp";
			break;
		}
		
		if(viewPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
		
	}

}
