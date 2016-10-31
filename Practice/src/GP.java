import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GP {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int r = Integer.parseInt(s[1]);
		String arr[]=br.readLine().split(" " );
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++){
			int a = Integer.parseInt(arr[i]);
			if(hm.containsKey(a))
				hm.put(a, hm.get(a)+1);
			else
				hm.put(a, 1);
		}
		long ans=0;
		left.put(Integer.parseInt(arr[0]), 1);
	
		for(int i=1;i<n-1;i++){
			int b = Integer.parseInt(arr[i]);
			if(b%r==0){
				
				int a = b/r;
				int c = b*r;
				if(hm.containsKey(c) && hm.containsKey(a) && left.containsKey(a)){

					int countA= left.get(a);
					int countC=0;
					
					if(left.containsKey(c))
						countC = left.get(c);
					
			//		System.out.println(left.get(a)+" "+left.get(c));
					if(r==1)
						ans += countA * (hm.get(c)-countC-1);
					else
						ans += countA * (hm.get(c)-countC);
				}
					
			}
			
			if(left.containsKey(b))
				left.put(b, left.get(b)+1);
			else
				left.put(b, 1);
			
		}
		System.out.println(ans);
	}
}
