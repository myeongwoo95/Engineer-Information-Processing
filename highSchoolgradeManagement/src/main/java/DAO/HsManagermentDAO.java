package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_gradeVO;
import VO.Tbl_scoreVO;
import VO.Tbl_statisticsbyclassVO;
import VO.Tbl_studentVO;

public class HsManagermentDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	private static HsManagermentDAO instance = new HsManagermentDAO();
	private HsManagermentDAO() {}
	
	public static HsManagermentDAO getInstance() {
		return instance;
	}
	
	public void insertVO(Tbl_studentVO vo) {
		
		try {
			String sql = "insert into tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1 ,tel2 ,tel3) "
					   + "values(?,?,?,?,?,?,?,?,?)";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setString(4, vo.getSname());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getTel1());
			pstmt.setString(8, vo.getTel2());
			pstmt.setString(9, vo.getTel3());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt);
		}
		
	}
	
	public void insertScoreVO(Tbl_scoreVO vo) {
		
		try {
			String sql = "insert into tel_score_201905 (syear, sclass, sno, kor, eng, mat) "
					   + "values(?,?,?,?,?,?)";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setInt(4, vo.getKor());
			pstmt.setInt(5, vo.getEng());
			pstmt.setInt(6, vo.getMat());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt);
		}
		
	}

	public List<Tbl_gradeVO> getScoreView() {
		List<Tbl_gradeVO> list = new ArrayList<Tbl_gradeVO>();
		Tbl_gradeVO vo = null;
		
		try {
			 String sql = "select a.syear, a.sclass, a.sno, b.sname, b.gender, a.kor, a.eng, a.mat, "
					    + "(a.kor+a.eng+a.mat) as sum, "
					    + "to_char((a.kor+a.eng+a.mat)/3, '999.9') as avg "
					    + "from "
					    + "tel_score_201905 a, "
					    + "tbl_student_201905 b "
					    + "where " 
					    + "a.syear = b.syear and "
					    + "a.sclass = b.sclass and "
					    + "a.sno = b.sno "
					    + "group by a.syear, a.sclass, a.sno, b.sname, b.gender, a.kor, a.eng, a.mat "
					    + "order by sclass";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_gradeVO();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setSno(rs.getString("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setGender(rs.getString("gender"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setSum(rs.getInt("sum"));
				vo.setAvg(rs.getDouble("avg"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<Tbl_statisticsbyclassVO> getStatisticsByClass() {
		List<Tbl_statisticsbyclassVO> list = new ArrayList<Tbl_statisticsbyclassVO>();
		Tbl_statisticsbyclassVO vo = null;
		
		try {
			 String sql = "select a.syear, a.sclass, a.tname, sum(b.kor)as sum_kor, sum(b.eng) as sum_eng, sum(b.mat) as sum_mat, "
						+ "to_char(avg(b.kor), '999.9') as avg_kor, "
						+ "to_char(avg(b.eng), '999.9') as avg_eng, "
						+ "to_char(avg(b.mat), '999.9') as avg_mat "
						+ "from "
						+ "tbl_dept_201905 a, "
						+ "tel_score_201905 b "
						+ "where "
						+ "a.sclass = b.sclass "
						+ "group by "
						+ "a.syear, a.sclass, a.tname ";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_statisticsbyclassVO();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setTname(rs.getString("tname"));
				vo.setSum_kor(rs.getInt("sum_kor"));
				vo.setSum_eng(rs.getInt("sum_eng"));
				vo.setSum_mat(rs.getInt("sum_mat"));
				vo.setAvg_kor(rs.getDouble("avg_kor"));
				vo.setAvg_eng(rs.getDouble("avg_eng"));
				vo.setAvg_mat(rs.getDouble("avg_mat"));
				
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
