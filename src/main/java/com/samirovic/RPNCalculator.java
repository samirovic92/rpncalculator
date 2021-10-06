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
