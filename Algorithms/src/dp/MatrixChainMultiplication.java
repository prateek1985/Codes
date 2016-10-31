package dp;

public class MatrixChainMultiplication {
													// understND IT PROPERLY
	
	public static void main(String[] args) {   
		int p[]={1,2,3,4};    // this represents size of three matrices 1x2,2x3,3x4
		
		int m[][] = new int[p.length][p.length];  /*    m[i,j] = Minimum number of scalar multiplications needed to compute
	       												the matrix A[i]A[i+1]...A[j] = A[i..j] where dimention of A[i] is
	       												p[i-1] x p[i] */
		for(int i=1;i<p.length;i++){
			m[i][i]=0;
		}
		
		for(int l=2;l<p.length;l++){
		
			for(int i = 1;i<p.length -l +1;i++){
				
				int j = i + l -1;
				m[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++){
					
					int t= m[i][k] + m[k+1][j] + (p[i-1]*p[k]*p[j]);
					
					if(t<m[i][j]){
						m[i][j] = t;
					}
				}
			}
		}
		
		System.out.println(m[1][p.length-1]);
	}

}
