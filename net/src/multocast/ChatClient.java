package multocast;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
	
	JTextArea textarea = new JTextArea();
	JTextField textfield = new JTextField();
	JButton button = new JButton("전송");
	JPanel panel = new JPanel(new BorderLayout());
	
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	String nickName = "[]";
	
	public ChatClient() {
		initUI();
		connectServer();
	}
	
	public void connectServer() {
		try {
			socket = new Socket("192.168.10.101", 5555);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 서버가 보낸 메세지를 읽어서 화면에 표시하는 작업을 수행할 스레드 생성
			ChatClientThread t = new ChatClientThread(textarea, in);
			t.start();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
	private void initUI() {
		panel.add(textfield, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);
		
		textarea.setEditable(false);
		add(new JScrollPane(textarea), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		button.addActionListener(event -> {
			try {
				// 입력창의 내용을 읽어서 서버로 보내기
				String text  = textfield.getText();
				out.println(nickName + text);
				
				// 입력창의 입력내용 지우기
				textfield.setText("");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		});
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		new ChatClient();
	}
}
