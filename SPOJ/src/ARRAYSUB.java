import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ARRAYSUB {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
	//	br.readLine();
		String s[]=br.readLine().split(" ");
		int k =Integer.parseInt(br.readLine());
		int max=Integer.MIN_VALUE;
		
		int ind=0;
		for(int i=0;i<k;i++){
		//	System.out.println(Integer.parseInt(s[i]));
			if(max<Integer.parseInt(s[i])){
				max=Integer.parseInt(s[i]);
				ind=i;
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(max+" ");
		pw.flush();
		for(int i=k;i<n;i++){
			if(i-k==ind){
				if(max<Integer.parseInt(s[i])){
					max=Integer.parseInt(s[i]);
					ind = i;
				}
				else{
					max=Integer.MIN_VALUE;
					for(int j=ind+1;j<=i;j++){
						if(max<Integer.parseInt(s[j])){
							max=Integer.parseInt(s[j]);
							ind = j;
						}
						
					}
				}
			}
			else{
				if(max<Integer.parseInt(s[i])){
					max=Integer.parseInt(s[i]);
					ind = i;
				}
			}
			pw.print(max+" ");
			pw.flush();
		}
	}

}
