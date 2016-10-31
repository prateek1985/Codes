import java.io.*;
import java.util.*;
public class FilyaHomework {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		HashSet<Integer>hs =new HashSet<Integer>();
		for(int i=0;i<n;i++){
			hs.add(Integer.parseInt(s[i]));
		}
		
		if(hs.size()>3)
			System.out.println("NO");
		else
		{
			if(hs.size()==1 || hs.size()==2)
				System.out.println("YES");
			else{
				int min = Integer.MAX_VALUE;
				int max  =Integer.MIN_VALUE;
				for(int i=0;i<n;i++){
					min = Math.min(min, Integer.parseInt(s[i]));
					max = Math.max(max, Integer.parseInt(s[i]));
				}
				if((max -min )%2==0){
					int x = (max -min )/2;
					hs.remove(min);
					hs.remove(max);
					if(hs.contains(x+min))
						System.out.println("YES");
					else
						System.out.println("NO");
				}
				else
					System.out.println("NO");
			}
		}
	}
}
