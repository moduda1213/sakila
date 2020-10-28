package sakila.query;

public class StaffQuery {
	public static final String SELECT_STAFF_ID_PW =
			"SELECT staff_id, username,store_id FROM staff WHERE staff_id=? and password=?"; // ? password=PASSWORD(?)
	public static final String SELECT_STAFF_INFO =
			"SELECT s.username, s.first_name, s.last_name, a.phone, co.`country`, c.`city`, a.`address`, s.email,s.picture" + 
			"FROM staff S" + 
			"JOIN address a ON s.address_id = a.address_id" + 
			"JOIN city c ON a.city_id = c.city_id" + 
			"JOIN country co ON c.country_id = co.country_id" + 
			"WHERE staff_id = ?";
}

