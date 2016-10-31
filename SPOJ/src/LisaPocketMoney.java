import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
                                                         // WRONG ANSWER ALTHOUGH TRIED A LOT

public class LisaPocketMoney {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int r=0;r<t;r++){
			String str = br.readLine();
			String strMin=str,strMax1=str,strMax2=str;
			
			int minValue=0;
			int foo=0;
			
			char[] zeroCheck = str.toCharArray(); 
			try{
			if(zeroCheck[0]=='0' && zeroCheck[1]=='*'){
				foo=1;
				strMax1 = "0"+str.substring(3,str.length());
				strMin="0";
			}
			else if(zeroCheck[str.length()-1]=='0' && zeroCheck[str.length()-2]=='*'){
				foo=1;
				strMax1 = str.substring(0,str.length()-3)+"0";
				strMin="0";
			}
			
			for(int i=1;i<str.length()-1;i++){
				if(str.charAt(i)=='0'){
					if(str.charAt(i-1)=='*' && str.charAt(i+1)=='*'){
						strMax1 = str.substring(0,i-2) + "0" +  str.substring(i+1,str.length());
						strMax2 = str.substring(0,i) + "0" +  str.substring(i+3,str.length());
						strMin="0";
					}
					else if(str.charAt(i-1)=='*'){
						strMin=  str.substring(i,str.length());
					}
					else if(str.charAt(i+1)=='*'){
						strMin=  str.substring(0,i+1);
					}
				}
			}
			
			
			}
			catch(Exception e){}
			finally{
			
			
			String min[]= strMin.split("\\+");
			
			
			int minArr[]=new int[min.length];
			
			
			
            for (int i=0;i<min.length;i++){
				
				String arr[] = min[i].split("\\*");
				int temp=1;
				for(int k=0;k<arr.length;k++){
					temp *= Integer.parseInt(arr[k]);
				}
				minArr[i] = temp;
			}
			for(int i =0 ;i<minArr.length;i++){
				minValue+=minArr[i];
			}
			
			int maxValue1=checkMax(strMax1);
			int maxValue2=checkMax(strMax2);
			int maxValue= maxValue1;
			if(maxValue2>maxValue1){maxValue=maxValue2;}
			
			if(minValue>maxValue){
				int flag = minValue;
				minValue = maxValue;
				maxValue = flag;
			}

			if(foo==1){minValue=0;}
			System.out.println(maxValue+" "+minValue);
			
		}
		
		}
	}
	
	static int checkMax(String strMax){
		int maxValue=1;
		String max[]= strMax.split("\\*");
		int maxArr[]=new int[max.length];
		
		for (int i=0;i<max.length;i++){
			
			String arr[] = max[i].split("\\+");
			for(int k=0;k<arr.length;k++){
				maxArr[i] += Integer.parseInt(arr[k]);
				
			}
			//System.out.println(maxArr[i]);
		}
		for(int i =0 ;i<maxArr.length;i++){
			maxValue*=maxArr[i];
			
		}
		return maxValue;
	}

}
