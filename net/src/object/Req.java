package object;

import java.io.Serializable;
import java.util.HashMap;

public class Req implements Serializable {

	private static final long serialVersionUID = 1L;
	private String command;
	private HashMap<String, Object> data;
	
	public Req() {}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
}
