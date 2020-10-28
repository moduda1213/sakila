package sakila.service;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.DBUtil;
import sakila.dao.StateDao;
import sakila.vo.*;

public class StateService {
	private StateDao stateDao;

	public State getToday() { // getState, countState �޼��忡 �ߺ��Ǵ� �ڵ� -> getToday()
		//System.out.println("Service) getToday()");
		
		Calendar today = Calendar.getInstance(); // ���� ��¥ ���ϱ�
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); // ��¥ ���� yyyy-MM-dd
		System.out.println(formater +"<-formater)");
		
		String day = formater.format(today.getTime()); // ���� ��¥�� ���Ŀ� �°� �� ����� ����
		System.out.println(day +"<-day");
		
		State state = new State();
		state.setDay(day); // ���� ��¥ state vo�� day�� ����
		return state;
	}
	
	public State getState() { // �÷� ����� ���� �޼��� , -> ���� : public Map<String, Object> getState()
		//System.out.println("Service) getState()");
		State returnState = null; 
		
		stateDao = new StateDao();
		
		Connection conn = null;
		try {
			//System.out.println("Service) getState try ����");
			
			
			conn = DBUtil.connection();
			conn.setAutoCommit(false); // ���� ���������� �ϳ��� �۾����� �����Ű�� ����
			State state = this.getToday();
			
			returnState = stateDao.selectDay(conn, state);//���ǿ� �´� �÷� ����
			conn.commit();
		}catch(Exception e) {
			try {
				//System.out.println("Service) getState catch(Exception-try ����");
				conn.rollback();
			}catch(SQLException e1) {
				//System.out.println("Service) getState catch(Exception-catch ����");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				//System.out.println("Service) getState finally-try ����");
				conn.close();
			}catch(SQLException e){
				//System.out.println("Service) getState finally-catch ����");
				e.printStackTrace();
			}
		}
		System.out.println(returnState.getCount()+"returnState getCount()"); // ���� ȸ�� �湮 ��
		return returnState;
	}

	
	public void countState() { // ī���� �ϴ� �޼���
		//System.out.println("Service) countState()");
		stateDao = new StateDao();
		Connection conn = null;
		
		try {
			//System.out.println("Service) countState() try~");
			
			conn = DBUtil.connection();
			conn.setAutoCommit(false);
			State state = this.getToday();//state.day = ���ó�¥ // ����Ŭ������ �ִ� getToday�� ����ϱ� ���� this
			
			if(stateDao.selectDay(conn, state) == null) { // �÷��� ����? null => ���� ��¥�� insert
				//System.out.println("Service) insert");
				stateDao.insertState(conn, state); 
			}else {											// !null => ���� ��¥�� update
				//System.out.println("Service) update");
				stateDao.updateState(conn, state);
			}
			conn.commit();
		}catch(Exception e) { //�����߻� ��
			e.printStackTrace();
			try {
				//System.out.println("Service) countState() try~catch~Exception");
				e.printStackTrace();
				conn.rollback();
			}catch(SQLException e1) {
				//System.out.println("Service) countState() try~catch~SQLException");
				e1.printStackTrace();
			}
			
		}finally { // ������ ���İ�����
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






