package anonymous;

public class PhotoShopApp {
	public static void main(String[] args) {
		
		PhotoShop ps = new PhotoShop();
		
		Pen yellow = new Pen() {
			public void draw() {
				System.out.println("노랑");;
			}
		};
		
		/*
		 * ps.painting(new Pen());
		 * 
		 * ps.painting(new Pen() {});
		 * 
		 * ps.painting(new Pen() {
		 * 
		 * })
		 * 
		 * ps.paintint(new Pen() {
		 * 		public void draw() {
		 * 		
		 * 		}
		 * });
		 */
		
		ps.painting(yellow);
		
		ps.painting(new Pen() {
			public void draw() {
				System.out.println("빨강");
			}
		});
		
		// 추상메소드가 하나 있을 때 람다식을 사용할 수 있다.
		ps.painting(() -> {System.out.println("파랑");});
	}
}
