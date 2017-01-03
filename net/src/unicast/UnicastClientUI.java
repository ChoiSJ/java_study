package unicast;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClientUI extends JFrame {
	
	JTextArea textarea = new JTextArea();
	JTextField textfield = new JTextField();
	JButton button = new JButton("조회");
	JPanel panel = new JPanel(new BorderLayout()); 
	
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	
	public UnicastClientUI() {
		try {
			socket = new Socket("192.168.10.101", 5555);
			
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		button.addActionListener(e -> {
			try {
				// textfield 의 값 읽기
				String text = textfield.getText();
			
				// 서버로 메세지 보내기
				out.println(text);
			
				// 서버가 보낸 메세지 받기
				String message = in.readLine();
				
				// 서버로부터 받은 메세지를 textarea 에 표시하기
				textarea.setText(message);
				
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		});
		
		add(new JScrollPane(textarea), BorderLayout.CENTER);
		
		panel.add(new JLabel(" 부서번호 "), BorderLayout.WEST);
		panel.add(textfield, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(100, 100, 250, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		new UnicastClientUI();
	}
}
