package file.object;

import java.io.Serializable;

public class Rate implements Serializable {
	private static final long serialVersionUID = -3593743893674506835L;
	private double month;
	private double year;
	
	public double getMonth() {
		return month;
	}
	public void setMonth(double month) {
		this.month = month;
	}
	public double getYear() {
		return year;
	}
	public void setYear(double year) {
		this.year = year;
	}
}
