import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class apac4 {
	public static void main(String args[]) throws Exception{
		BufferedWriter output = new BufferedWriter(new FileWriter("output.txt")); 
        /*
        output.append("Case #"+y+": "+arr[min]);
        output.newLine();
        output.close();*/
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int y=1;y<=t;y++){
			
			int r=s.nextInt();
			int c = s.nextInt();
			int arr[][]= new int[r][c];
			int count = r*c;
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					if(i-1>0 && i+1<r && j-1>0 && j+1<c){
						if((arr[i][j-1]==0 && arr[i][j+1]==0) || (arr[i-1][j]==0 && arr[i+1][j]==0)){
							arr[i][j] =1;
							count--;
						}
					}
					else if(i==0||i==r-1){
						if(j>0 && j<c-1){
							if(arr[i][j-1]==0 && arr[i][j+1]==0){
								arr[i][j] =1;
								count--;
							}
						}
					}
					else if(j==0||j==c-1){
						if(i>0 && i<r-1){
							if(arr[i-1][j]==0 && arr[i+1][j]==0){
								arr[i][j] =1;
								count--;
							}
						}
					}
				}
			}
			
		//	System.out.println(count);
			output.append("Case #"+y+": "+count);
		    output.newLine();
		}
		 output.close();
	}
}
