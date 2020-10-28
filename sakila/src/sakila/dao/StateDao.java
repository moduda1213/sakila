/*
 	1. ���̺� �����͸� ���� ��¥�� �ش��ϴ� �÷��� �����´�.
 	2. �ִٸ� ī��Ʈ (�湮 �� ) +1
 	3. ���ٸ� ���ó�¥�� �÷� �߰�
*/

package sakila.dao;

import java.sql.*;

import sakila.query.StateQuery;
import sakila.vo.*;

public class StateDao {
	//�÷� �߰��ؾ��ϴ��� ������Ʈ �ؾ��ϴ��� �Ǵ��ϱ� ����
	public State selectDay(Connection conn, State state) throws Exception { //day�� ������ true = update(���� ��¥), ������ false = insert
		
		State returnState =null; // �ش� �÷� ������ ����
		PreparedStatement stmt = conn.prepareStatement(StateQuery.SELECT_DAY_ONE_STATE);
		stmt.setString(1, state.getDay()); // ���� ��¥
		ResultSet rs = stmt.executeQuery();// ���� ����
		
		if(rs.next()) {
			returnState = new State();
			returnState.setDay(rs.getString("day"));
			returnState.setCount(rs.getInt("count"));
		}
		
		return returnState; // ���� ��¥�� ī��Ʈ
	}
	//state table�� �÷� �߰�
	public void insertState(Connection conn, State state) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StateQuery.INSERT_STATE);
		stmt.setString(1, state.getDay());
		stmt.executeUpdate();
	}
	//state table�� �÷� ����
	public void updateState(Connection conn, State state) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StateQuery.UPDATE_STATE);
		stmt.setString(1, state.getDay());
		stmt.executeUpdate();
	}
	//�� �湮�� ��
	public int totalCount(Connection conn) throws Exception{
		int totalCount = 0;
		
		PreparedStatement stmt = conn.prepareStatement(StateQuery.SELECT_DAY_TOTAL_COUNT_STATE);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			totalCount += rs.getInt("count");
		}
		
		return totalCount;
	}
}
/*
 	public static final String SELECT_DAY_STATE = "SELECT * FROM state WHERE day=?";
	public static final String INSERT_STATE = "INSERT INTO state(day,count) VALUES(?,1)";
	public static final String UPDATE_STATE = "UPDATE state SET count=count+1 WHERE day=?";
*/