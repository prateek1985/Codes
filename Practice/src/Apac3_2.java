import java.util.*;
import java.io.*;

public class Apac3_2 {

	public static void main(String args[]) throws Exception{
		BufferedWriter output = new BufferedWriter(new FileWriter("output.txt")); 
        /*
        output.append("Case #"+y+": "+arr[min]);
        output.newLine();
        output.close();*/
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int y=1;y<=t;y++){
			int r= s.nextInt();
			int c= s.nextInt();
			int k= s.nextInt();
			ArrayList<String > al = new ArrayList<String>();
			int mat[][]=new int[r][c];
			for(int i=0;i<k;i++){
				int x1=s.nextInt();
				int y1 = s.nextInt();
				mat[x1][y1]=1;
				al.add(x1+" "+y1);
			}
			long count=0;
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					if(mat[i][j]==0){
						for(int d=1;d<=Math.min(r-i, c-j);d++){
							int i2 = i+d-1;
							int j2 = j+d-1;
							boolean b=true;
							for(int p=0;p<al.size();p++){
								String s2[]=al.get(p).split(" ");
								if(Integer.parseInt(s2[0]) >= i && Integer.parseInt(s2[1]) >= j && Integer.parseInt(s2[0]) <= i2 && Integer.parseInt(s2[1]) <= j2){
									b=false;
									break;
								}
							}
							if(b)
								count++;
							else
								break;
						}
					}
				}
			}
			System.out.println(count);
			output.append("Case #"+y+": "+count);
		    output.newLine();
		}
		 output.close();
	}
}
