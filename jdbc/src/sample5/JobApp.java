package sample5;

import java.sql.SQLException;

public class JobApp {
	public static void main(String[] args) throws SQLException {
		JobDAO dao = new JobDAO();
		
		dao.getJobsBySalary(30000);
	}
}
