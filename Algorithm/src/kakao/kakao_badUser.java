package kakao;
import java.util.*;

public class kakao_badUser {
	static boolean[] check;
	static HashSet<HashSet> hsset;
	static HashSet<String> hs;
	static int answer = 0;
	public static void main(String[] args) {
		String[] user_id = 
			{"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = 
//			{"fr*d*", "abc1**"};	// 2
			{"*rodo", "*rodo", "******"};	// 2
//			{"fr*d*", "*rodo", "******", "******"};	// 3
		System.out.println(solution(user_id, banned_id));
	}
    public static int solution(String[] user_id, String[] banned_id) {
//        int answer = 0;
        check = new boolean[user_id.length];
        hsset = new HashSet<>();
        hs = new HashSet<>();
//        int uid_len = user_id.length, bid_len = banned_id.length;
        dfs(user_id, banned_id, 0);
//        return answer;
        return hsset.size();
    }
    static void dfs(String[] uid, String[] bid, int t) {
    	// 모든 경우 탐색
    	// 비교 문자열의 길이 다르면 다음 문자열 비교
    	// check[] 사용 
    	if(t == bid.length) {
//    		if(!hsset.contains(hs)) {
	    		hsset.add(hs);
	    		hs.clear();
//	    		++answer;
//    		}
    		return;
    	}
    	for(int i = 0; i < uid.length; ++i) {
    		// 찾고자 하는 uid와 bid의 길이가 다르다면 건너뛴다
    		if(uid[i].length() != bid[t].length())
    			continue;
    		// 이미 확인해본 uid라면 건너뛴다
    		if(check[i] == true)
    			continue;
    		// 문자열 비교
    		int j;
    		for(j = 0; j < uid[i].length(); ++ j) {
    			if(bid[t].charAt(j) == '*')
    				continue;
    			if(bid[t].charAt(j) != uid[i].charAt(j))
    				break;
    		}
    		// 같다면
    		if(j == uid[i].length()) {
//    			System.out.println(uid[i] + " == " + bid[t]);
//    			System.out.print(t+": "+uid[i]+", ");
    			hs.add(uid[i]);
    			check[i] = true;
    			dfs(uid, bid, t+1);
//    			System.out.println();
    			check[i] = false;
    		}
    	}
    }
}
