import java.io.*;
import java.util.ArrayList;
public class LargestString {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		StringBuilder sb = new StringBuilder(br.readLine());
		/*int m1=Integer.MIN_VALUE;
		int i1=0;
	 
		for(int i=0;i<n;i++){
			if(m1 < sb.charAt(i)){
				m1=sb.charAt(i);
				i1=i;
			}
		}
		ArrayList<Integer>al= new ArrayList<Integer>();
		int a = sb.charAt(i1);
		int flag=0;
		for(int j=0;j<10;j++){
			if(j<a-'A'){
				for(int i=0;i<i1;i++){
					if(j==sb.charAt(i)){
						al.add(i);
						if(al.size()==k){
							flag=1;
							break;
						}
					}
				}
			}
			else{
				if(al.size()<k){
					
				}
			}
			if(flag==1)
				break;
		}*/
		int flag=0,x=0;
		ArrayList<Integer>al= new ArrayList<Integer>();
		while(flag<k){
			int tmp=flag;
			for(int i=0;i<sb.length()-1;i++){
				if(sb.charAt(i)<sb.charAt(i+1)){
					sb.deleteCharAt(i);
					i--;
					flag++;
					if(flag==k)
						break;
				}
			}
			if(tmp==flag && flag<k){
				 x = sb.length()-(k-flag);
				break;
			}
		}
		if(x!=0)
			System.out.println(sb.substring(0,x));
		else
			System.out.println(sb);
	}
}
