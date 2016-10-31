import java.io.*;
public class MemoryTrident {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int r=0,l=0,u=0,d=0;
		
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == 'R')
				r++;
			else if(s.charAt(i)=='L')
				l++;
			else if(s.charAt(i)=='U')
				u++;
			else
				d++;
		}
		int a = Math.abs(r-l);
		int b = Math.abs(u-d);
		int ans=0;
		if(a%2==0){
			ans+=a/2;
			if(b%2==0){
				ans+=b/2;
				System.out.println(ans);
			}
			else
				System.out.println(-1);
		}
		else{
			if(b%2==0)
				System.out.println(-1);
			else{
					int min=a/2;
					ans+=min+1;
					b--;
					ans+=b/2;

					System.out.println(ans);
			}
		}
	}
}
