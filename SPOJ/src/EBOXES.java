import java.io.*;
public class EBOXES {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			int T = Integer.parseInt(s[2]);
			int F = Integer.parseInt(s[3]);
			
			pw.println(((K*F)-N)/(K-1));
			pw.flush();
		}
	}
}
/*  DERIVATION
(N-Tx)+(Tkx -Ty)+kTy = F
N -Tx(1-k)-Ty(1-k)=F

N + (Tx+Ty)(k-1)=F

T(x+y)(k-1)=F-N

x+y = (F-N)/(T(K-1))

ans = N+ Tkx + Tky
ans = N + TK(x+y)

ans = N+ K(F-N)/(k-1) 

ans  = (Nk-N + KF -NK)/(k-1)
ans = (KF-N)/(K-1)
*/