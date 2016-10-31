import java.util.*;
import java.io.*;
public class DIEHARD {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t =Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split( " ");
			int h = Integer.parseInt(s[0]);
			int a=Integer.parseInt(s[1]);
			int days=0;
			while(h>0&&a>0){
				if(days%2==0){
					days++;
					h+=3;a+=2;
				}
				else{
					if(h>5&& a>10){
						days++;
						h-=5;a-=10;
					}
					else if(h<=5)
						break;
					else if(a<=10){
						if(h>20){
							days++;
							h-=20;
							a+=5;
						}
						else
							break;
					}
				}
			}
			pw.println(days);
			pw.flush();
		}
	}
}
