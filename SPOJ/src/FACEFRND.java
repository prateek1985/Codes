import java.io.*;
import java.util.*;

public class FACEFRND {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n =Integer.parseInt(br.readLine());
			HashSet<Integer>hs = new HashSet<Integer>();
			HashSet<Integer>fr = new HashSet<Integer>();
			String s[][]=new String[n][];
			for(int i=0;i<n;i++){
				s[i] = br.readLine().split(" ");
				for(int j=0;j<Integer.parseInt(s[i][1]);j++){
					hs.add(Integer.parseInt(s[i][j+2]));	
				}
				fr.add(Integer.parseInt(s[i][0]));	
			}
			
			for(int x:fr){
				hs.remove(x);
			}
			
			
			System.out.println(hs.size());
			
	}

}
	