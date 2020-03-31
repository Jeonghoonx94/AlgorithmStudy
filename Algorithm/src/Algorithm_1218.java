import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Algorithm_1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Character> map = new HashMap<>();
		
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		map.put('<', '>');
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int result = 1;	// 1- 유효, 0- 무효
			Stack<Character> list = new Stack<Character>();
			int length = sc.nextInt();
			char[] parentheses = sc.next().toCharArray();
			
			for(int i=0; i<length; ++i) {
				if(parentheses[i] == '(' || parentheses[i] == '{' || parentheses[i] == '[' || parentheses[i] == '<' )
					list.push(parentheses[i]);
				else if(parentheses[i] == ')' || parentheses[i] == '}' || parentheses[i] == ']' || parentheses[i] == '>' ) {
					if(!list.isEmpty()) {	//스택이 안비어있으면
						char c = list.pop();
						if(parentheses[i] != map.get(c)) {	// 괄호의 짝이 안맞으면
							result = 0;
							break;
						}
						else result = 1;
					} else {	// 스택이 비어있으면
						result = 0;
						break;
					}
				}
			}

			System.out.println("#"+test_case+" "+result);
		}
		sc.close();
	}
}
