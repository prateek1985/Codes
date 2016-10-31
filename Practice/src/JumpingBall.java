import java.io.BufferedReader;
import java.io.InputStreamReader;
public class JumpingBall {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String s= br.readLine();
		char p='a';
		int count=0;
		int flag =0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)!=p){
				p = s.charAt(i);
				int j=i;
				try{
					flag =0;
					int tmp=-100000;
				//	System.out.println(j+"df");
					while(true){
						if(s.charAt(j)=='<'){
							j--;
							if(j==tmp)
								break;
							tmp = j;
						}
						else
							j++;
						//System.out.println(j);
					}
				}
				catch(Exception e){
					flag =1;
					
					count++;
				}
			}
			else{
				if(flag==1)
					count++;
			}
		}
		System.out.println(count);
	}
}
