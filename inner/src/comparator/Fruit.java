package comparator;

public class Fruit {
	private String name;
	private String color;
	private int price;
	private int kal;
	
	public Fruit() {}

	public Fruit(String name, String color, int price, int kal) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.kal = kal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKal() {
		return kal;
	}

	public void setKal(int kal) {
		this.kal = kal;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", color=" + color + ", price=" + price + ", kal=" + kal + "]";
	}
}
