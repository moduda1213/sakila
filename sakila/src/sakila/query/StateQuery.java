package sakila.query;

public class StateQuery {
	public static final String SELECT_DAY_STATE = "SELECT * FROM state WHERE day=?"; //�ִ��� ������ ���� ����
	public static final String INSERT_STATE = "INSERT INTO state(day,count) VALUES(?,1)";
	public static final String UPDATE_STATE = "UPDATE state SET count=count+1 WHERE day=?";
}
