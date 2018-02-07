package leetCode_3;

public class Practice2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(derivative2(1,0,0,0.000000000000001,1));

	}
	public static double derivative1(double a, double b, double c, double h, int x) {
		double point1= a*x*x+b*x+c;
		double point2= a*(x+h)*(x+h)+b*(x+h)+c;
		return (point2-point1)/h;
	}
	public static double derivative2(double a, double b, double c, double h, int x) {
		double point1= a*(x-h)*(x-h)+b*(x-h)+c;
		double point2= a*(x+h)*(x+h)+b*(x+h)+c;
		return (point2-point1)/(2*h);
	}

}
