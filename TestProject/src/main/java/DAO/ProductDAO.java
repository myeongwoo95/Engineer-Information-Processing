package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_productVO;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	public List<Tbl_productVO> getList() {
		
		List<Tbl_productVO> list = new ArrayList<Tbl_productVO>();
		Tbl_productVO vo = null;
		
		try {
			String sql = "select * from tbl_product_202002";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_productVO();
				vo.setP_code(rs.getString("p_code"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_size(rs.getInt("p_size"));
				vo.setP_incost(rs.getInt("p_incost"));
				vo.setP_outcost(rs.getInt("p_outcost"));
				
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
