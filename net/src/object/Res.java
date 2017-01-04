package object;

import java.io.Serializable;
import java.util.HashMap;

public class Res implements Serializable {
	
	private static final long serialVersionUID = 2L;
	private String result;
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	public Res() {}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
}
