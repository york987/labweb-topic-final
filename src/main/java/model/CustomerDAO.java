package model;


public interface CustomerDAO {
	public abstract CustomerBean select(String custid);
	public abstract boolean update(String password, String email,
			java.util.Date birth, String custid);
}