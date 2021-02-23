
import java.util.Arrays;
import java.util.StringTokenizer;

public class pg17676 {
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		String[] lines = new String[10];
		
		lines[0] = "2016-09-15 20:59:57.421 0.351s";
		lines[1] = "2016-09-15 20:59:58.233 1.181s";
		lines[2] = "2016-09-15 20:59:58.299 0.8s";
		lines[3] = "2016-09-15 20:59:58.688 1.041s";
		lines[4] = "2016-09-15 20:59:59.591 1.412s";
		lines[5] = "2016-09-15 21:00:00.464 1.466s";
		lines[6] = "2016-09-15 21:00:00.741 1.581s";
		lines[7] = "2016-09-15 21:00:00.748 2.31s";
		lines[8] = "2016-09-15 21:00:00.966 0.381s";
		lines[9] = "2016-09-15 21:00:02.066 2.62s";
		
		System.out.println(s.solution(lines));
	}
}

// ===============아래 부분에 작성하시면 됩니다======================

class Solution {
    public int solution(String[] lines) {
    	int answer = 0;
        StringTokenizer stk;
        int size =lines.length;
        double[] start = new double[size];
        double[] finish = new double[size];
        double[] point = new double[size*2];
        for(int i=0; i<size; i++) {
        	stk = new StringTokenizer(lines[i]);
        	stk.nextToken();//추석날짜
        	String endtime= stk.nextToken();
        	String usingtime = stk.nextToken();
        	usingtime = usingtime.substring(0, usingtime.length()-1); //s글자 제거
        	
        	finish[i] = StoT(endtime);
            
        	double tmp = finish[i] - Double.parseDouble(usingtime) + 0.001;
        	tmp = Math.round(tmp*1000); //double type이라 정확히 숫자표현이안됨.. 반올림으로 조정필요
        	start[i] = tmp/1000;
        	point[2*i] = finish[i];
        	point[2*i+1] = start[i];
        	
        }
        Arrays.sort(point);
        //setting finish
        for(int i=0; i<point.length; i++) {
        	double a = point[i];
        	double b = Math.round((a+0.999)*1000);
            b /= 1000;
        	int result = 0;
        	for(int j=0; j<size; j++) {
        		if((start[j]>=a && start[j]<=b) || (finish[j]>=a && finish[j]<=b) || (start[j]<a && finish[j]>b)) {
        			result++;
        		}
        	}
        	answer = Math.max(result, answer);
        }
        return answer;
    }

    static double StoT(String s) {
    	StringTokenizer stk = new StringTokenizer(s, ":");
    	double hour = Double.parseDouble(stk.nextToken());
    	double min = Double.parseDouble(stk.nextToken());
    	double sec = Double.parseDouble(stk.nextToken());
    	
    	return hour*3600 + min*60 + sec;
    }
}
