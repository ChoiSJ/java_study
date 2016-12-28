package kr.jhta.map;

import java.util.HashMap;

public class HashMapDemo2 {
	
	public static void main(String[] args) {
		
		HashMap<String, Product> products = new HashMap<String, Product>();
		
		// Product 객체를 여러 개 담는 HashMap 객체 생성하기(key-value pair) 
		products.put("노트북", new Product("노트북", 1000000));
		products.put("연필", new Product("연필", 1000));
		products.put("책상", new Product("책상", 50000));
		products.put("컵", new Product("컵", 6000));
		
		Product p1 = products.get("컵");
		System.out.println(p1.getName() + ", " + p1.getPrice());
	}
	
	public static class Product {
		
		private String name;
		private int price;
		
		public Product() {}

		public Product(String name, int price) {
			super();
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	}
}
