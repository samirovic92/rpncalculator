package com.samirovic;

import java.util.Stack;

public class RPNCalculator {

	private final static String DIV = "/";
	private final static String ADD = "+";
	private final static String SUB = "-";
	private final static String MULTIPLE = "*";
	private final static String SQRT = "SQRT";
	private final static String MAX = "MAX";

	private Stack<Float> numbers;

	public RPNCalculator() {
		this.numbers = new Stack<>();
	}

	private static String[] TEST_DATA = { "20 5 /", // expected: 4.0
			"4 2 + 3 - ", // expected: 3.0
			"3 5 8 * 7 + *", // expected: 141.0
			"9 SQRT", // expected: 3
			"5 3 4 2 9 1 MAX", // expected: 9
			"4 5 MAX 1 2 MAX 5 *" // expected: 25.0
	};

	public static void main(String[] args) {
		//TODO: implement calculator and use with test data
	}

	public Float calculate(String expression) {
		String[] values = expression.split(" ");

		for (String value: values) {
			if(isOperation(value)) {
				switch (value) {
					case DIV:
						division();
						break;
					case MULTIPLE:
						multiple();
						break;
					case ADD:
						addition();
						break;
					case SUB:
						subtraction();
						break;
					case SQRT:
						sqrt();
						break;
					case MAX:
						max();
						break;
				}
			} else {
				this.numbers.push(Float.parseFloat(value));
			}
		}
		return numbers.pop();
	}

	private void addition() {
		Float  secondNumber = numbers.pop();
		Float tmp =  numbers.pop() + secondNumber ;
		numbers.push(tmp);
	}

	private void subtraction() {
		Float  secondNumber = numbers.pop();
		Float tmp =  numbers.pop() - secondNumber ;
		numbers.push(tmp);
	}

	private void division() {
		Float  secondNumber = numbers.pop();
		Float tmp =  numbers.pop() / secondNumber ;
		numbers.push(tmp);
	}

	private void multiple() {
		Float  secondNumber = numbers.pop();
		Float tmp =  numbers.pop() * secondNumber ;
		numbers.push(tmp);
	}

	private void sqrt() {
		double tmp =  Math.sqrt(numbers.pop());
		numbers.push((float) tmp);
	}

	private void max() {
		Float max = numbers.pop();
		while(!numbers.isEmpty()){
			Float tmp = numbers.pop();
			if (tmp > max) {
				max = tmp;
			}
		}
		numbers.push(max);
	}

	private boolean isOperation(String value) {
		switch(value) {
			case DIV:
			case MULTIPLE:
			case ADD:
			case SUB:
			case SQRT:
			case MAX:
				return true;
			default:
				return false;
		}
	}
}
