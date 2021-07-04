package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
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
			 String sql = "";
			
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
				vo.setW_workdate(rs.getString("w_workdate"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
}
