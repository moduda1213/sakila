package sakila.service;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.DBUtil;
import sakila.dao.StateDao;
import sakila.vo.*;

public class StateService {
	private StateDao stateDao;

	public State getToday() { // getState, countState 메서드에 중복되는 코드 -> getToday()
		//System.out.println("Service) getToday()");
		
		Calendar today = Calendar.getInstance(); // 오늘 날짜 구하기
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식 yyyy-MM-dd
		System.out.println(formater +"<-formater)");
		
		String day = formater.format(today.getTime()); // 오늘 날짜를 형식에 맞게 한 결과를 저장
		System.out.println(day +"<-day");
		
		State state = new State();
		state.setDay(day); // 오늘 날짜 state vo에 day에 저장
		return state;
	}
	
	public State getState() { // 컬럼 출력을 위한 메서드 , -> 최종 : public Map<String, Object> getState()
		//System.out.println("Service) getState()");
		State returnState = null; 
		
		stateDao = new StateDao();
		
		Connection conn = null;
		try {
			//System.out.println("Service) getState try 진입");
			
			
			conn = DBUtil.connection();
			conn.setAutoCommit(false); // 여러 쿼리문장을 하나의 작업으로 수행시키기 위해
			State state = this.getToday();
			
			returnState = stateDao.selectDay(conn, state);//조건에 맞는 컬럼 저장
			conn.commit();
		}catch(Exception e) {
			try {
				//System.out.println("Service) getState catch(Exception-try 진입");
				conn.rollback();
			}catch(SQLException e1) {
				//System.out.println("Service) getState catch(Exception-catch 진입");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				//System.out.println("Service) getState finally-try 진입");
				conn.close();
			}catch(SQLException e){
				//System.out.println("Service) getState finally-catch 진입");
				e.printStackTrace();
			}
		}
		System.out.println(returnState.getCount()+"returnState getCount()"); // 현재 회원 방문 수
		return returnState;
	}

	
	public void countState() { // 카운팅 하는 메서드
		//System.out.println("Service) countState()");
		stateDao = new StateDao();
		Connection conn = null;
		
		try {
			//System.out.println("Service) countState() try~");
			
			conn = DBUtil.connection();
			conn.setAutoCommit(false);
			State state = this.getToday();//state.day = 오늘날짜 // 내부클래스에 있는 getToday를 사용하기 위한 this
			
			if(stateDao.selectDay(conn, state) == null) { // 컬럼이 존재? null => 오늘 날짜로 insert
				//System.out.println("Service) insert");
				stateDao.insertState(conn, state); 
			}else {											// !null => 오늘 날짜로 update
				//System.out.println("Service) update");
				stateDao.updateState(conn, state);
			}
			conn.commit();
		}catch(Exception e) { //에러발생 시
			e.printStackTrace();
			try {
				//System.out.println("Service) countState() try~catch~Exception");
				e.printStackTrace();
				conn.rollback();
			}catch(SQLException e1) {
				//System.out.println("Service) countState() try~catch~SQLException");
				e1.printStackTrace();
			}
			
		}finally { // 무조건 거쳐가야함
			try {
				//System.out.println("Service) countState() finally-try");
				conn.close(); 
			}catch(SQLException e){
				//System.out.println("Service) countState() finally-catch");
				e.printStackTrace();
			}
		}
	}
	
	public int getTotalCount() {
		//System.out.println("Service) getTotalCount()");
		int totalCount=0;
		stateDao = new StateDao();
		Connection conn = null;
		
		try {
			conn = DBUtil.connection();
			
			totalCount = stateDao.totalCount(conn);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close(); 
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	
}






