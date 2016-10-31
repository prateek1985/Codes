import java.io.*;
public class MeetingOldFriends {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		long l1 = Long.parseLong(s[0]);
		long r1 = Long.parseLong(s[1]);
		long l2 = Long.parseLong(s[2]);
		long r2 = Long.parseLong(s[3]);
		
		long p = Long.parseLong(s[4]);
		
		if(r1<l2 || r2<l1){
			System.out.println(0);
		}
		else{
			long l = Math.max(l1, l2);
			long r = Math.min(r1, r2);
			
			if(p>=l && p<=r)
				System.out.println(r-l);
			else
				System.out.println(r-l+1);
			
		}
		
	}
}
