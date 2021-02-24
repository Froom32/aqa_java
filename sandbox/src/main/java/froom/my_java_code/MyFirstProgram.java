package froom.my_java_code;

public class MyFirstProgram {

	public static void main(String[] args) {
		String nameOfASomebody = "Bill";
		System.out.println("Hello " + nameOfASomebody + "!");

		Rectangle s = new Rectangle(4,6);
		System.out.println("The area of the rectangle = " + s.area());

		Point p1 = new Point(-10,1);
		Point p2 = new Point(15,1);
		System.out.println("The distance between two points is " + p1.distance(p2));

	}

}
