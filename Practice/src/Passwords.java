import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Passwords {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		c arr[]=new c[n];
		for(int i=0;i<n;i++){
			String ss=br.readLine();
			arr[i] = new c(ss, ss.length());
		}
		String pass = br.readLine();
		int count=0;
		for(int i=0;i<n;i++){
			if(pass.length() == arr[i].l)
				count++;
		}
		
		Arrays.sort(arr);
		int min =0,max =0;
		int x=k;
		for(int i=0;i<n;i++){
			if(arr[i].l != pass.length()){
				min++;
				x--;
				if(x==0){
					x=k;
					min += 5;
				}
			}
			else{
				min++;
				max = min-1;
				count--;
				if(x>count){
					max +=count;
				}
				else if(x==count){
					max +=count+5;
				}
				else{
					count -=x;
					max +=x+5;
					if(count <k){
						max +=count;
					}
					else if(count ==k){
						max +=count+5;
					}
					else{
						max += count;
						max += (count/k)*5;
					}
					
				}
				max++;
			//	max  += count - 1;
				break;
			}
		}
		System.out.println(min +" "+max);
		
	}
	private static class c implements Comparable<c>{
		int l;
		String ss;
		public c(String s,int l){
			ss=s;
			this.l=l;
		}
		@Override
		public int compareTo(c cc) {
			// TODO Auto-generated method stub
			return l - cc.l;
		}
		
	}
}
