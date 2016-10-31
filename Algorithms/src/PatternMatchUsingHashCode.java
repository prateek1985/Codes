
public class PatternMatchUsingHashCode {

	public static void main (String args[]){
		String s = "vjnvsdniajfppprateekkzdjdnvsdnv";
	    String pattern = "prateek";
		
	    int hash1 = pattern.hashCode();
	    for(int i=0;i<s.length()-pattern.length()+1;i++){
	    	if(s.substring(i,i+pattern.length()).hashCode() == hash1){
	    		System.out.println(i);
	    	}
	    }
	}
}
