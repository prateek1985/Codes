import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Hangover {

	public static void main (String args[]) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while(!(line=br.readLine()).equals("0.00") ){
			int n=1;float i=0;
			while(i<Float.parseFloat(line)){
			i+=(float)1/(n+1);
			n++;
			}
			
				System.out.println(n-1+" card(s)");
			
		}
	}
}
