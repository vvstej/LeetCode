package ik;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Solution1 {
	static String[] expressionCreator(String strDigits, int iK) {
		if (strDigits.length() == 0) {
			return new String[] {};
		}
		Set<String> resultSet = expHelper(strDigits, 0);
		Iterator<String> it = resultSet.iterator();
		Set<String> filteredResultSet = new HashSet<String>();
		while (it.hasNext()) {
			String expr = it.next();
			if (evaluate(expr) == iK) {
				filteredResultSet.add(expr);
			}
		}
		for(int i=0,j=1;i<=j;i++,j--){
			
		}
		return filteredResultSet.toArray(new String[filteredResultSet.size()]);
	}

	private static int evaluate(String expr) {
		Deque<String> operandStack = new LinkedList<>();
		Deque<String> operatorStack = new LinkedList<>();
		int index = 0;
		while (index < expr.length()) {
			int end = index;
			while (end < expr.length() && expr.charAt(end) != '+' && expr.charAt(end) != '*') {
				end++;
			}
			operandStack.push(expr.substring(index, end));
			if (end < expr.length()) {

				if (operatorStack.isEmpty())
					operatorStack.push(Character.toString(expr.charAt(end)));
				else {
					if (operatorStack.peek().equals("*")) {
						operatorStack.pop();
						operandStack.push(Integer
								.toString(evaluate(operandStack.pop(), operandStack.pop(), OPERATOR.MULTIPLICATION)));
						operatorStack.push(Character.toString(expr.charAt(end)));
					} else {
						operatorStack.push(Character.toString(expr.charAt(end)));
					}
				}
			}
			index = end + 1;
		}
		while (!operatorStack.isEmpty() && !operandStack.isEmpty()) {
			String op = operatorStack.pop();
			operandStack.push(Integer.toString(evaluate(operandStack.pop(), operandStack.pop(),
					op.equals("+") ? OPERATOR.ADDITION : OPERATOR.MULTIPLICATION)));
		}
		return Integer.parseInt(operandStack.pop());
	}

	private static Set<String> expHelper(final String input, final int index) {
		if (index == input.length() - 1) {
			Set<String> currResults = new HashSet<>();
			currResults.add(Character.toString(input.charAt(index)));
			return currResults;
		}
		Set<String> prevResults = expHelper(input, index + 1);
		final Set<String> currResults = new HashSet<>();
		for (OPERATOR op : OPERATOR.values()) {
			prevResults.forEach((prevResult) -> {
				currResults.add(Character.toString(input.charAt(index)) + op.getOperator() + prevResult);
			});
		}
		return currResults;
	}

	private static int evaluate(String operand1, String operand2, OPERATOR operator) {
		if (operator == OPERATOR.ADDITION) {
			return Integer.parseInt(operand1) + Integer.parseInt(operand2);
		}
		if (operator == OPERATOR.MULTIPLICATION) {
			return Integer.parseInt(operand1) * Integer.parseInt(operand2);
		} else {
			return Integer.parseInt(operand1 + operand2);
		}
	}

	enum OPERATOR {
		ADDITION("+", 3), MULTIPLICATION("*", 2), CONCATENATION("", 1);
		private int precedence;
		private String operator;

		OPERATOR(final String operator, final int precedence) {
			this.operator = operator;
			this.precedence = precedence;
		}

		public int getPrecedence() {
			return this.precedence;
		}

		public String getOperator() {
			return this.operator;
		}
	}

	public static void main(String[] arg) {
		System.out.println(Character.getNumericValue('B') + " "+ Integer.toString('b' - 'a'));
//		String[] solution = Solution1.expressionCreator("22245", 4490);
//		for (String val : solution) {
//			System.out.println(val);
//		}
	}

}
