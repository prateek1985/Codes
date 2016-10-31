import java.util.*;
import java.util.regex.*;
import java.io.*;
public class NHAY {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		PrintWriter pw = new PrintWriter(System.out);
		while(!(s=br.readLine()).equals("")){
		//	System.out.println(s+"  fff");
			String pat=br.readLine();
			String str=br.readLine();
		 
			int prefix[] = prefixArray(pat.toCharArray());
			int i=0,j=0;
			while(i<str.length()){
				if(str.charAt(i)== pat.charAt(j)){
					
					if(j==pat.length()-1){
						pw.println(i-j);
						pw.flush();
						i=i-j+1;j=0;
					}
					else{
						i++;j++;
					}
					 
				}
				else if(j>0)
					j=prefix[j-1];
				else{
					i++;
				}
			}
			
			pw.println();
			pw.flush();
		}
		
	}
	static int[] prefixArray(char c[]){
		int i=1,j=0;
		int arr[]= new int[c.length];
		
		while(i<c.length){
			if(c[i]==c[j]){
				arr[i]=j+1;
				i++;
				j++;
			}
			else if(j>0){
				j=arr[j-1];
			}
			else{
				arr[i]=0;
				i++;
			}
		}
		return arr;
	}
}
