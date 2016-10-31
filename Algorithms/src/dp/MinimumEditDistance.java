package dp;

import java.util.Scanner;

public class MinimumEditDistance {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		String x =s.nextLine();
		String y =s.nextLine();
		
		int D=1,R=1,I=1;
		
		int E[][] = new int [x.length()+1][y.length()+1];
		for(int i=0;i<=x.length();i++){  // length of y is zero
			E[i][0] = i*D;
		}
		for(int j=0;j<=y.length();j++){  // length of x is zero
			E[0][j] = j*I;
		}
		
		
		for(int i=1;i<=x.length();i++){
			for(int j=1;j<=y.length() ; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					E[i][j] = E[i-1][j-1];    // simple case ith and jth are equal
				}
				else{
					//replace- when i know to create i-1 to j-1 substring
					// insert - when i know to make i to j-1 so jth is to inserted after i
					// delete - when i know to make i-1 to j so ith is not req
					
					E[i][j] = Math.min((Math.min(E[i-1][j-1] + R, E[i-1][j]+ D )) , E[i][j-1] + I);
				}
			}
		}
		
		System.out.println(E[x.length()][y.length()]);
	}

}
