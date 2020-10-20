package sakila.dao;

import java.sql.*;
import sakila.vo.*;

public class StateDao {
	//컬럼 추가해야하는지 업데이트 해야하는지 판단하기 위해
	public boolean selectDay(Connection conn, State state) throws Exception { //day가 있으면 true = update(오늘 날짜), 없으면 false = insert
		/*
		if(rs.next()) {
			return true; // update
		}
		*/
		return false; // insert
	}
	//state table에 컬럼 추가
	public void insertState(Connection conn, State state) throws Exception {
		
	}
	//state table에 컬럼 수정
	public void updateState(Connection conn, State state) throws Exception {
		
	}
}
