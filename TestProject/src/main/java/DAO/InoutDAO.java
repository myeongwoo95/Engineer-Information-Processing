package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_companyVO;
import VO.Tbl_inoutVO;
import VO.Tbl_productVO;
import VO.Tbl_salesVO;

public class InoutDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	public int getMaxTno() {
		
		int maxTno = 0;
		
		try {
			String sql = "select max(t_no) as t_no from tbl_inout_202002";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxTno = rs.getInt("t_no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return maxTno;
	}

	public int insert(Tbl_inoutVO vo) {
		int result = -1;
		
		try {
			String sql = "insert into tbl_inout_202002 (t_no, p_code, t_type, t_cnt, t_date, c_code)"
					+ " values(?, ?, ?, ?, ?, ?)";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getT_no());
			pstmt.setString(2, vo.getP_code());
			pstmt.setString(3, vo.getT_type());
			pstmt.setInt(4, vo.getT_cnt());
			pstmt.setString(5, vo.getT_date());
			pstmt.setString(6, vo.getC_code());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt);
		}
		return result;
	}

	public List<Tbl_salesVO> getSalesList() {
		
		List<Tbl_salesVO> list = new ArrayList<Tbl_salesVO>();
		Tbl_salesVO vo = null;
		
		try {
			 String sql = "select a.p_code, b.p_name, a.sum, "
						+ "a.sum*(b.p_outcost - b.p_incost) as cost "
						+ "from ( select p_code, sum(t_cnt)as sum "
						+ "from (select "
						+ "distinct p_code, t_cnt "
						+ "from tbl_inout_202002 "
						+ "where t_type = 'O' "
						+ "group by p_code, t_cnt) " 
						+ "group by p_code) a, "
						+ "tbl_product_202002 b "
						+ "where a.p_code = b.p_code " 
						+ "order by p_code asc";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_salesVO();
				vo.setP_code(rs.getString("p_code"));
				vo.setP_name(rs.getString("p_name"));
				vo.setSum(rs.getInt("sum"));
				vo.setCost(rs.getInt("cost"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<Tbl_inoutVO> getinoutList() {
		
		List<Tbl_inoutVO> list = new ArrayList<Tbl_inoutVO>();
		Tbl_inoutVO vo = null;
		
		try {
			 String sql = "select inout.t_no, "
				         +"product.p_code, "
				         +"product.p_name, "
				         +"inout.t_type, "
				         +"inout.t_cnt, "
				         +"company.c_name, "
				         +"inout.t_date "
					     +"from  tbl_inout_202002 inout, "
				         +"tbl_company_202002 company, "
				         +"tbl_product_202002 product "
					     +"where product.p_code = inout.p_code and "
				         +"company.c_code = inout.c_code "
					     +"order by t_no";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_inoutVO();
				vo.setT_no(rs.getString("t_no"));
				vo.setP_code(rs.getString("p_code"));
				vo.setP_name(rs.getString("p_name"));
				vo.setT_type(rs.getString("t_type"));
				vo.setT_cnt(rs.getInt("t_cnt"));
				vo.setC_name(rs.getString("c_name"));
				vo.setT_date(rs.getString("t_date").substring(0,10));
				
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
