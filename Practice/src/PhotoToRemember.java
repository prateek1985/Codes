import java.io.*;
import java.util.*;
public class PhotoToRemember {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		int w[]=new int[n];
		int h[]=new int[n];
		for(int r=0;r<n;r++){
			String s[]=br.readLine().split(" ");
			w[r] =Integer.parseInt(s[0]);
			h[r] =Integer.parseInt(s[1]);
		}
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=w[i];
		}
		int fmax=-1;
		for(int i=0;i<n;i++){
			if(fmax<h[i])
				fmax=h[i];
		}
		int count=0;
		for(int i=0;i<n;i++){
			if(h[i]==fmax)
				count++;
		}
		int smax=-1;
		for(int i=0;i<n;i++){
			if(smax < h[i] && fmax!=h[i])
				smax=h[i];
		}
		
		if(count>=2){
			for(int i=0;i<n;i++){
				int W = sum-w[i];
				pw.print(W*fmax+" ");
				pw.flush();
			}
		}
		else{
			for(int i=0;i<n;i++){
				int W = sum-w[i];
				if(fmax==h[i]){
					pw.print(W*smax+" ");
				}
				else{
					pw.print(W*fmax+" ");
				}
				pw.flush();
			}
		}
	}
}
