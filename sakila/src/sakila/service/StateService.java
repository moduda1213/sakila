package sakila.service;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StateDao;
import sakila.vo.*;

public class StateService {
	private StateDao stateDao;
	
	public void countState() { // ī���� �ϴ� �޼���
		stateDao = new StateDao();
		final String URL ="";
		final String DBID ="root";
		final String DBPW ="java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("URL","DBID","DBPW");
			conn.setAutoCommit(false); // �ڵ� Ŀ�� �Ұ�
			//
			Calendar today = Calendar.getInstance(); // ���� ��¥ ���ϱ�
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); // ��¥ ���� yyyy-MM-dd
			String day = formater.format(today); // ���� ��¥�� ���Ŀ� �°� �� ����� ����
			State state = new State();
			state.setDay(day);
			
			if(stateDao.selectDay(conn, state)) { // �÷��� ����? true => ���� ��¥�� ����
				stateDao.updateState(conn, state);
			}else {								// false = ���� ��¥�� �߰�
				stateDao.insertState(conn, state);
			}
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
