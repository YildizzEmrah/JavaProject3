/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emrahyildiz_hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;


/**
 *
 * @author emrah
 */
public class Hw3_Classs implements Hw3_Interface {


    public int[][] arr;
    public int[][] maze;
    public String[][] starmaze;

   Position arr1=new Position();
   Position arr2=new Position();
   Position start=new Position();
   Position here=new Position();
   public int a=0;
   
   LinkedList ll = new LinkedList(); 

    @Override
    public void ReadShapeFile(String path) {
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String abc=br.readLine();
            String[] str= abc.split(" ");
            int c=0;
            while(abc!=null) {
                c++;
                abc=br.readLine();
            }
            arr1.row=c;
            arr1.col=str.length;
            int temp[] = new int[str.length];
            arr=new int[arr1.row][arr1.col];
            br.close();
            FileReader fr1 = new FileReader(path);
            BufferedReader br1 = new BufferedReader(fr1);
            int j=0;
            String line=br1.readLine();
            String[] str1= line.split(" ");
            while(line!=null) {
                str1= line.split(" ");
                for (int i=0;i<str.length;i++) {
                    arr[j][i]=Integer.parseInt(str1[i]);
            }
                j++;
                line=br1.readLine();
            }
            br1.close();
             /*   for(j=0;j<c;j++) {
            for (int i=0;i<str.length;i++) {
           System.out.print(arr[j][i]);
        }
                System.out.println(" ");
                }   */
        }
        catch(Exception e){
            System.out.println("File could not be read");
        }
    }

    
   /*  public void searchOne() {

           Position[] offset = new Position[8];
        for (int i = 0; i <= 7; i++) {
            offset[i] = new Position();
        }

        offset[0].row = 0;
        offset[0].col = 1; // Sağ

        offset[1].row = 1;
        offset[1].col = 0; // Aşağı

        offset[2].row = 0;
        offset[2].col = -1; // Sol

        offset[3].row = -1;
        offset[3].col = 0; // Yukarı

        offset[4].row = -1;
        offset[4].col = 1; //Sağ çarpraz

        offset[5].row = -1;
        offset[5].col = -1; //Sol yukarı

        offset[6].row = 1;
        offset[6].col = 1; //Sağ alt

        offset[7].row = 1;
        offset[7].col = -1; //Sol aşağı

      
            for (int j = 0; j < arr2.row; j++) {
            for (int i = 0; i < arr2.col; i++) {
             start.row=j;
             start.col=i;
         for(int x=0;x<8;x++) {
          if(arr[start.row][start.col]==1) {
             starmaze[start.row][start.col]="*";
             start.row=j;
             start.col=i;
          }


          else{ 
              
         
             starmaze[start.row][start.col]=" ";
             start.row=j;
             start.col=i;
             
 }
          

        start.row+=offset[x].row;
        start.col+=offset[x].col;
        }
         
            
            }}
     }

        */

    @Override
    public void OutputShapes() {
       
        
        Position[] offset = new Position[8];
        for (int i = 0; i <= 7; i++) {
            offset[i] = new Position();
        }

        offset[0].row = 0;
        offset[0].col = 1; // Sağ

        offset[1].row = 1;
        offset[1].col = 0; // Aşağı

        offset[2].row = 0;
        offset[2].col = -1; // Sol

        offset[3].row = -1;
        offset[3].col = 0; // Yukarı

        offset[4].row = -1;
        offset[4].col = 1; //Sağ çarpraz

        offset[5].row = -1;
        offset[5].col = -1; //Sol yukarı

        offset[6].row = 1;
        offset[6].col = 1; //Sağ alt

        offset[7].row = 1;
        offset[7].col = -1; //Sol aşağı
        
        
        arr2.col=arr1.col+2;
        arr2.row=arr1.row+2;
        maze=new int[arr2.row][arr2.col];

        for (int a= 0; a <1; a++) {
            for (int b = 0; b < arr2.col; b++) {
            
            maze[a][b]=0;
            }} 
        
         for (int a= arr2.row-1; a <arr2.row; a++) {
            for (int b = 0; b < arr2.col; b++) {
            
            maze[a][b]=0;
            }} 
         
         for (int a= 0; a <arr2.row; a++) {
            for (int b = 0; b <1; b++) {
            
            maze[a][b]=0;
            }} 
         
         for (int a= 0; a <arr2.row; a++) {
            for (int b = arr2.col-1; b <arr2.col; b++) {
            
            maze[a][b]=0;
            }} 
         
         for (int j = 0; j < arr1.row; j++) {
            for (int i = 0; i < arr1.col; i++) {
                maze[j+1][i+1]=arr[j][i];
            }
        }      
        
                
           for (int j = 0; j < arr2.row; j++) {
            for (int i = 0; i < arr2.col; i++) {
                System.out.print(maze[j][i]);
            }
            System.out.println(" ");
        }      
        
     


        
 starmaze=new String[20][20];
   for (int j = 1; j < arr2.row-1; j++) {
            for (int i = 1; i < arr2.col-1; i++) {
             start.row=j;
             start.col=i;
         for(int x=0;x<8;x++) {
          if(maze[start.row][start.col]==1) {
             starmaze[start.row][start.col]="*";
             start.row=j;
             start.col=i;
          }


          else{
              
         
             starmaze[start.row][start.col]=" ";
             start.row=j;
             start.col=i;
             
 }
          

        start.row+=offset[x].row;
        start.col+=offset[x].col;
        }
         
            
            }}
            for (int j = 0; j < arr2.row-1; j++) {
            for (int i = 0; i < arr2.col-1; i++) {
                System.out.print(starmaze[j][i]);
            }
            System.out.println(" ");
            
        }   
                       
       int shapecounter = 1;
            int tempcounter = 0;
            int oldshapecounter = 0;
            for(int rw = 1; rw<(arr2.row-1);rw++){
                for(int cl = 1; cl<(arr2.col-1);cl++){
                    if(maze[rw][cl]!=0){         
                       // shapecounter += 1;
                        if(maze[rw][cl]==1){
                            oldshapecounter +=1;
                            shapecounter = oldshapecounter;
                        }
                        maze[rw][cl]= shapecounter;
                        here.row=rw;
                        here.col=cl;
                        for(int y = 0; y<8; y++){
                            here.row+=offset[y].row;
                            here.col+=offset[y].col;
                            if(maze[here.row][here.col]<shapecounter && maze[here.row][here.col]>1){
                                tempcounter +=1;
                                //oldshapecounter =shapecounter;
                                shapecounter = maze[here.row][here.col];
                                shapecounter=shapecounter+1;
                                maze[rw][cl]=shapecounter-1;
                                }
                            if(maze[here.row][here.col]>maze[rw][cl]){
                                maze[here.row][here.col] = maze[rw][cl]+1;
                                        // shapecounter++;
                         }
              
                            if(maze[here.row][here.col]==1) {
                                maze[here.row][here.col]=shapecounter;
                             //   tempcounter +=1;

                            }
                            here.row =rw;
                            here.col =cl;                         
                            
                        }
                        if(tempcounter ==0){
                            oldshapecounter = shapecounter;
                             tempcounter +=1;
                     //  shapecounter++;
                        }
                        
                        if(tempcounter!=0) {
                        tempcounter -=1;
                       shapecounter--;
                        
                        }
                       
                        shapecounter++;
                           
                    }
                    tempcounter = 0;
                }
           
            }
            // Addeddd
                    
            
            
             for (int j = 0; j < arr2.row-1; j++) {
            for (int i = 0; i < arr2.col-1; i++) {
             start.row=j;
             start.col=i;
             if(maze[start.row][start.col]!=0) {
         for(int x=0;x<8;x++) {
           if(maze[start.row][start.col]<(maze[start.row+offset[x].row][start.col+offset[x].col]) )
           {
       maze[start.row+offset[x].row][start.col+offset[x].col]  =maze[start.row][start.col];         
           }
           
          else if(maze[start.row][start.col]>(maze[start.row+offset[x].row][start.col+offset[x].col]) && maze[start.row][start.col]>0 && maze[start.row+offset[x].row][start.col+offset[x].col]>0 ) {
         maze[start.row][start.col] =maze[start.row+offset[x].row][start.col+offset[x].col];
           }
           else { 
             start.row=j;
             start.col=i;
                   }
 
 
                }
         
             }
            }}
            
            
            
            //added
                    
            
            
             int max=0;
            
            
            for(int f=0;f<arr2.row-1;f++) {
            for(int l=0;l<arr2.col-1;l++) {
            
            System.out.print(maze[f][l]);
            }
            System.out.println("");
            }
    for(int f=0;f<arr2.row;f++) {
            for(int l=0;l<arr2.col;l++){
                
              if(maze[f][l]>0) {
               if(maze[f][l]>max) {
               max=maze[f][l];
               
               }
              
              }
            }}
    a=max;
    System.out.println("We have " + (max-1) + " shape.");
    for(int i=1;i<max;i++) {   
        System.out.println("Shape " + i );
    for(int f=0;f<arr2.row-1;f++) {
            for(int l=0;l<arr2.col-1;l++)  {
         if(maze[f][l]==(i+1)) {
         
         System.out.print("*");
         }
         
         else {
         
         System.out.print(" ");
         }
        
                
            } System.out.println(" ");}
            }
    
}
        
    


    @Override
    public void OutputShapesToFile(String path) {

        try {


            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
          for(int i=1;i<a;i++) {   
                 bw.write("Shape " + (i));
                   bw.write("\n");
            for(int f=0;f<arr2.row;f++) {
                for(int l=0;l<arr2.col;l++) {
                    
                    if(maze[f][l]==(i+1)) {
         
                             bw.write("*");
         }
                     else {
         
                            bw.write(" ");
                         }
                }
                bw.write("\n");
            }
        }
            bw.close();


        }

        catch(Exception e){
            System.out.println("File could not be read");
        }

    }

}
