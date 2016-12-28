package sample4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class StudentDAO {
	// 새로운 학생 정보 저장
	public void addNewStudent (StudentVO student) throws SQLException {
		String sql = "insert into tb_student (no, name, major, grade, phone, id, password) "
				+ "values (school_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getName());
		pstmt.setString(2, student.getMajor());
		pstmt.setInt(3, student.getGrade());
		pstmt.setString(4, student.getPhone());
		pstmt.setString(5, student.getId());
		pstmt.setString(6, student.getPassword());
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
	}
	
	// 학생번호로 학생 정보 찾기
	public StudentVO getStudentByNo(int no) throws SQLException {
		StudentVO vo = null;
		String sql = "select * from tb_student where no = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			vo = new StudentVO();
			vo.setNo(rs.getInt("no"));
			vo.setName(rs.getString("name"));
			vo.setMajor(rs.getString("major"));
			vo.setGrade(rs.getInt("grade"));
			vo.setPhone(rs.getString("phone"));
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return vo;
	}
	
	// 아이디로 학생 정보 찾기
	public StudentVO getStudentById(String id) throws SQLException {
		StudentVO vo = null;
		String sql = "select * from tb_student where id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			vo = new StudentVO();
			vo.setNo(rs.getInt("no"));
			vo.setName(rs.getString("name"));
			vo.setMajor(rs.getString("major"));
			vo.setGrade(rs.getInt("grade"));
			vo.setPhone(rs.getString("phone"));
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return vo;
	}
}
