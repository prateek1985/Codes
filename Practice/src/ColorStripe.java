import java.io.*;
public class ColorStripe {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sp[]= br.readLine().split(" ");
		int  	n=Integer.parseInt(sp[0]);
		int k=Integer.parseInt(sp[1]);
		char c[]=br.readLine().toCharArray();
		if(n==1){
			System.out.println(0);
			System.out.println(new String(c));
		}
		else if(n==2){
			if(c[0]!=c[1])
			{
				System.out.println(0);
				System.out.println(new String(c));
			}
			else{
				System.out.println(1);
				if(c[0]=='A')
					c[0]='B';	
				else
					c[0] = (char)(c[1]-1);
				System.out.println(new String(c));
			}
		}
		else{
			int count=0;
			/*if(c[0]==c[1]){
				count++;
				for(int i=0;i<k;i++){
					if(i!=c[0]-'A' && i!=c[2]-'A'){
						c[1] = (char)('A'+i);break;
					}
				}
			}
			if(c[n-2]==c[n-1]){
				count++;
				boolean f=false;
				for(int i=0;i<k;i++){
					if(i!=c[n-1]-'A' && i!=c[n-3]-'A'){
						f=true;
						c[n-2] = (char)('A'+i);break;
					}
				}
				if(!f)
				{
					for(int i=0;i<k;i++){
						if(i!=c[n-2]-'A'){
							c[n-1] = (char)('A'+i);break;
						}
					}
				}
			}*/
			for(int i=0;i<n-1;i++){
				if(i+1!=n-1){
					if(c[i]==c[i+1]){
						count++;
						for(int j=0;j<k;j++){
							if(j!=c[i]-'A' && j!=c[i+2]-'A'){
								c[i+1] = (char)('A'+j);break;
							}
						}
					}
				}
				else{
					if(c[i]==c[i+1]){
						count++;
						for(int j=0;j<k;j++){
							if(j!=c[i]-'A'){
								c[i+1] = (char)('A'+j);break;
							}
						}
					}
				}
			}
			
			System.out.println(count);
			System.out.println(new String(c));
		}
	}
}
