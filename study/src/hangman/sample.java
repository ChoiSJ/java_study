package hangman;

import java.sql.SQLException;
import java.util.ArrayList;

public class sample {
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<String> voca = new HangmanDAO().getHangmanVocaburaly();
		
		for (String s : voca) {
			System.out.println(s);
		}
		
	}
}
