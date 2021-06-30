package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_companyVO;
import VO.Tbl_productVO;

public class CompanyDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	public List<Tbl_companyVO> getList() {
		
		List<Tbl_companyVO> list = new ArrayList<Tbl_companyVO>();
		Tbl_companyVO vo = null;
		
		try {
			String sql = "select * from tbl_company_202002";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_companyVO();
				vo.setC_code(rs.getString("c_code"));
				vo.setC_name(rs.getString("c_name"));
				vo.setC_tel1(rs.getString("c_tel1"));
				vo.setC_tel2(rs.getString("c_tel2"));
				vo.setC_tel3(rs.getString("c_tel3"));
				
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
