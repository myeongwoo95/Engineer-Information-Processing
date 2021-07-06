package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_processVO;
import VO.Tbl_productVO;
import VO.Tbl_viewworkVO;

public class SmartFactoryDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	private static SmartFactoryDAO instance = new SmartFactoryDAO();
	private SmartFactoryDAO() {}
	
	public static SmartFactoryDAO getInstance() {
		return instance;
	}

	public List<Tbl_productVO> getViewProduct() {
		List<Tbl_productVO> list = new ArrayList<Tbl_productVO>();
		Tbl_productVO vo = null;
		
		try {
			 String sql = "select * from tbl_product_201909";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_productVO();
				vo.setP_code(rs.getString("p_code"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_size(rs.getString("p_size"));
				vo.setP_type(rs.getString("p_type"));
				vo.setP_price(rs.getInt("p_price"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<Tbl_viewworkVO> getViewWorkOrder() {
		List<Tbl_viewworkVO> list = new ArrayList<Tbl_viewworkVO>();
		Tbl_viewworkVO vo = null;
		
		try {
			 String sql = "select a.w_workno, a.p_code, b.p_name, b.p_size, b.p_type, a.w_quentity, a.w_workdate "
				 		+ "from "
				 		+ "tbl_worklist_201909 a,"
				 		+ "tbl_product_201909 b "
				 		+ "where "
				 		+ "a.p_code = b.p_code "
				 		+ "order by a.w_workno";
				 		
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_viewworkVO();
				vo.setW_workno(rs.getString("w_workno"));
				vo.setP_code(rs.getString("p_code"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_size(rs.getString("p_size"));
				vo.setP_type(rs.getString("p_type"));
				vo.setW_quentity(rs.getInt("w_quentity"));
				vo.setW_workdate(rs.getString("w_workdate").substring(0,10));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}

	public void insert(Tbl_processVO vo) {
		
		String sql = "insert into tbl_process_201909 (w_workno,p_p1, p_p2, p_p3, p_p4, p_p5, p_p6, w_lastdate, w_lasttime) "
				   + "values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getW_workno());
			pstmt.setString(2, vo.getP_p1());
			pstmt.setString(3, vo.getP_p2());
			pstmt.setString(4, vo.getP_p3());
			pstmt.setString(5, vo.getP_p4());
			pstmt.setString(6, vo.getP_p5());
			pstmt.setString(7, vo.getP_p6());
			pstmt.setString(8, vo.getW_lastdate());
			pstmt.setString(9, vo.getW_lasttime());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt);
		}
		
	}

//	public void modify(Tbl_processVO pvo2) {
//		
//		String sql = "update tbl_process_201909 (w_workno,p_p1, p_p2, p_p3, p_p4, p_p5, p_p6, w_lastdate, w_lasttime) "
//				   + "values(?,?,?,?,?,?,?,?,?)";
//		try {
//			conn = dbm.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getW_workno());
//			pstmt.setString(2, vo.getP_p1());
//			pstmt.setString(3, vo.getP_p2());
//			pstmt.setString(4, vo.getP_p3());
//			pstmt.setString(5, vo.getP_p4());
//			pstmt.setString(6, vo.getP_p5());
//			pstmt.setString(7, vo.getP_p6());
//			pstmt.setString(8, vo.getW_lastdate());
//			pstmt.setString(9, vo.getW_lasttime());
//			
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			dbm.close(conn, pstmt);
//		}
//		
//	}
	
	
}
