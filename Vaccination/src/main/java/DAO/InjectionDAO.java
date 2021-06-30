package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBManager.DBManager;

public class InjectionDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = new DBManager();
	
	private static InjectionDAO instance = new InjectionDAO();
	private InjectionDAO() {}
	
	public static InjectionDAO getInstance() {
		return instance;
	}

}
