import java.util.*;
import java.io.*;
public class TheLeastRoundWay {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s[][]= new String[n][n];
		for(int i=0;i<n;i++){
			s[i] = br.readLine().split(" ");	
		}
		
		int n2[][] =new int[n][n];
		n2[0][0] = num2(Integer.parseInt(s[0][0]));
		for(int i=1;i<n;i++){
			n2[i][0] = n2[i-1][0] + num2(Integer.parseInt(s[i][0]));
			n2[0][i] = n2[0][i-1] + num2(Integer.parseInt(s[0][i]));
		}
		
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				n2[i][j] = Math.min(n2[i-1][j], n2[i][j-1]) + num2(Integer.parseInt(s[i][j]));
			}
		}
		

		int n5[][] =new int[n][n];
		n5[0][0] = num5(Integer.parseInt(s[0][0]));
		for(int i=1;i<n;i++){
			n5[i][0] = n5[i-1][0] + num5(Integer.parseInt(s[i][0]));
			n5[0][i] = n5[0][i-1] + num5(Integer.parseInt(s[0][i]));
		}
		
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				n5[i][j] = Math.min(n5[i-1][j], n5[i][j-1]) + num5(Integer.parseInt(s[i][j]));
			}
		}
		
		String str="";
		int i=n-1,j=n-1;
		
		while(i!=0 && j!=0){
			if(Math.min(n2[i-1][j] , n5[i-1][j]) < Math.min(n2[i][j-1] , n5[i][j-1])){
				str="D"+str;
				i--;
			}
			else{
				j--;
				str="R"+str;
			}
		}
		
		while(i>0){
			str = "D"+str;i--;
		}
		while(j>0){
			str = "R"+str;j--;
		}
		System.out.println(Math.min(n2[n-1][n-1] , n5[n-1][n-1]));
		System.out.println(str);
	}
	static int num2(int n){
		int count=0;
		while(n%2==0){
			n/=2;count++;
		}
		return count;
	}
	static int num5(int n){
		int count=0;
		while(n%5==0){
			n/=5;count++;
		}
		return count;
	}
}
