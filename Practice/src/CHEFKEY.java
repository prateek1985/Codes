import java.io.*;

public class CHEFKEY {

	public static void main(String args[]) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]= br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			int count=0;
			for(int i=1;i<=c;i++){
				if(c%i==0){
					int a=i;
					int b=c/i;
					
					if(a<=n && b<=m){
					//	System.out.println(a+" "+b);
						count++;
					}
					/*if(b<=n&& a<=m){
					//	System.out.println(b+" "+a);
						count++;
					}*/
				}
			}
			System.out.println(count);
		}
	}
}
