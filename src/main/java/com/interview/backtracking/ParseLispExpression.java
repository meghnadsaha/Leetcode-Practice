package com.interview.backtracking;

import java.util.*;

/**
 * One difficulty is managing the correct scope of the variables. We can use a
 * stack of hashmaps. As we enter an inner scope defined by parentheses, we need
 * to add that scope to our stack, and when we exit, we need to pop that scope
 * off.
 * 
 * Our main evaluate function will go through each case of what form the
 * expression could take.
 * 
 * If the expression starts with a digit or '-', it's an integer: return it.
 * 
 * If the expression starts with a letter, it's a variable. Recall it by
 * checking the current scope in reverse order.
 * 
 * Otherwise, group the tokens (variables or expressions) within this expression
 * by counting the "balance" bal of the occurrences of '(' minus the number of
 * occurrences of ')'. When the balance is zero, we have ended a token.
 * 
 * For example, (add 1 (add 2 3)) should have tokens '1' and '(add 2 3)'.
 * 
 * For add and mult expressions, evaluate each token and return the addition or
 * multiplication of them.
 * 
 * For let expressions, evaluate each expression sequentially and assign it to
 * the variable in the current scope, then return the evaluation of the final
 * expression.
 * 
 */

class ParseLispExpression {

	ArrayList<Map<String, Integer>> scope;

	public ParseLispExpression() {
		scope = new ArrayList();
		scope.add(new HashMap());
	}

	public int evaluate(String expression) {
		scope.add(new HashMap());
		int ans = evaluate_inner(expression);
		scope.remove(scope.size() - 1);
		return ans;
	}

	public int evaluate_inner(String expression) {

		/**
		 * Group the tokens (variables or expressions) within this expression by
		 * counting the "balance" bal of the occurrences of '(' minus the number
		 * of occurrences of ')'. When the balance is zero, we have ended a
		 * token. For example, (add 1 (add 2 3)) should have tokens '1' and
		 * '(add 2 3)'.
		 */
		if (expression.charAt(0) != '(') {
			/**
			 * If the expression starts with a digit or '-', it's an integer:
			 * return it.
			 */
			if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-')
				return Integer.parseInt(expression);

			for (int i = scope.size() - 1; i >= 0; --i) {
				if (scope.get(i).containsKey(expression))
					return scope.get(i).get(expression);
			}
		}

		/**
		 * If the expression starts with a letter, it's a variable. Recall it by
		 * checking the current scope in reverse order.
		 */
		List<String> tokens = parse(expression.substring(expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
		if (expression.startsWith("add", 1)) {
			return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
		} else if (expression.startsWith("mult", 1)) {
			return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
		} else {
			for (int j = 1; j < tokens.size(); j += 2) {
				scope.get(scope.size() - 1).put(tokens.get(j - 1), evaluate(tokens.get(j)));
			}
			return evaluate(tokens.get(tokens.size() - 1));
		}
	}

	public List<String> parse(String expression) {
		List<String> ans = new ArrayList();
		int bal = 0;
		StringBuilder buf = new StringBuilder();
		for (String token : expression.split(" ")) {
			for (char c : token.toCharArray()) {
				if (c == '(')
					bal++;
				if (c == ')')
					bal--;
			}
			/**
			 * When the balance is zero, we have ended a token. For example,
			 * (add 1 (add 2 3)) should have tokens '1' and '(add 2 3)'.
			 */
			if (buf.length() > 0)
				buf.append(" ");
			buf.append(token);
			if (bal == 0) {
				ans.add(new String(buf));
				buf = new StringBuilder();
			}
		}
		if (buf.length() > 0)
			ans.add(new String(buf));

		return ans;
	}
}