import java.io.*;
import java.util.*;
public class TSHOW1 {

	public static void main(String aargs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		ArrayList<Long> al = new ArrayList<Long>();
		long val=2;
		int count = 1;
		al.add(2l);
		while(count<50){
			val=val*2;
			al.add(al.get(count-1)+ val);
			//System.out.println(al.get(count));
			count++;
		}
		
		int t =Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			long n =Long.parseLong(br.readLine());
			if(n==1)
			{
				pw.println(5);
				pw.flush();
				continue;
			}
			else if(n==2){
				pw.println(6);
				pw.flush();
				continue;
			}
			
			int x = Collections.binarySearch(al, n);
			
			if(x<0){
				x= -x-1;
			}
			
		
			long sub= al.get(x-1);
			String binary = Long.toBinaryString(n-(sub+1));
			while(binary.length()<x+1){
				binary=0+binary;
			}
			String ss="";
			for(int i=0;i<binary.length();i++){
				if(binary.charAt(i)=='0')
					ss+=5;
				else
					ss+=6;
	
			}
			pw.println(ss);
			pw.flush();
			
		}
		
		
	}
}
