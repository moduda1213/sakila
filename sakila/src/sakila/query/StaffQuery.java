package sakila.query;

public class StaffQuery {
	//Email(id), pw 불러오는 쿼리
	public static final String SELECT_STAFF_ID_PW =
			"SELECT staff_id, username FROM staff WHERE staff_id=? and password=PASSWORD(?)"; // ? -> PASSWORD('1234');
}
