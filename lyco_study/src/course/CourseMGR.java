package course;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class CourseMGR {
	private ArrayList<Professor> proList = new ArrayList<Professor>();
	private ArrayList<Student> stuList = new ArrayList<Student>();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private Professor loginedProfessor;
	private Student loginedStudent;
	
	private Scanner sc = new Scanner(System.in);
	
	public CourseMGR() {
	}
	
	public Professor getLoginedProfessor() {
		return loginedProfessor;
	}
	public void setLoginedProfessor(Professor loginedProfessor) {
		this.loginedProfessor = loginedProfessor;
	}
	public Student getLoginedStudent() {
		return loginedStudent;
	}
	public void setLoginedStudent(Student loginedStudent) {
		this.loginedStudent = loginedStudent;
	}

	public void proSignUp() throws IOException {
		Calendar car = Calendar.getInstance();
		Professor pro = new Professor();
		Random ran = new Random();
		
		System.out.println("------------------------------------------");
		System.out.print("사용하실 아이디를 입력하세요:");
		String proId = sc.nextLine();
		System.out.print("사용하실 비밀번호를 입력하세요:");
		String proPassword = sc.nextLine();
		for (Professor proIdCheck : proList) {
			if (proIdCheck.getProId().equals(proId)) {
				System.out.println("등록된 아이디가 있습니다.");
				return;
			}
		}
		
		pro.setProId(proId);
		pro.setProPassword(proPassword);
		System.out.print("이름을 입력하세요:");
		pro.setName(sc.nextLine());
		System.out.print("전공을 입력하세요:");
		pro.setMajor(sc.nextLine());
		System.out.print("직책을 입력하세요:");
		pro.setPosition(sc.nextLine());
		
		String year = String.valueOf(car.get(Calendar.YEAR));
		String[] proNoArr = new String[3];
		for (int i=0; i<proNoArr.length; i++) {
			int no = ran.nextInt(9);
			proNoArr[i] = String.valueOf(no);
		}
		int proNo = Integer.parseInt(year + proNoArr[0] + proNoArr[1] + proNoArr[2]);
		
		for (Professor pro2 : proList) {
			while (pro2.getProNo() == proNo) {
				proNo = 0;
				for (int i=0; i<proNoArr.length; i++) {
					int no = ran.nextInt(9);
					proNoArr[i] = String.valueOf(no);
				}
				proNo = Integer.parseInt(year + proNoArr[0] + proNoArr[1] + proNoArr[2]);
			}
		}
		System.out.println("교수님의 번호는 " + proNo + " 입니다");
		pro.setProNo(proNo);
		System.out.println("가입이 완료되었습니다.");
		
		proList.add(pro);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("professor.sav"));
		oos.writeObject(proList);
		oos.close();
	}
	
	public void stuSignUp() throws IOException {
		Calendar car = Calendar.getInstance();
		Student stu = new Student();
		Random ran = new Random();
		
		System.out.println("------------------------------------------");
		System.out.print("사용하실 아이디를 입력하세요:");
		String stuId = sc.nextLine();
		System.out.print("사용하실 비밀번호를 입력하세요:");
		String stuPassword = sc.nextLine();
		for (Student stuIdCheck : stuList) {
			if (stuIdCheck.getStuId().equals(stuId)) {
				System.out.println("등록된 아이디가 있습니다.");
				return;
			}
		}
		
		stu.setStuId(stuId);
		stu.setStuPassword(stuPassword);
		System.out.print("이름을 입력하세요:");
		stu.setName(sc.nextLine());
		System.out.print("전공을 입력하세요:");
		stu.setMajor(sc.nextLine());
		System.out.print("학년을 입력하세요:");
		stu.setGrade(Integer.parseInt(sc.nextLine()));
		
		String year = String.valueOf(car.get(Calendar.YEAR));
		String[] stuNoArr = new String[4];
		for (int i=0; i<stuNoArr.length; i++) {
			int no = ran.nextInt(9);
			stuNoArr[i] = String.valueOf(no);
		}
		int stuNo = Integer.parseInt(year + stuNoArr[0] + stuNoArr[1] + stuNoArr[2] + stuNoArr[3]);
		
		for (Student stu2 : stuList) {
			while (stu2.getStuNo() == stuNo) {
				stuNo = 0;
				for (int i=0; i<stuNoArr.length; i++) {
					int no = ran.nextInt(9);
					stuNoArr[i] = String.valueOf(no);
				}
				stuNo = Integer.parseInt(year + stuNoArr[0] + stuNoArr[1] + stuNoArr[2] + stuNoArr[3]);
			}
		}
		System.out.println("학생의 학번은 " + stuNo + " 입니다");
		stu.setStuNo(stuNo);
		System.out.println("가입이 완료되었습니다.");
		
		stuList.add(stu);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.sav"));
		oos.writeObject(stuList);
		oos.close();
	}
	
	public void proLogin() {
		System.out.println("------------------------------------------");
		System.out.print("아이디를 입력하세요:");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String password = sc.nextLine();
		
		for (Professor pro : proList) {
			if (id.equals(pro.getProId())) {
				if (password.equals(pro.getProPassword())) {
					System.out.println(pro.getName() + "님이 로그인하였습니다.");
					loginedProfessor = pro;
				}
			}
		}
		
		if (loginedProfessor == null) {
			System.out.println("아이디 혹은 패스워드를 잘못 입력하셨습니다.");
		}
	}
	
	public void stuLogin() { 
		System.out.println("------------------------------------------");
		System.out.print("아이디를 입력하세요:");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String password = sc.nextLine();
		
		for (Student stu : stuList) {
			if (id.equals(stu.getStuId())) {
				if (password.equals(stu.getStuPassword())) {
					System.out.println(stu.getName() + "님이 로그인하였습니다.");
					loginedStudent = stu;
				}
			}
		}
		
		if (loginedStudent == null) {
			System.out.println("아이디 혹은 패스워드를 잘못 입력하셨습니다.");
		}
	}
	
	public void proCourseRegister() throws FileNotFoundException, IOException, ClassNotFoundException {
		Course cou = new Course();
		
		System.out.println("------------------------------------------");
		System.out.print("개설하실 과목 넘버를 입력하세요:");
		int proNo = Integer.parseInt(sc.nextLine());
		System.out.print("과목명을 입력하세요:");
		String name = sc.nextLine();
		for (Course proCorCheck : courseList) {
			if (proCorCheck.getPro().getProId().equals(loginedProfessor.getProId())) {
				if (proNo == proCorCheck.getCourseNo() && proCorCheck.getCourseName().equals(name)) {
					System.out.println("이미 같은 이름의 강의를 등록하셨습니다.");
					return;
				}
			}
		}
		cou.setCourseNo(proNo);
		cou.setCourseName(name);
		System.out.print("수강인원을 입력하세요:");
		int stuNumber = Integer.parseInt(sc.nextLine());
		cou.setLimitedNumber(stuNumber);
		cou.setMaxNumber(stuNumber);
		cou.setPro(loginedProfessor);
		System.out.println("등록이 완료되었습니다.");
		courseList.add(cou);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.sav"));
		oos.writeObject(courseList);
		oos.close();
	}
	
	public void ProCourseInfo() {
		System.out.println("------------------------------------------");
		for (Course cou : courseList) {
			if (cou.getPro().getProId().equals(loginedProfessor.getProId())) {
				System.out.println("강의번호:" + cou.getCourseNo());
				System.out.println("강 의 명:" + cou.getCourseName());
				System.out.println("수강인원:" + cou.getMaxNumber() + "/" + cou.getLimitedNumber());
				System.out.println("------------------------------------------");
			}
		}
	}

	public void proCourseStuInfo() {
		System.out.println("------------------------------------------");
		for (Course cou : courseList) {
			if (cou.getPro().getProId().equals(loginedProfessor.getProId())) {
				System.out.println("강의번호:" + cou.getCourseNo());
				System.out.println("강 의 명:" + cou.getCourseName());
				System.out.println("수강인원:" + cou.getMaxNumber() + "/" + cou.getLimitedNumber());
				System.out.println("------------------------------------------");
				for (int i=0; i<cou.getStuList().size(); i++) {
					System.out.println("학생번호:" + i+1);
					System.out.println("학생학번:" + cou.getStuList().get(i).getStuNo());
					System.out.println("학생이름:" + cou.getStuList().get(i).getName());
					System.out.println("학생전공:" + cou.getStuList().get(i).getMajor());
					System.out.println("학생학년:" + cou.getStuList().get(i).getGrade());
					System.out.println("------------------------------------------");
				}
			}
		}
	}

	public void proCourseDelete() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.sav"));
		boolean isCancel = false;
		System.out.println("------------------------------------------");
		System.out.print("삭제할 강의번호를 입력하세요:");
		int courseNo = Integer.parseInt(sc.nextLine());
		System.out.print("삭제할 강의명을 입력하세요:");
		String courseName = sc.nextLine();
		for (Course cou : courseList) {
			if (cou.getPro().getProId().equals(loginedProfessor.getProId())) {
				if (cou.getCourseName().equals(courseName) && cou.getCourseNo() == courseNo) {
					System.out.println("강의가 성공적으로 삭제되었습니다.");
					courseList.remove(cou);
					break;
				}
			}
		}
		if (!isCancel) {
			System.out.println("잘못된 입력입니다.");
		}
		
		oos.writeObject(courseList);
		oos.close();
	}
	
	public void stuCourseInfo() {
		System.out.println("------------------------------------------");
		for (Course cou : courseList) {
			System.out.println("강의번호:" + cou.getCourseNo());
			System.out.println("강 의 명:" + cou.getCourseName());
			System.out.println("수강인원:" + cou.getMaxNumber() + "/" + cou.getLimitedNumber());
			System.out.println("담당교수:" + cou.getPro().getName());
			System.out.println("------------------------------------------");
		}
	}
	
	public void stuCourseEntry() throws FileNotFoundException, IOException {
		boolean isExist = false;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.sav"));
		System.out.println("------------------------------------------");
		System.out.print("신청할 과목명의 번호를 입력하세요:");
		int courseNumber = Integer.parseInt(sc.nextLine());
		System.out.print("신청할 과목명을 입력하세요:");
		String courseName = sc.nextLine();
		for (Course cou : courseList) {
			if (cou.getCourseNo() == courseNumber && cou.getCourseName().equals(courseName)) {
				if (cou.getLimitedNumber() == 0) {
					System.out.println("수강신청이 마감되었습니다.");
					isExist = true;
					break;
				}
				for (Student stu : cou.getStuList()) {
					if(stu.getStuId().equals(loginedStudent.getStuId())) {
						System.out.println("이미 등록하셨습니다.");
						return;
					}
				}
				
				System.out.println("신청이 접수되었습니다.");
				cou.getStuList().add(loginedStudent);
				cou.setLimitedNumber(cou.getLimitedNumber()-1);
				oos.writeObject(courseList);
				isExist = true;
				oos.close();
			} 		
		}
		if (!isExist) {
			System.out.println("해당 과목이 존재하지 않습니다.");
		}
		
		oos.close();
	}
	
	public void stuCourseEntryInfo() {
		System.out.println("------------------------------------------");
		for (Course cou : courseList) {
			for (Student stu : cou.getStuList()) {
				if (stu.getStuId().equals(loginedStudent.getStuId())) {
					System.out.println("강의번호:" + cou.getCourseNo());
					System.out.println("강 의 명:" + cou.getCourseName());
					System.out.println("수강인원:" + cou.getMaxNumber() + "/" + cou.getLimitedNumber());
					System.out.println("담당교수:" + cou.getPro().getName());
					System.out.println("------------------------------------------");
				}
			}
		}
	}
	
	public void stuCourseDelete() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.sav"));
		boolean isCancel = false;
		System.out.println("------------------------------------------");
		System.out.print("취소할 강의번호를 입력하세요:");
		int courseNo = Integer.parseInt(sc.nextLine());
		System.out.print("취소할 강의명을 입력하세요:");
		String courseName = sc.nextLine();
		for (Course cou : courseList) {
			for (Student stu : cou.getStuList()) {
				if (stu.getStuId().equals(loginedStudent.getStuId())) {
					if (cou.getCourseName().equals(courseName) && cou.getCourseNo() == courseNo) {
						System.out.println("강의가 성공적으로 취소되었습니다.");
						cou.getStuList().remove(stu);
						cou.setLimitedNumber(cou.getLimitedNumber()+1);
						isCancel = true;
						break;
					}
				}
			}
		}
		if (!isCancel) {
			System.out.println("잘못된 입력입니다.");
		}
		
		oos.writeObject(courseList);
		oos.close();
	}
	
	public void professorLoad() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("professor.sav"));
		ArrayList<Professor> pro = (ArrayList<Professor>) ois.readObject();
		proList = pro;
		ois.close();
	}
	
	public void studentLoad() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.sav"));
		ArrayList<Student> stu = (ArrayList<Student>) ois.readObject();
		stuList = stu;
		ois.close();
	}
	
	public void courseLoad() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("course.sav"));
		ArrayList<Course> cor = (ArrayList<Course>) ois.readObject();
		courseList = cor;
		ois.close();
	}
}
