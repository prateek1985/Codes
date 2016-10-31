import java.io.*;
public class SimpleStrings {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c= br.readLine().toCharArray();
		for(int i=0;i<c.length-1;i++){
			if(i+1!=c.length-1){
				if(c[i]==c[i+1]){
					for(int j=0;j<26;j++){
						if(c[i]-'a'!=j && c[i+2]-'a'!=j){
							c[i+1] = (char)((int)'a'+j);
							break;
						}
					}
				}
			}
			else{
				if(c[i]==c[i+1]){
					if(c[i]=='z')
						c[i+1] = 'a';
					else
						c[i+1] = (char)(c[i]+1);
				}
			}
		}
		System.out.println(new String(c));
	}
}
