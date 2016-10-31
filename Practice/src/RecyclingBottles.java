import java.util.*;
import java.io.*;
public class RecyclingBottles {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int ax = Integer.parseInt(s[0]);
		int ay = Integer.parseInt(s[1]);
		int bx = Integer.parseInt(s[2]);
		int by = Integer.parseInt(s[3]);
		int tx = Integer.parseInt(s[4]);
		int ty = Integer.parseInt(s[5]);
		
		int n=Integer.parseInt(br.readLine());
		int c[][]= new int[n][2];
		for(int i=0;i<n;i++){
			String ss[]=br.readLine().split(" ");
			c[i][0] = Integer.parseInt(ss[0]);
			c[i][1] = Integer.parseInt(ss[1]);
		}
		
		double minA1= Double.MAX_VALUE;
		double minB1= Double.MAX_VALUE;
		int Ai1 = 0;
		int Bi1 = 0;
		
		for(int i=0;i<n;i++){
			if(minA1 > dis(ax,ay,c[i][0],c[i][1])){
				minA1 = dis(ax,ay,c[i][0],c[i][1]);
				Ai1 = i;
			}
			
			if(minB1 > dis(bx,by,c[i][0],c[i][1])){
				minB1 = dis(bx,by,c[i][0],c[i][1]);
				Bi1=i;
			}
		}
		
		double total = 0;
		for(int i=0;i<n;i++){
			total += 2*dis(tx,ty,c[i][0] , c[i][1]);
		}
		System.out.println(Ai1+" "+Bi1);
		if(Ai1!=Bi1){
			double d = dis(ax,ay,c[Ai1][0],c[Ai1][1]) + dis(bx,by,c[Bi1][0],c[Bi1][1]);
			
			System.out.println(total + d - dis(tx, ty , c[Ai1][0], c[Ai1][1]) - dis(tx, ty , c[Bi1][0], c[Bi1][1]));
		}
	}
	
	static double dis(int a, int b, int c, int d){
		return Math.sqrt(Math.pow(a-c,2) + Math.pow(b-d,2));
	}
}
