import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FoodPlane {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		char c = s.charAt(s.length()-1);
		long r = Long.parseLong(s.substring(0,s.length()-1)) - 1;
		
		long time= (r/4)*16;
		if((r%4)%2 != 0 ){
			time++;
			time+=6;
		}
		if(c=='f')time+=1;
		else if(c=='e')time+=2;
		else if(c=='d')time+=3;
		else if(c=='a')time+=4;
		else if(c=='b')time+=5;
		else if(c=='c')time+=6;
		
		System.out.println(time);
	}
}
