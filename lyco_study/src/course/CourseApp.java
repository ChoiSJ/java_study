package course;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CourseApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		CourseMGR cmgr = new CourseMGR();
		try {
			cmgr.professorLoad();
		} catch (Exception e) {
			FileOutputStream fos = new FileOutputStream("professor.sav");
			fos.close();
		}
		try {
			cmgr.studentLoad();
		} catch (Exception e) {
			FileOutputStream fos = new FileOutputStream("student.sav");
			fos.close();
		}
		try {
			cmgr.courseLoad();
		} catch (Exception e) {
			FileOutputStream fos = new FileOutputStream("course.sav");
			fos.close();
		}
		
		while (true) {
			System.out.println("------------------------------------------");
			System.out.println("1.교수가입  2.학생가입  3.교수로그인  4.학생로그인  0.종료");
			System.out.print("번호를 선택하세요:");
			int menu = sc.nextInt();
			System.out.println("------------------------------------------");
			if (menu == 1) {
				cmgr.proSignUp();
			} else if (menu == 2) {
				cmgr.stuSignUp();
			} else if (menu == 3) {
				cmgr.proLogin();
				if (cmgr.getLoginedProfessor() != null) {
					while (true) {
						System.out.println("------------------------------------------");
						System.out.println("1.과정등록  2.과정조회  3.등록학생조회  4.과정삭제  0.로그아웃");
						System.out.println("------------------------------------------");
						System.out.print("번호를 선택하세요:");
						int proMenu = sc.nextInt();
						if (proMenu == 1) {
							cmgr.proCourseRegister();
						} else if (proMenu == 2) {
							cmgr.ProCourseInfo();
						} else if (proMenu == 3) {
							cmgr.proCourseStuInfo();
						} else if (proMenu == 4) {
							cmgr.proCourseDelete();
						} else if (proMenu == 0) {
							System.out.println("로그아웃 되었습니다.");
							cmgr.setLoginedProfessor(null);
							break;
						}
 					}
				}
			} else if (menu == 4) {
				cmgr.stuLogin();
				if (cmgr.getLoginedStudent() != null) {
					while (true) {
						System.out.println("------------------------------------------");
						System.out.println("1.개설과정조회  2.수강신청  3.신청과목조회  4.신청과목취소  0.로그아웃");
						System.out.println("------------------------------------------");
						System.out.print("번호를 선택하세요:");
						int stuMenu = sc.nextInt();
						if (stuMenu == 1) {
							cmgr.stuCourseInfo();
						} else if (stuMenu == 2) {
							cmgr.stuCourseEntry();
						} else if (stuMenu == 3) {
							cmgr.stuCourseEntryInfo();
						} else if (stuMenu == 4) {
							cmgr.stuCourseDelete();
						} else if (stuMenu == 0) {
							System.out.println("로그아웃 되었습니다.");
							cmgr.setLoginedStudent(null);
							break;
						}
					}
				}
			} else if (menu == 0) {
				System.out.println("학사프로그램을 종료합니다.");
				break;
			}
		}
		
		sc.close();
	}
}
