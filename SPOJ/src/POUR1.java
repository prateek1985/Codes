import java.io.*;
public class POUR1 {    

	public static void main(String aargs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			if((c>b&&c>a)) {
				pw.println(-1);
				pw.flush();
			}
			else{
			
				
			}
		}
	}
}
