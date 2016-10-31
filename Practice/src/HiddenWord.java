import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class HiddenWord {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		int n=s.length();
		int x = 0,y=0;
		int b[] = new int[26];
		Arrays.fill(b,-1);
		for(int i=0;i<n;i++){
			if(b[s.charAt(i)-'A']>=0){
				x = b[s.charAt(i)-'A'];
				y=i;
			}
			else
				b[s.charAt(i)-'A']=i;
		}
		char c[][]= new char[2][13];
		Arrays.fill(c[0], '|');
		Arrays.fill(c[1], '|');
		if((y-x-1 )%2!=0 || y==x+1)
			System.out.println("Impossible");
		else{
			int d = (y-x-1 )/2;
			int w=-1;
			int p=12;
			for(int i=x+d;i>x;i--){
				c[0][p--] = s.charAt(i); 
			//	System.out.println(p);
				if(p==-1){
					System.out.println("Impossible");
					return;
				}
				
			//	System.out.println(s.charAt(i));
			}
			
				c[0][p--] = s.charAt(x); 
			if(p==-1){
				System.out.println("Impossible");
				return;
			}
			w=-1;
			//System.out.println(p);
			for(int i=y+1;i<s.length();i++){
				c[0][p--] = s.charAt(i); 
				if(p==-1){
					w = i;
					break;
				}
			}
			if(w!=-1){
				p=0;
				for(int i=w+1;i<s.length();i++){
					c[1][p++] = s.charAt(i);
				}
				for(int i=0;i<x;i++){
					c[1][p++] = s.charAt(i);
				}
				
			}
			else{
				w=-1;
				for(int i=0;i<x;i++){
					c[0][p--] = s.charAt(i); 
					if(p==-1){
						p=0;
						while(i<x){
							c[1][p++] = s.charAt(i);
							i++;
						}
					}
				}
				
			}
			
			p=12;
			for(int i=x+d+1;i<y;i++){
				c[1][p--] = s.charAt(i);
			}
			
			System.out.println(new String(c[0]));
			System.out.println(new String(c[1]));
		}
	}
}
