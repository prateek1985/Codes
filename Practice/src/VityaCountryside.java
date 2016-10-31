import java.io.*;
public class VityaCountryside {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		if(n==1){
			if(Integer.parseInt(s[0])==0)
			System.out.println("UP");
			else if(Integer.parseInt(s[0])==15)
				System.out.println("DOWN");
			else
				System.out.println(-1);
		}
		else{
			int x = Integer.parseInt(s[n-1]);
			int y = Integer.parseInt(s[n-2]);
			if(x-y>0){
				if(x==15)
					System.out.println("DOWN");
				else
					System.out.println("UP");
			}
			else
			{
				if(x!=0)
					System.out.println("DOWN");
				else
					System.out.println("UP");
			}
		}
	}
}
