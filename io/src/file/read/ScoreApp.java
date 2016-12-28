package file.read;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ScoreApp {
	public static void main(String[] args) throws Exception {
		
		ArrayList<Score> scoreList = new ArrayList<Score>();
		Scanner sc = new Scanner(System.in);
		FileOutputStream fos = new FileOutputStream("score.txt");
		
		// 1. 성적정보 등록		2. 성적정보 파일로 저장		0. 종료
		while (true) {
			System.out.println("1.성적정보 등록  2.성적정보 파일로 저장  3.성적정보 정렬 0.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				// 이름, 국어, 영어, 수학점수를 입력받아서 Score 객체에 담고 ArrayList 에 저장하기
				System.out.print("이름을 입력하세요:");
				String name = sc.nextLine();
				System.out.print("국어점수를 입력하세요:");
				String kor = sc.nextLine();
				System.out.print("영어점수를 입력하세요:");
				String eng = sc.nextLine();
				System.out.print("수학점수를 입력하세요:");
				String math = sc.nextLine();
			
				Score score = new Score();
				score.setName(name);
				score.setKor(Integer.parseInt(kor));
				score.setEng(Integer.parseInt(eng));
				score.setMath(Integer.parseInt(math));
				scoreList.add(score);
			} else if (menu == 2) {
				// ArrayList 에 저장된 성적정보를 파일로 기록하기
				// 홍길동^80^60^30
				// 김유신^40^50^70
				
				for (Score score : scoreList) {
					String kor =String.valueOf(score.getKor());
					String eng =String.valueOf(score.getEng());
					String math =String.valueOf(score.getMath());
					//String result = (score.getName() + "^" + kor + "^" + eng + "^" + math);
					
					//byte[] bytes = result.getBytes();
					//fos.write(bytes);
				}
				
			} else if (menu == 3) {
				Comparator<Score> scCompare = new Comparator<Score>() {
					public int compare(Score s1, Score s2) {
						return s2.getTotal() - s1.getTotal();
					}
				};
				
				Collections.sort(scoreList, scCompare);
				
				for (Score score : scoreList) {
					String kor =String.valueOf(score.getKor());
					String eng =String.valueOf(score.getEng());
					String math =String.valueOf(score.getMath());
					String result = (score.getName() + "^" + kor + "^" + eng + "^" + math + "^" + score.getTotal() + System.lineSeparator());
					
					byte[] bytes = result.getBytes();
					fos.write(bytes);
				}
			} else if (menu == 0) {
				break;
			}
		}
		
		sc.close();
		fos.close();
	}
}
