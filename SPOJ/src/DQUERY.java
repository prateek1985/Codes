import java.util.*;
import java.io.*;
public class DQUERY {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		int inp[]=new int[s.length];
		for(int i=0;i<s.length;i++){
			inp[i]=Integer.parseInt(s[i]);
		}
		SegmentTree st = new SegmentTree(inp);
		//for(HashSet<Integer> d:st.seg){
		//	System.out.println(st.seg.length);
	//	}
		
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String q[]=br.readLine().split(" ");
			pw.println(st.distinctNum(Integer.parseInt(q[0])-1, Integer.parseInt(q[1])-1, 0, n-1, 0).size());
			pw.flush();
		
		}
		
		
		
	}
	

}
class SegmentTree{
	HashSet<Integer> seg[];
	
	public SegmentTree(int inp[]){
		int len = nextPow2(inp.length);
		seg=new HashSet[2*len-1];
		for(int i=0;i<seg.length;i++){
			seg[i]= new HashSet<Integer>();
		}
		
		construct(inp, 0, inp.length-1,0);
	}
	public int nextPow2(int n){
		if(n==0){
			return 1;
		}
		else if(n>0&&(n&(n-1))==0){
			return n;
		}
		while((n&(n-1))>0){
			n = n&(n-1);
		}
		return n<<1;
	}
	
	void construct(int inp[],int l, int h, int pos){
		if(l==h){
			seg[pos].add(inp[l]);
	//		System.out.println(pos+" "+seg[pos]+"l==h");
			return;
		}
		int mid = (l+h)/2;
		construct(inp,l,mid,2*pos+1);
		construct(inp , mid+1, h, 2*pos+2);
		seg[pos].addAll(seg[2*pos+1]);
		seg[pos].addAll(seg[2*pos+2]);
	//	System.out.println(pos+" "+seg[pos]);
	}
	
	public HashSet<Integer> distinctNum(int qL, int qH, int l, int h, int pos){
		if(qL>h || qH<l){
			return new HashSet<Integer>();
		}
		if(qL<=l&& qH>=h)
			return seg[pos];
		
		int mid=(l+h)/2;
		HashSet<Integer> hs1 = distinctNum(qL,qH,l,mid,2*pos+1);
	    HashSet<Integer> hs2 = new HashSet<Integer>();
	    hs2.addAll(hs1);
		hs2.addAll(distinctNum(qL,qH,mid+1,h,2*pos+2));
		return hs2;
	}
	
}















