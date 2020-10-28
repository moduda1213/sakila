package sakila.dao;
import java.sql.*;

import sakila.vo.*;
import sakila.query.StaffQuery;

public class StaffDao {
	//id , pw 정보에 맞는 스태프의 id, username 불러오기
	/*
 	SELECT_STAFF_ID_PW =
			"SELECT staff_id, username FROM staff WHERE staff_id=? and password=?"
	 */
	public Staff selectStaffIDPW(Connection conn, Staff staff) throws Exception{
		System.out.println("StaffDao) selectStaffIDPW 진입");
		
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_ID_PW);
		System.out.println("StaffDao) selectStaffIDPW 쿼리 성공 "); //id, username
		stmt.setInt(1, staff.getStaffId());
		stmt.setString(2, staff.getPassword());
		//stmt.setNString(2, "PASSWORD("+staff.getPassword()+")"); => query -> password=?
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setUserName(rs.getString("username"));
			returnStaff.setStoreId(rs.getInt("store_id"));
		}
		//여기서 PASSWORD 함수 지정
		System.out.println("StaffDao) selectStaffIDPW 끝");

		return returnStaff;
	}
	
	public StaffInfo selectStaffInfo(Connection conn, int staffId) throws Exception{
		System.out.println("StaffDao) selectStaffInfo 진입");
		StaffInfo returnStaffInfo =null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_INFO);
		stmt.setInt(1, staffId);
		ResultSet rs = stmt.executeQuery();
		System.out.println("StaffDao) selectStaffInfo 데이터 불러오기");
		
		if(rs.next()) {
			returnStaffInfo = new StaffInfo();
			returnStaffInfo.setUserName(rs.getString("username"));
			returnStaffInfo.setFirstName(rs.getString("first_name"));
			returnStaffInfo.setLastName(rs.getString("last_name"));
			returnStaffInfo.setPhone(rs.getInt("phone"));
			returnStaffInfo.setCountry(rs.getString("country"));
			returnStaffInfo.setCity(rs.getString("city"));
			returnStaffInfo.setAddress(rs.getString("address"));
			returnStaffInfo.setEmail(rs.getString("email"));
			returnStaffInfo.setPicture(rs.getString("picture"));
		}
		System.out.println("StaffDao) selectStaffInfo 끝");
		return returnStaffInfo;
	}
}

