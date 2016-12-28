package sample6;

public class BankingApp {
	public static void main(String[] args) {
		BankingService service = new BankingService();
		
		service.이체("11-11-11", "22-22-22", 50000);
	}
}
