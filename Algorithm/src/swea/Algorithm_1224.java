package swea;
import java.util.Scanner;
import java.util.Stack;

public class Algorithm_1224 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 1; test_case++) {
			int length = sc.nextInt();
			String s = sc.next();
			
			String f2p = convert(s, length);
			int result = calculate(f2p);
			System.out.println("#"+test_case+" "+result);
		}
		sc.close();
	}
	
	static int priority (char c) {	// 연산자의 우선순위
		if(c == '*')
			return 2;
		else if(c == '+')
			return 1;
		else
			return 0;
	}
	
	static String convert(String s, int length) {
		Stack<Character> stack = new Stack<>();
		String result = new String();
		
		for(int i=0; i<length; ++i) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {	// 피연산자 Operand
				result += c;
			}
			else if( c == '(' ) {	// 왼쪽 괄호 Left Parentheses
				stack.push(c);
			}
			else if( c== ')' ) {	// 오른쪽 괄호 Right Parentheses
				while(!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop();
			}
			else {	// 연산자 Operator
				if(stack.isEmpty()) {
					stack.push(c);
				} else if(priority(c) > priority(stack.peek())) {
					stack.push(c);
//				} else if(priority(c) <= priority(stack.peek())) {
				} else {
					while(!stack.isEmpty() && ( priority(c) <= priority(stack.peek()) ) )	// 토큰의 우선순위가 top보다 작거나 같을동안
							result += stack.pop();
					stack.push(c);
				}
					
			}
		}
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		stack.clear();
		return result;
	}
	
	static int calculate(String s) {	// 계산 Calculate
		Stack<Integer> stack = new Stack<>();
		char c;
		
		for(int i=0; i<s.length(); ++i) {
			c = s.charAt(i);
			if( c == '+' || c == '*' ) {	// 연산자 Operator
				int a = stack.pop();
				int b = stack.pop();
				switch(c) {
					case '+':
						stack.push(b+a);
						break;
					case '*':
						stack.push(b*a);
						break;
				}
			} else {	// 피연산자 Operand
				stack.push(c-'0');
			}
		}
		
		return stack.pop();
	}
}
