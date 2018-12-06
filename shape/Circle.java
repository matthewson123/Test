public class Circle extends Shape {
	Point center;
	double radius;

	public Circle(String name, double x, double y, double r) {
		super(name);
		this.center = new Point(x,y);
		this.radius = r;
	}

	public void setRadius(double r) {
		this.radius =  r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setCenter(double x, double y) {
		this.center = new Point(x,y)   ;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public String toString() {
		return " Center =  " + center + "; Radius = " + radius ;
	}
	

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return  Math.PI * radius * radius;
	}
	
}