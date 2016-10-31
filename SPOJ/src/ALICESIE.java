import java.io.*;
import java.util.*;
public class ALICESIE {
public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		int arr[]=new int[1000003];
		int i=1;
		int flag =0;
		int j=1;
		while(i<arr.length){
			if(flag==0){
				arr[i++]=j;
				flag=1;
			}
			else{
				arr[i++]=j;
				j++;
				flag=0;
			}
		//	System.out.println(arr[i-1]);
		}
		
		for(int r=0;r<t;r++){
			pw.println(arr[Integer.parseInt(br.readLine())]);
			pw.flush();
		}
		
}
}
