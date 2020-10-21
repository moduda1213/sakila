package sakila.service;
import sakila.vo.*;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.dao.*;

public class StaffService {
	private StaffDao staffDao;
	
	public Staff getStaffIDPW(Staff staff) {
		System.out.println("StaffService) getStaffIDPW 진입");
		Staff returnStaff = null;
		Connection conn = null;
		
		try {
			System.out.println("StaffService) getStaffIDPW try 진입");
			//staff 잘 넘어왔는지 확인
			System.out.println("StaffService) staff id=> "+staff.getStaffId()+" staff pw=> "+ staff.getPassword());
			
			conn = DBUtil.connection();
			staffDao = new StaffDao();
			
			returnStaff = staffDao.selectStaffIDPW(conn, staff);
			
			conn.commit();
		}catch(Exception e) {
			try{
				System.out.println("StaffService) getStaffIDPW Exception catch");
				e.printStackTrace();
				conn.rollback();
			}catch(SQLException e1) {
				System.out.println("StaffService) getStaffIDPW SQLException catch");
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			}catch(SQLException e){
				System.out.println("StaffService) getStaffIDPW SQLException finally catch");
				e.printStackTrace();
			}
		}
		 
		return returnStaff;
	}
}
