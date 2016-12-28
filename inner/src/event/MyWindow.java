package event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow extends JFrame {
	public MyWindow() {
		this.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("저장");
		JButton btn2 = new JButton("취소");
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("저장버튼이 클릭되었습니다.");
			}
		});
		
		btn2.addActionListener((e) -> {System.out.println("취소버튼 클릭");});
		
		this.add(btn1);
		this.add(btn2);
		
		this.setBounds(100, 100, 300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyWindow();
	}
}
