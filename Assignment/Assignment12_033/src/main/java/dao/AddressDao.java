package dao;

public interface AddressDao {

	void assignAddressLink(String next, String next2, String next3,String next4, long nextLong);

	void displayAddress(long id);

	void displayNameByAddress(String next);
    
}
