package dao;

import java.sql.*;
import utils.DBUtils;

public class BankAccountDaoImpl implements BankAccountDao {
	
	private Connection connection;
	private CallableStatement csb;
	public BankAccountDaoImpl() throws SQLException {
		
		connection = DBUtils.openConnection();
	}

	@Override
	public String transferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException {
		
		csb = connection.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		csb.registerOutParameter(4, Types.DOUBLE);
		csb.registerOutParameter(5, Types.DOUBLE);
		
		csb.setInt(1, srcAcNo);
		csb.setInt(2, destAcNo);
		csb.setDouble(3, amount);
		
		csb.execute();
		
		System.out.println("Updated Balance of source:"+csb.getDouble(4));  // retrive the result stored in out parameter
		System.out.println("Updated Balance of destination"+csb.getDouble(5));
		
		return "Balance Not get Updated";
		
	}

	@Override
	public String transFundByFunc(int  srcAcc, int  dstAcc, double amount) throws SQLException {
		
		  csb = connection.prepareCall("{? = call transfer_funds_func(?,?,?)}");
		  csb.setInt(2,srcAcc);
		  csb.setInt(3 ,dstAcc);
		  csb.setDouble(4, amount);
		  
		  csb.execute();   // return true or false;
		  
		  System.out.println("Destination account amount:"+csb.getDouble(1));
		  return "Balance get updated";
		
	}

}
