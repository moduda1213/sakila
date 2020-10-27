package sakila.query;

public class StaffQuery {
	//Email(id), pw �ҷ����� ����
	public static final String SELECT_STAFF_ID_PW =
			"SELECT staff_id, username FROM staff WHERE staff_id=? and password=?"; // ? password=PASSWORD(?)
}

