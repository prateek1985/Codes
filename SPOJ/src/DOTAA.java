import java.util.*;
import java.io.*;
public class DOTAA {

	public static void main (String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int tower = Integer.parseInt(s[1]);
			int damage = Integer.parseInt(s[2]);
			boolean flag=false;
			for(int y=0;y<Integer.parseInt(s[0]);y++){
				int n =Integer.parseInt(br.readLine());
				float f = (float)n/damage;
				if(f>1){
					if(Math.floor(f)!=f)
						tower-=(int)f;
					else
						tower-=(int)f-1;
					
				}
				
				if(tower<=0){
					flag=true;
					
				}
				
			}
			if(!flag){
				pw.println("NO");
				pw.flush();
			}
			else{
				pw.println("YES");
				pw.flush();
			}
		}
	}
}
