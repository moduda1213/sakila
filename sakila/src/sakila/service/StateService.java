package sakila.service;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StateDao;
import sakila.vo.*;

public class StateService {
	private StateDao stateDao;
	
	public void countState() { // 카운팅 하는 메서드
		stateDao = new StateDao();
		final String URL ="";
		final String DBID ="root";
		final String DBPW ="java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("URL","DBID","DBPW");
			conn.setAutoCommit(false); // 자동 커밋 불가
			//
			Calendar today = Calendar.getInstance(); // 오늘 날짜 구하기
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식 yyyy-MM-dd
			String day = formater.format(today); // 오늘 날짜를 형식에 맞게 한 결과를 저장
			State state = new State();
			state.setDay(day);
			
			if(stateDao.selectDay(conn, state)) { // 컬럼이 존재? true => 오늘 날짜로 수정
				stateDao.updateState(conn, state);
			}else {								// false = 오늘 날짜로 추가
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
