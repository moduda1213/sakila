package sakila.dao;
import java.sql.*;
import sakila.vo.*;
import sakila.query.StaffQuery;

public class StaffDao {

	//id , pw ������ �´� �������� id, username �ҷ�����
	public Staff selectStaffIDPW(Connection conn, Staff staff) throws Exception{
		System.out.println("StaffDao) selectStaffIDPW ����");
		
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_ID_PW);
		System.out.println("StaffDao) selectStaffIDPW ���� ���� ");
		stmt.setInt(1, staff.getStaffId());
		stmt.setNString(2, staff.getPassword());
		//stmt.setNString(2, "PASSWORD("+staff.getPassword()+")"); => query -> password=?
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setUserName(rs.getString("username"));
		}
		// ���⼭ PASSWORD �Լ� ����
		System.out.println("StaffDao) selectStaffIDPW ��");

		return returnStaff;
	}
}
/*
 	SELECT_STAFF_ID_PW =
			"SELECT staff_id, username FROM staff WHERE staff_id=? and password=?"
 */
