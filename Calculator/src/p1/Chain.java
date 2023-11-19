package p1;

public interface Chain {

	/**
	 * Sets the next object to handle the request (if this one can't).
	 *
	 * @param nextChain the next chain link
	 */
	void setNextChain(Chain nextChain);

	/**
	 * Calculates the result or sends the request to the next element in the chain.
	 *
	 * @param request the request to be processed
	 */
	void calculate(Request request);
}

