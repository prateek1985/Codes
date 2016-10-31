import java.io.*;
public class FENWITER {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int n=Integer.parseInt(s[3]);
			int one=0;
			for(int j=0;j<s[1].length();j++){
				if(s[1].charAt(j)=='1')
					one++;
			}
			one*=n;
			for(int j=0;j<s[0].length();j++){
				if(s[0].charAt(j)=='1')
					one++;
			}
			for(int j=0;j<s[2].length();j++){
				if(s[2].charAt(j)=='1')
					one++;
			}
			int tmp =0;
			//System.out.println();
			if(s[2].lastIndexOf('0')>=0){
				
				for(int i=s[2].lastIndexOf('0');i<s[2].length();i++){
					if(s[2].charAt(i)=='1')
						one--;
				}
				tmp=1;
			}
			else if(s[1].lastIndexOf('0')>=0){
				for(int i=s[1].lastIndexOf('0');i<s[1].length();i++){
					if(s[1].charAt(i)=='1')
						one--;
				}
				one-=s[2].length();
				tmp=1;
			}
			else if(s[0].lastIndexOf('0')>=0){
				for(int i=s[0].lastIndexOf('0');i<s[0].length();i++){
					if(s[0].charAt(i)=='1')
						one--;
				}
				one-=s[2].length()+(s[1].length()*n);
				tmp=1;
			}
			
			if(tmp==0)
				System.out.println(1);
			else
				System.out.println(one+1);
		}
	}
}
