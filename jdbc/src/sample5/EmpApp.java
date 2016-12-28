package sample5;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpApp {
	public static void main(String[] args) throws SQLException {
		EmpDAO dao = new EmpDAO();
		ArrayList<Emp> employees = dao.getAllEmployees();
		
		for (Emp e : employees) {
			System.out.println(e.getFirstName() + " " + e.getSalaryWithComma() + " " + e.getHireDate());
		}
	}
}
