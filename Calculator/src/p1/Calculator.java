package p1;


import java.util.Scanner;

public class Calculator {
	public static int result = 0;
	static Request request = null;

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the first number, operation and the second number: ");
			String input = sc.nextLine();
			String[] splitt = input.split(" ");
			String operation = splitt[1];
			int first = Integer.parseInt(splitt[0]);
			int second = Integer.parseInt(splitt[2]);

			request = new Request(first, second, operation);

			Chain Add = new Add();
			Chain Sub = new Subtract();
			Chain Mul = new Multiply();
			Chain Div = new Divide();

			Add.setNextChain(Sub);
			Sub.setNextChain(Mul);
			Mul.setNextChain(Div);

			Add.calculate(request);
			System.out.println(result);

		}   catch (NullPointerException e3) {
			System.out.println("Impossible operation " + request.getOperation());
		}
		catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("too many characters.");
		}
		catch (NumberFormatException e) {
			System.out.println("can't set to a number.");
		}


	}

}
