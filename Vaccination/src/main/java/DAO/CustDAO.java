package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_custVO;

public class CustDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	private static CustDAO instance = new CustDAO();
	private CustDAO() {}
	
	public static CustDAO getInstance() {
		return instance;
	}

	public List<Tbl_custVO> getList() {
		
		List<Tbl_custVO> list = new ArrayList<Tbl_custVO>();
		Tbl_custVO vo = null;
		
		try {
			String sql = "select * from tbl_cust_201004";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_custVO();
				vo.setP_no(rs.getString("p_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_birth(rs.getString("p_birth"));
				vo.setP_gender(rs.getString("p_gender"));
				vo.setP_tel1(rs.getString("p_tel1"));
				vo.setP_tel2(rs.getString("p_tel2"));
				vo.setP_tel3(rs.getString("p_tel3"));
				vo.setP_city(rs.getString("p_city"));
				
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
