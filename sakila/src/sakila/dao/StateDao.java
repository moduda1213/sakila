/*
 	1. 테이블 데이터를 오늘 날짜에 해당하는 컬럼을 가져온다.
 	2. 있다면 카운트 (방문 수 ) +1
 	3. 없다면 오늘날짜로 컬럼 추가
*/

package sakila.dao;

import java.sql.*;

import sakila.query.StateQuery;
import sakila.vo.*;

public class StateDao {
	//컬럼 추가해야하는지 업데이트 해야하는지 판단하기 위해
	public State selectDay(Connection conn, State state) throws Exception { //day가 있으면 true = update(오늘 날짜), 없으면 false = insert
		
		State returnState =null; // 해당 컬럼 데이터 저장
		PreparedStatement stmt = conn.prepareStatement(StateQuery.SELECT_DAY_ONE_STATE);
		stmt.setString(1, state.getDay()); // 오늘 날짜
		ResultSet rs = stmt.executeQuery();// 쿼리 실행
		
		if(rs.next()) {
			returnState = new State();
			returnState.setDay(rs.getString("day"));
			returnState.setCount(rs.getInt("count"));
		}
		
		return returnState; // 오늘 날짜와 카운트
	}
	//state table에 컬럼 추가
	public void insertState(Connection conn, State state) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StateQuery.INSERT_STATE);
		stmt.setString(1, state.getDay());
		stmt.executeUpdate();
	}
	//state table에 컬럼 수정
	public void updateState(Connection conn, State state) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StateQuery.UPDATE_STATE);
		stmt.setString(1, state.getDay());
		stmt.executeUpdate();
	}
	//총 방문자 수
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