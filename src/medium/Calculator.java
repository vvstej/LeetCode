package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

	public int calculate(String s) {
		Deque<Integer> numberQueue = new LinkedList<Integer>();

		if (s == null || s.length() == 0) {
			return 0;
		}
		try {
			if (s.length() == 1) {
				return Integer.parseInt(s);
			}
		} catch (NumberFormatException e) {
			return 0;
		}

		int num1 = Integer.MIN_VALUE;
		int num2 = Integer.MIN_VALUE;
		String[] operators = s.trim().split("\\d+");
		String[] numbers = s.trim().split("[^\\d]+");
		int j = 1;
		int result = Integer.parseInt(numbers[0].trim());
		boolean hasEndedWithPlus = false;
		for (int i = 0; i < operators.length; i++) {
			if (operators[i].trim().equals("+") || operators[i].trim().equals("-")) {
				numberQueue.add(result);
				result = Integer.parseInt(numbers[j++]);
				hasEndedWithPlus = true;
			} else if (operators[i].trim().equals("*") || operators[i].trim().equals("/")) {
				num2 = Integer.parseInt(numbers[j].trim());
				result = apply(result, num2, operators[i].trim());
				if((i==operators.length-1) && !numberQueue.isEmpty()){
					numberQueue.add(result);
				}
				j++;
				hasEndedWithPlus = false;
			}
		}
		if (hasEndedWithPlus) {
			numberQueue.add(Integer.parseInt(numbers[j - 1].trim()));
		}
		Integer prevResult = null;
		for (int i = 0; i < operators.length; i++) {
			if (operators[i].trim().equals("+") || operators[i].trim().equals("-")) {
				num1 = prevResult == null ? numberQueue.remove() : prevResult;
				num2 = numberQueue.remove();

				prevResult = apply(num1, num2, operators[i].trim());

			}
		}

		return prevResult == null ? result : prevResult;

	}

	private int apply(int num1, int num2, String operator) {
		switch (operator) {
		case "*":
			return num1 * num2;
		case "/":
			return (num1 / num2);
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		}
		return 0;
	}

	public static void main(String[] arg) throws ScriptException {
		Calculator calc = new Calculator();
		// System.out.println(calc.calculate("3+2*2"));
		// System.out.println(calc.calculate("3/2*2"));
		System.out.println(calc.calculate("1 + 1"));
		System.out.println(calc.calculate("567*2-1/3"));
		System.out.println(calc.calculate("  3+5/2  "));
		System.out.println(calc.calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
		
//		ScriptEngineManager mgr = new ScriptEngineManager();
//		ScriptEngine engine = mgr.getEngineByName("JavaScript");
//		String foo = "1+2*567-3/6";
//		System.out.println(engine.eval(foo));

	}
}
