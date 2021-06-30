package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_orderVO;
import VO.VaccinCountVO;
import VO.VaccinHistoryVO;

public class OrderDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	private static OrderDAO instance = new OrderDAO();
	private OrderDAO() {}
	
	public static OrderDAO getInstance() {
		return instance;
	}

	public void setVO(Tbl_orderVO vo) {
		
		try {
			String sql = "insert into tbl_order_201004 (p_seno, p_no, i_code, p_date)"
					+ " values(?, ?, ?, ?)";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_seno());
			pstmt.setString(2, vo.getP_no());
			pstmt.setString(3, vo.getI_code());
			pstmt.setString(4, vo.getP_date());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt);
		}
		
	}

	public List<VaccinHistoryVO> getVaccionhistoryList() {
		
		List<VaccinHistoryVO> list = new ArrayList<VaccinHistoryVO>();
		VaccinHistoryVO vo = null;
		
		try {
			 String sql = "select order1.p_seno, order1.p_no, cust.p_name, order1.i_code, injection.i_name, order1.p_date "
			            + "from "
			            + "tbl_order_201004 order1, "
			            + "tbl_cust_201004 cust, "
			            + "tbl_injection_201004 injection "
			            + "where order1.p_no = cust.p_no and order1.i_code = injection.i_code "
			            + "order by order1.p_no";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new VaccinHistoryVO();
				vo.setP_seno(rs.getInt("p_seno"));
				vo.setP_no(rs.getString("p_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setI_code(rs.getString("i_code"));
				vo.setI_name(rs.getString("i_name"));
				vo.setP_date(rs.getString("p_date").substring(0, 10));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<VaccinCountVO> getVaccionCountList() {
		List<VaccinCountVO> list = new ArrayList<VaccinCountVO>();
		VaccinCountVO vo = null;
		
		try {
			 String sql = "select a.i_code, b.i_name, count(a.i_code) as count from "
					 	+ "tbl_order_201004 a, "
			            + "tbl_injection_201004 b "
					    + "where a.i_code = b.i_code "
					    + "group by a.i_code, b.i_name "
					    + "order by a.i_code";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new VaccinCountVO();
				vo.setI_code(rs.getString("i_code"));
				vo.setI_name(rs.getString("i_name"));
				vo.setCount(rs.getInt("count"));
				
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
