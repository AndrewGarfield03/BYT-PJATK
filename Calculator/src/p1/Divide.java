package p1;

public class Divide implements Chain {

	private Chain nextInChain;

	public void setNextChain(Chain nextChain) {
		nextInChain = nextChain;
	}

	public void calculate(Request request) {
		if (request.getOperation().equals("/")) {
			if (request.getNumber2() != 0) {
				Calculator.result = request.getNumber1() / request.getNumber2(); // Corrected to division
			} else {
				System.err.println("Can't divide by 0");
			}
		} else {
			nextInChain.calculate(request);
		}
	}
}
