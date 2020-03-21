import java.util.Scanner;

public class Algorithm_1284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int fee1 = 0, fee2=0, ans = 0;
            int P =sc.nextInt();    // 1L당 요금
            int Q =sc.nextInt();    // B사 기본요금
            int R=sc.nextInt(); // 월간 사용량 R 리터 이하인 경우 기본요금
            int S =sc.nextInt();    // R 리터 초과할 경우 초과한 양에 대한 1L당 요금
            int W =sc.nextInt();    // 한달간 사용한 수도 양
             
            fee1 = P*W;
            fee2 = Q;
            if(W>R) fee2 += ( (W-R)*S );
             
            ans = Math.min(fee1, fee2);
             
            System.out.println("#"+test_case+" "+ans);
        }
	}

}
