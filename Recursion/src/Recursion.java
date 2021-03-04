import java.util.Scanner;

public class Recursion {
Scanner scan = new Scanner(System.in);
	public Recursion(){
		while(true) {
	int num = 	ReadNumber();
	int fact = Factorial(num);
	int fib = Fibanocci(num);
	System.out.println("Factorial of "+num+" = "+fact);
	System.out.println("Fibanocci of "+num+" = "+fib);
	}}
	public int ReadNumber() {
		System.out.println("Enter a Number");
		int num = scan.nextInt();
			return num;
	}
	public int Factorial(int num) {
		if(num == 0) return 1;
		else return(num*Factorial(num - 1));
		
	}
	public int Fibanocci(int num) {
		if(num == 0) return 1;
		if(num == 1 ) return 1;
		else return(Fibanocci(num-1)+Fibanocci(num-2));
		
	}
	public static void main(String[]args){
		new Recursion();
	}
}
