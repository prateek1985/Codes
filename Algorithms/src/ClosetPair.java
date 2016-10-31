import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

                                                              // wrong do it again 
                                                              // why ???????????????????????/

public class ClosetPair extends MergeSortByMe{

	static 	int pair[] =new int[4];
	static List<int[]> list = new ArrayList<int[]>();
	
	public static void main(String args[]) throws IOException{
		
		int x[]={1,2,3,7,9,5,8};
		int y[]={0,2,4,8,1,5,10};
		
		int Px[] = divide(x);   // sorting using merge sort
		int Py[] = divide(y);
		
		double d = closetPair(Px,Py);
		 
		System.out.println( closetSplitPair(Px,Py,d));
		list=Arrays.asList(pair);
		System.out.format("x1,y1 & x2,y2 : %d , %d  %d , %d", list.get(0)[0],list.get(0)[1],list.get(0)[2],list.get(0)[3]);
	} 
	
	static double closetPair(int []Px , int []Py){
	
		
		if(Px.length <=3 && Py.length <=3){
			
			double min=Double.POSITIVE_INFINITY;
			for(int i=0;i<Px.length;i++){                                              // eucledian distance
				double d = Math.sqrt(((Px[i]-Px[(i+1)%Px.length])*(Px[i]-Px[(i+1)%Px.length])) + ((Py[i]-Py[(i+1)%Px.length])*(Py[i]-Py[(i+1)%Px.length])));
				if(d<min){
				min=d;
				// adding pair
				pair[0]=Px[i];
				pair[1]=Py[i];
				pair[2]=Px[(i+1)%Px.length];
				pair[3]=Py[(i+1)%Px.length];
				
				}
			}
			return min;
		}
		else{
			int n = Px.length/2;
			
			int Qx[] = new int[n];
			int Qy[] = new int[n];
			
			int Rx[] = new int[Px.length-n];
			int Ry[] = new int[Px.length-n];
			
			int i=0;
			while(i<n){
				Qx[i]=Px[i];
				Qy[i]=Py[i];
				i++;
			}
			while(i<Px.length){
				Rx[i-n]=Px[i];
				Ry[i-n]=Py[i];
				i++;
			}
			
			double d1 = closetPair(Qx,Qy);
			List<int[]>a=Arrays.asList(pair);
			double d2 = closetPair(Rx,Ry);
			List<int[]>b=Arrays.asList(pair);
			double dmin;
			if(d1<=d2){
				dmin=d1;
				list =a;
			}
			else{
				dmin=d2;
				list =b;
			}
			return dmin;
			}
	}
	
	static double closetSplitPair(int Px[],int Py[],double d){
		ArrayList<Integer> temp=new ArrayList<Integer>();
		int n= Px.length/2;
		int x1=Px[n-1];
		double dmin=d;
		
	    ArrayList<Integer> al = new ArrayList<Integer>();
	    for(int i=0;i<Px.length;i++){
	    	if(Px[i]<=x1+d && Px[i]>=x1-d ){
	    		al.add(i);
	    	}
	    }
	    for (int i : al){
	    	int y1=Py[i];
	    	
	    	for(int j=i+1;j<i+7;j++){
	    		try{
	    		if(Py[j]<=y1+d && Py[j]>=y1-d){
				 double d1 = Math.sqrt(((Px[i]-Px[j])*(Px[i]-Px[j])) + ((Py[i]-Py[j])*(Py[i]-Py[j])));	 
				 if(dmin>d1){
					 dmin=d1;
					    pair[0]=Px[i];
						pair[1]=Py[i];
						pair[2]=Px[j];
						pair[3]=Py[j];
				 }
	    		}
	    		}
	    		catch(Exception e){}
	    	}
	    }
	    return dmin;
	}

}
