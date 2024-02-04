package dao;

import static utils.DBUtils.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import pojos.Candidate;
import utils.DBUtils;

public class CandidateDaoImpl implements CandidateDao {
	private   Connection cn;
	private PreparedStatement pst1;

	public CandidateDaoImpl() throws SQLException {
		// open cn
		cn = DBUtils.getConnection();
		// pst1 : to get all candidates
		System.out.println("candidate dao created....");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		
		// create empty List
		List<Candidate> candidates = new ArrayList<>();
		pst1 = cn.prepareStatement("select * from candidates");
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}
	
	

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		
		System.out.println("candidate dao cleaned up....");
	}

	public Candidate getCandidateByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		 pst1 = cn.prepareStatement("select * from candidates where id =?");
		 ResultSet rst  = pst1.executeQuery();
		 if(rst.next())
			   return new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4));
		 
		 return null;
		 
	}

	public void updateVoteById(int id) throws SQLException {
		
		 pst1 = cn.prepareStatement("update candidates set votes=votes+1  where id = ?");
		 pst1.setInt(1, id);
		 int rowCount = pst1.executeUpdate();
		
	}

	public boolean getVotingStatus(int userId) throws SQLException {
		// TODO Auto-generated method stub
		pst1 = cn.prepareStatement("select  *  from users where id = ?");
		pst1.setInt(1, userId);
		ResultSet rst = pst1.executeQuery();
		if(rst.next()) {
			 if(rst.getInt(7)==1)
				 return true;
		}
	
		return false;
	}

	public List<Candidate> maxVoteCandidate() throws SQLException {
		// TODO Auto-generated method stub
		pst1  = cn.prepareStatement("select * from candidates order by votes  desc  LIMIT 2");
		List< Candidate> ans = new ArrayList<Candidate>();
		
		ResultSet rst = pst1.executeQuery();
		while(rst.next()) {
			Candidate c1 = new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4));
			ans.add(c1);
		}
		return ans;
	}

	public boolean registerCandidate(String name, String party) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstc = cn.prepareStatement("Insert into candidates values(default,?,?,?");
		pstc.setString(1, name);
		pstc.setString(2, party);
		pstc.setInt(3, 0);
		int count = pstc.executeUpdate();
		if(count ==1)
			 return true;
		
		return false;
	}

}
