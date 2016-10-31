import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cards {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int r=0,g=0,b=0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='R')
				r++;
			else if(s.charAt(i)=='G')
				g++;
			else
				b++;
		}
		
		if(r==n)
			System.out.println("R");
		else if(g==n)
			System.out.println("G");
		else if(b==n)
			System.out.println("B");
		else{
			if(n==2){
				if(r==0)
					System.out.println("R");
				else if(g==0)
					System.out.println("G");
				else
					System.out.println("B");
			}
			else{
				if(n==3){
					if(r==2)
						System.out.println("BG");
					else if(g==2)
						System.out.println("BR");
					else if(b==2)
						System.out.println("GR");
					else
						System.out.println("BGR");
				}
				else{
						if((b==0 && g==1)||(b==1 && g==0))
							System.out.println("BG");
						else if((b==0 && r==1) || (r==0 && b==1))
							System.out.println("BR");
						else if((g==0 && r==1) || (r==0 && g==1))
							System.out.println("GR");
						else
							System.out.println("BGR");
				}
			}
		}
		
	}
}
