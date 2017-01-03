package multocast;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class ChatClientThread extends Thread {

	private JTextArea textarea;
	private BufferedReader in;
	
	public ChatClientThread(JTextArea textarea, BufferedReader in) {
		this.textarea = textarea;
		this.in = in;
	}
	
	public void run() {
		
		try {
			while (true) {
				// 서버에서 보낸 메시지 읽기
				String message = in.readLine();
				
				// 메시지를 textarea 에 표시하기
				textarea.setCaretPosition(textarea.getText().length());
				textarea.append(message + "\n");
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
