import java.io.*;

public class ImagePreview {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int a = Integer.parseInt(s[1]);
		int b = Integer.parseInt(s[2]);
		int t = Integer.parseInt(s[3]);
		
		String str = br.readLine();
		int x = 0,count=0;
		int h = a+1;
		int w = a+1+b;
		if(str.charAt(0)=='h')
			x+=1;
		else
			x+=1+b;
		if(x>t){
			System.out.println(0);
		}
		else{
			t -= x;
			count++;
			int i=1;
			int j= str.length()-1;
			while(i<=j && t>0){
				if(str.charAt(i)=='h'){
					t-=h;
					i++;
				}
				else{
					if(str.charAt(j)=='h'){
						t-=h;
					}
					else
						t-=w;
					j--;
				}
				if(t>=0)
					count++;
			}
			System.out.println(count);
		} 
		
	}
}
