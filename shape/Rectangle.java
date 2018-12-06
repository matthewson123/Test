public class Rectangle extends Shape {
	Point topLeft;
	double length;
	double width;
	
	public Rectangle(String name, double x, double y, double l, double w) {
		super(name);
		this.topLeft = new Point(x,y);
		this.length = l;
		this.width = w;
	}
	public void setLength(double l) {
		this.length = l;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setWidth(double w) {
		this.width = w;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setTopLeft(double x, double y) {
		this.topLeft = new Point(x,y);
	}
	
	public Point getTopLeft() {
		return topLeft;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}
	
	public String toString() {
		return " TopLeft ＝ " + topLeft + "; Length = " + length + "; Width = " + width ;
	}

}