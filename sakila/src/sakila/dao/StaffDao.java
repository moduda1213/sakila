package sakila.dao;
import java.sql.*;
import sakila.vo.*;
import sakila.query.StaffQuery;

public class StaffDao {

	//id , pw 정보에 맞는 스태프의 id, username 불러오기
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
		}
		//여기서 PASSWORD 함수 지정
		System.out.println("StaffDao) selectStaffIDPW 끝");

		return returnStaff;
	}
}
/*
 	SELECT_STAFF_ID_PW =
			"SELECT staff_id, username FROM staff WHERE staff_id=? and password=?"
 */
