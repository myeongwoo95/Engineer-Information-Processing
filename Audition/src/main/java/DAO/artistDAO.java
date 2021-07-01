package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import VO.Tbl_artistVO;
import VO.Tbl_mentoPointVO;
import VO.Tbl_rankVO;


public class artistDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	private static artistDAO instance = new artistDAO();
	private artistDAO() {}
	
	public static artistDAO getInstance() {
		return instance;
	}

	public void insertVO(Tbl_artistVO vo) {
		
		try {
			String sql = "insert into tbl_artist_201905 (artist_id, artist_name, artist_gender, artist_birth, talent, agency) "
					   + "values(?,?,?,?,?,?)";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getArtist_id());
			pstmt.setString(2, vo.getArtist_name());
			pstmt.setString(3, vo.getArtist_gender());
			pstmt.setString(4, vo.getArtist_birth());
			pstmt.setString(5, vo.getTalent());
			pstmt.setString(6, vo.getAgency());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt);
		}
		
	}

	public List<Tbl_artistVO> getParticipantList() {
		List<Tbl_artistVO> list = new ArrayList<Tbl_artistVO>();
		Tbl_artistVO vo = null;
		
		try {
			 String sql = "select * from tbl_artist_201905";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_artistVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<Tbl_mentoPointVO> getMentoPointList() {
		List<Tbl_mentoPointVO> list = new ArrayList<Tbl_mentoPointVO>();
		Tbl_mentoPointVO vo = null;
		
		try {
			 String sql = "select a.serial_no, a.artist_id, b.artist_name, b.artist_birth, a.point,"
					    + "case when a.point >= 90 then 'A' "
				        + "when a.point >= 80 then 'B' "
				        + "when a.point >= 70 then 'C' "
				        + "when a.point >= 60 then 'D' "
				        + "when a.point < 60 then 'F' "
					    + "end as grade, "
					    + "c.mento_name "
					    + "from "
					    + "tbl_point_201905 a, "
					    + "tbl_artist_201905 b, "
					    + "tbl_memto_201905 c "
					    + "where "
					    + "a.artist_id = b.artist_id and "
					    + "a.mento_id = c.mento_id "
					    + "order by a.serial_no";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_mentoPointVO();
				vo.setSerial_no(rs.getInt("serial_no"));
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setPoint(rs.getInt("point"));
				vo.setGrade(rs.getString("grade"));
				vo.setMento_name(rs.getString("mento_name"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbm.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<Tbl_rankVO> getRankList() {
		List<Tbl_rankVO> list = new ArrayList<Tbl_rankVO>();
		Tbl_rankVO vo = null;
		
		try {
			 String sql = "select a.artist_id, b.artist_name, b.artist_gender, sum(point) as sum, TRIM(TO_CHAR(avg(point), '99999999.99')) as avg,"
				     	+ "DENSE_RANK() OVER (ORDER BY sum(point) DESC) as RANK "
				     	+ "from "
				        + "tbl_point_201905 a, "
				        + "tbl_artist_201905 b "
				        + "where a.artist_id = b.artist_id "
				        + "group by a.artist_id, b.artist_name, b.artist_gender";
			
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new Tbl_rankVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setSum(rs.getInt("sum"));
				vo.setAvg(rs.getDouble("avg"));
				vo.setRank(rs.getInt("rank"));
				
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
