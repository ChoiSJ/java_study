package file.object;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1857429712135877095L;
	private String name;
	private String accNumber;
	private long balance;
	private Rate rate;
	
	public Account() {}
	public Account(String name, String accNumber, long balance) {
		this.name = name;
		this.accNumber = accNumber;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public Rate getRate() {
		return rate;
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
}
