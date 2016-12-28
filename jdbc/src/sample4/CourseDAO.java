package sample4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class CourseDAO {
	// 전체 수강신청 현황 조회하기
	public ArrayList<CourseVO> getAllCourseList() throws SQLException {
		String sql = "select * from course_detail_view ";
		
		ArrayList<CourseVO> courseList = new ArrayList<CourseVO>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CourseVO course = new CourseVO();
			
			StudentVO student = new StudentVO();
			student.setNo(rs.getInt("stud_no"));
			student.setName(rs.getString("stud_name"));
			student.setMajor(rs.getString("stud_major"));
			student.setGrade(rs.getInt("stud_grade"));
			
			SubjectVO subject = new SubjectVO();
			subject.setNo(rs.getInt("subject_no"));
			subject.setName(rs.getString("subject_name"));
			subject.setType(rs.getString("subject_type"));
			subject.setLimit(rs.getInt("subject_limit"));
			
			course.setStudent(student);
			course.setSubject(subject);
			
			courseList.add(course);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return courseList;
	}
	
	// 학생번호를 전달받아서 그 학생의 수강신청 현황 조회하기
	public ArrayList<CourseVO> getCourseListByStuNo(int no) throws SQLException {
		String sql = "select A.no as stud_no, A.name as stud_name, A.major as stud_major, A.phone as stud_phone, A.id as stud_id, "
				+ "B.no as subj_no, B.name as subj_name, B.limit as subj_limit, B.type as subj_type "
				+ "from tb_student A, tb_subject B, tb_course C "
				+ "where A.no = C.stud_no and B.no = C.subj_no and stud_no = ? ";

		ArrayList<CourseVO> courseList = new ArrayList<CourseVO>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CourseVO course = new CourseVO();
			StudentVO student = new StudentVO();
			student.setNo(rs.getInt("stud_no"));
			student.setName(rs.getString("stud_name"));
			student.setMajor(rs.getString("stud_major"));
			student.setPhone(rs.getString("stud_phone"));
			student.setId(rs.getString("stud_id"));
			
			SubjectVO subject = new SubjectVO();
			subject.setNo(rs.getInt("subj_no"));
			subject.setName(rs.getString("subj_name"));
			subject.setLimit(rs.getInt("subj_limit"));
			subject.setType(rs.getString("subj_type"));
			
			course.setStudent(student);
			course.setSubject(subject);
			
			courseList.add(course);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return courseList;
	}
	
	// 과목번호를 전달받아서 그 과목의 수강신청 현황 조회하기
	public ArrayList<CourseVO> getCourseListBySubNo(int no) throws SQLException {
		String sql = "select * from course_detail_view where subject_no = ? ";
		
		ArrayList<CourseVO> courseList = new ArrayList<CourseVO>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CourseVO course = new CourseVO();
			StudentVO student = new StudentVO();
			student.setNo(rs.getInt("stud_no"));
			student.setName(rs.getString("stud_name"));
			student.setMajor(rs.getString("stud_major"));
			student.setGrade(rs.getInt("stud_grade"));
			
			SubjectVO subject = new SubjectVO();
			subject.setNo(rs.getInt("subject_no"));
			subject.setName(rs.getString("subject_name"));
			subject.setType(rs.getString("subject_type"));
			subject.setLimit(rs.getInt("subject_limit"));
			
			ProfessorVO professor = new ProfessorVO();
			professor.setNo(rs.getInt("professor_no"));
			professor.setName(rs.getString("professor_name"));
			
			course.setStudent(student);
			subject.setProfessor(professor);
			course.setSubject(subject);
			
			courseList.add(course);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return courseList;
	}
	
	// 교수번호를 전달받아서 그 교수의 개설과목에 대한 수강신청 현황을 조회하기
	public ArrayList<CourseVO> getCourseListByProNo(int no) throws SQLException {
		String sql = "select * from course_detail_view where professor_no = ? order by subject_name asc ";

		ArrayList<CourseVO> courseList = new ArrayList<CourseVO>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			CourseVO course = new CourseVO();
			StudentVO student = new StudentVO();
			student.setNo(rs.getInt("stud_no"));
			student.setName(rs.getString("stud_name"));
			student.setMajor(rs.getString("stud_major"));
			student.setGrade(rs.getInt("stud_grade"));
			
			SubjectVO subject = new SubjectVO();
			subject.setNo(rs.getInt("subject_no"));
			subject.setName(rs.getString("subject_name"));
			subject.setType(rs.getString("subject_type"));
			subject.setLimit(rs.getInt("subject_limit"));
			
			ProfessorVO professor = new ProfessorVO();
			professor.setNo(rs.getInt("professor_no"));
			professor.setName(rs.getString("professor_name"));
			
			course.setStudent(student);
			subject.setProfessor(professor);
			course.setSubject(subject);
			
			courseList.add(course);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return courseList;
	}
}
