import java.io.*;
import java.util.Scanner;
public class AlyonaNumbers {

	public static void main(String args[]) throws Exception{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		long x = n/10;
		long y=m/10;
		long ans = y*2*n;
		ans+=x*2*(m%10);
		for(int i=1;i<=n%10;i++){
			for(int j=1;j<=m%10;j++){
				if((i+j)%5==0)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
