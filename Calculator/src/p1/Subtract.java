package p1;

public class Subtract implements Chain {

	private Chain nextInChain;

	public void setNextChain(Chain nextChain) {
		nextInChain = nextChain;
	}

	public void calculate(Request request) {
		if (request.getOperation().equals("-")) {
			Calculator.result = request.getNumber1() - request.getNumber2(); // Corrected to subtraction
		} else {
			nextInChain.calculate(request);
		}
	}
}

