package spl1;

import java.util.ArrayList;

public class BlackKingJumpMove {
	
		public ArrayList<Integer> bestWay[]=new ArrayList[64];
		public int[] counter=new int[64];
		int[] checkCounter=new int[64];
	
		
		public int node;
		
		
		
		public BlackKingJumpMove(int source,int [] counter,ArrayList<Integer>[] bestWay,int[] checkCounter) {
			
			this.bestWay=bestWay;
			this.counter=counter;
			this.node=source;
			this.checkCounter=checkCounter;
			
			
		}
		
		int tempX1,tempX2,tempX3;
		
		
		public void findBestWay(int source,int [][] Altarr,int [][] path) {
				
				boolean flag=true;
				int[] totalCount=new int[8];
				
				for(int j=0;j<8;j++) {
					
					int [][] Altarr2=new int [64][3];
					for(int m=0;m<Altarr.length;m++) {
						
						for(int n=0;n<Altarr[0].length;n++) {
							
							Altarr2[m][n]=Altarr[m][n];
							
							
						}
						
					}
				
						tempX1=source;
						
						
						if(path[tempX1][j]!=-1) {
							
							tempX2=path[tempX1][j];
							
							
						
							if(path[tempX2][j]!=-1) {
								
								tempX3=path[tempX2][j];
								
							
							
								if(tempX2!=-1&&tempX3!=-1) {
									if(Altarr2[tempX1][2]==3&&(Altarr2[tempX2][2]==1||Altarr2[tempX2][2]==4)&&Altarr2[tempX3][2]==0) {
										
										
										Altarr2[tempX1][2]=0;
										Altarr2[tempX2][2]=0;
										Altarr2[tempX3][2]=3;
										
										totalCount[j]++;
										
										checkWay( tempX3,j,Altarr2, path,totalCount);
										
										flag=false;
										
										
									}
							
								}
							
						
							}
						}
						
				}
				
				if(flag==true){
					
					return;
				}
				
				int max=0,temp=0;
				for(int i=0;i<8;i++) {	
					if(totalCount[i]>max){
						
						max=totalCount[i];
						temp=i;
					}
					
				}
				
				
				tempX1=source;
				tempX2=path[source][temp];
				tempX3=path[tempX2][temp];
				
				Altarr[tempX1][2]=0;
				Altarr[tempX2][2]=0;
				
				for(int i=0;i<8;i++) {
					
					//System.out.print("TotalCount:"+totalCount[i]);
				
				}
				//System.out.println();
				//System.out.println("source:"+source+"   tempj: "+temp+"   node:"+node);
				Altarr[tempX3][2]=3;
				
				bestWay[node].add(tempX1);
				bestWay[node].add(tempX2);
				bestWay[node].add(tempX3);
				counter[node]++;
				
				checkCounter[node]+=2;
				
				findBestWay(tempX3,Altarr,path);
				
		}
		
		public void checkWay(int source,int way,int [][] Altarr,int [][] path,int[] totalCount) {
			
			int temp;
			tempX1=source;
			while(true){
				boolean flag=true;	
				for(int k=0;k<8;k++) {
					
					temp=tempX1;
					
				
					
					if(path[temp][k]!=-1) {
						
						temp=path[temp][k];
						tempX2=temp;
						
					
					if(path[temp][k]!=-1) {
						
						temp=path[temp][k];
						tempX3=temp;
						
					
					
					if(tempX2!=-1&&tempX3!=-1) {
					
						if(Altarr[temp][2]==3&&(Altarr[tempX2][2]==1||Altarr[tempX2][2]==4)&&Altarr[tempX3][2]==0) {
						
							Altarr[temp][2]=0;
							Altarr[tempX2][2]=0;
							Altarr[tempX3][2]=3;
							
						
							tempX1=tempX3;
							
							totalCount[way]++;
					//	System.out.println("j-->"+k+"  tempX1 "+tempX2+ "  tempX2  "+tempX3+"  temp "+temp+" count7:  "+counter[source]);
							
							
							flag=false;
							
						}
						
					}
	
					
					}
					}
					
				}
				
				if(flag==true) {
					
					
					
					break;
					
				}
				
				
				
			}
			
		}

}
