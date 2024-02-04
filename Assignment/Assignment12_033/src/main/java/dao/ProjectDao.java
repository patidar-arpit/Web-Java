package dao;

public interface ProjectDao {
	
	public String addProject(String title,String startDate, String endDate);

	public void assignEmployee(long empId, long projectId);

}
