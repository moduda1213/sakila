package sakila.dao;

import java.sql.*;
import sakila.vo.*;

public class StateDao {
	//�÷� �߰��ؾ��ϴ��� ������Ʈ �ؾ��ϴ��� �Ǵ��ϱ� ����
	public boolean selectDay(Connection conn, State state) throws Exception { //day�� ������ true = update(���� ��¥), ������ false = insert
		/*
		if(rs.next()) {
			return true; // update
		}
		*/
		return false; // insert
	}
	//state table�� �÷� �߰�
	public void insertState(Connection conn, State state) throws Exception {
		
	}
	//state table�� �÷� ����
	public void updateState(Connection conn, State state) throws Exception {
		
	}
}
