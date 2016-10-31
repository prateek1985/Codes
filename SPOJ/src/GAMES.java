import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class GAMES {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("#0.0000");
		PrintWriter pw =new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s=br.readLine();
			if(Math.ceil(Float.parseFloat(s))==Math.floor(Float.parseFloat(s))){
				pw.println(1);
				pw.flush();
				continue;
			}
			int ans=1;
			int dec=0;
			int i=s.length()-1;
			while(s.charAt(i)!='.'){
				i--;
				dec++;
			}
		//	System.out.println(dec);
			i=s.length()-1;
			int prev=s.length();
			while(s.charAt(i)!='.' && Math.ceil(Float.parseFloat(s))!=Math.floor(Float.parseFloat(s))){
				//System.out.println(Integer.parseInt(""+s.charAt(s.length()-1))+"dsd");
			
				
				if(Integer.parseInt(""+s.charAt(i))%2==0){
					s = String.format("%."+dec+"f",Float.parseFloat(s)*5);
					ans*=5;
				
				}
				else if(Integer.parseInt(""+s.charAt(i))==5){
					s = String.format("%."+dec+"f",Float.parseFloat(s)*2);
					ans*=2;
				
				}
				else
				{
					s = String.format("%."+dec+"f",Float.parseFloat(s)*10);
					ans*=10;

				}
				if(prev+1==s.length()){
					dec--;
				}
				else
					i--;
				
			//	System.out.println(s.charAt(i)+" "+s+" "+i);
				
				
			}
			
			pw.println(ans);
			pw.flush();
		}
	}
}
