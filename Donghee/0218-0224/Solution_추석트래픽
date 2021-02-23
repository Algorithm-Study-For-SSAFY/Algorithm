package Feb_03;

public class Solution_추석트래픽 {
    public int solution(String[] lines) {
        int answer = 0;
        
        int []startT=new int[lines.length];
		int []endT=new int[lines.length];
		
		//lines에서 입력받은 것들
		for(int i=0; i<lines.length; i++) {
			String[] log=lines[i].split(" "); //띄어쓰기를 기준으로, 입력받기
			//log[0]에는 날짜, log[1]에는 저장 완료시간, log[2]에는 처리시간이 들어있다.
			//얘도 :을 기준으로 쪼개서 입력받으면 hh:mm:ss.sss
			String[] time=log[1].split(":");
			int end=0;
			end+=Integer.parseInt(time[0])*60*60*1000;
			end+=Integer.parseInt(time[1])*60*1000;
			end+=(int)(Double.parseDouble(time[2])*1000); //배열로 누적합, 소숫점 없애주기 위해서,
			
		
			//처리 시간, 0.002s
			int second=(int)(Double.parseDouble(log[2].substring(0,log[2].length()-1))*1000);
			int start=end-second+1;
			
			startT[i]=start; endT[i]=end;
		}
        for(int i=0; i<lines.length; i++) {
			//각 start[i], end[i] 비교
			int startline=startT[i]+999;
			int endline=endT[i]+999;
			System.out.println(startline+" "+endline);
			int front=0;
			int back=0;
			
			for(int j=0; j<lines.length; j++) {
				//start로 부터 999초뒤까지, 1초구간
				if(startT[j]<=startline && endT[j]>=startT[i]) {
					front++;
				}
				//end로부터 999초 뒤까지, 1초구간
				if(startT[j]<=endline && endT[j]>=endT[i]) {
					back++;
				}
				
			}
			answer=front>answer?front:answer;
			answer=back>answer?back:answer;
		}
		return answer;
    }
}
