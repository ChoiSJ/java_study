package sample6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionUtil;

public class BankingService {
	public void 이체(String from, String to, int amount) {
		String sql1 = "update tb_account set balance = balance - ? where no = ? ";
		String sql2 = "update tb_account set balance = balance + ? where no = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			// -- tx begin
			
			// 송금계좌의 잔액을 변경하기
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, amount);
			pstmt.setString(2, from);
			pstmt.executeUpdate();
			
			pstmt.close();
			System.out.println("입금자 잔액 변경 완료");
			
			// 수신계좌의 잔액을 변경하기
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, amount*100000000);
			pstmt.setString(2, to);
			pstmt.executeUpdate();
			
			pstmt.close();
			System.out.println("수신자 잔액 변경 완료");
			
			// 현재 트랜잭션 내의 db access 작업을 반영시키기
			con.commit();
			System.out.println("모든 db access 작업 db에 반영");
			
		} catch (SQLException e) {
			System.out.println("에러발생");
			
			// 현재 트랜잭션 내의 db access 작업을 전부 취소시키기
			try {
				con.rollback();
			} catch (SQLException e1) {}
			System.out.println("모든 db access 작업 취소");
			
		} finally {
			// 연결해제
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
}
