package kakao;
/*
 * 2019 kakao winter internship
 * 01 : puppeteer
 */
import java.util.Stack;

public class kakao_puppeteer {
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		System.out.println(solution(board, moves));
		// result = 4;
	}
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i<moves.length; ++i) {
        	int idx = moves[i] - 1;
        	int j = 0;
        	while(j < board.length) {
        		if(board[j][idx] == 0)
        			++j;
        		else break;
        	}
        	if(j == board.length)
        		continue;
        	if(!s.isEmpty() && s.peek() == board[j][idx]) {
        		s.pop();
        		answer += 2;
        	}
        	else 
        		s.push(board[j][idx]);
        	board[j][idx] = 0;
        }
        return answer;
    }
}
