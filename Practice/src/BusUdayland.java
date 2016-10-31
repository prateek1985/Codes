import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BusUdayland {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String s[]= new String[n];
		
		for(int i=0;i<n;i++)
			s[i]  = br.readLine();
		int flag=0;
		for(int i=0;i<n;i++){
			String arr[]= s[i].split("\\|");
		//	System.out.println(arr[1].equals("OO"));
			if(arr[0].equals("OO")){
				arr[0] = "++";
				s[i] = arr[0]+"|"+arr[1];
				flag=1;
				break;
			}
			else if(arr[1].equals("OO")){
				arr[1] = "++";
				flag=1;
				s[i] = arr[0]+"|"+arr[1];
				break;
			}
		}
		
		if(flag==0)
			System.out.println("NO");
		else{System.out.println("YES");
			for(int i=0;i<n;i++){
				
				System.out.println(s[i]);
			}
		}
		
	}
}
