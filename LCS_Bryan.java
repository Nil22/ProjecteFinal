
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.time.Clock.system;
import java.util.Scanner;
import java.math.*;


public class LCS_Bryan {

 
  
    public static void fil_col_zero (int mat[][], int n , int m){ // n i m guardan la longitud de las cades x e y
        int i, j;
        for(i=0; i< n ; i++){
            mat[i][0]=0;
        }

        for (j=0; j< m; j++){
            mat[0][j]=0;
        }
    }
    
    public static  int lcs (String x, String y, int mat[][], int n, int m){
        int i,j;
        for(i=1; i< n ; i++){
            for(j=1; j< m;j++){
                if(x.charAt(i-1) != y.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1]+1;
                    mat[i][j]= Math.min(mat[i-1][j]+2,mat[i][j]);
                    mat[i][j]= Math.min(mat[i][j-1]+2,mat[i][j]);

                }
                else{
                    mat[i][j]=mat[i-1][j-1];
                }
            
            }
        }
        return mat[n-1][m-1];
    }

    

    /*public String palabra_encontrada( String x, String y, int mat[][], int n , int m){
        String palabra="";
        while( n > 0 && m > 0){
            if(x.charAt(n-1)==y.charAt(m-1)){
                palabra  += x.charAt(n-1);
                n--;
                m--;
            }
            else{
                if(mat[n-1][m] >= mat[n][m-1]){
                    n--;
                }
                else{
                    m--;
                }
            }
        }
        return palabra;
    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String x= bf.readLine();
        BufferedReader bf1=new BufferedReader(new InputStreamReader(System.in));
        String y= bf1.readLine();
        int n=x.length()+1;
        int m=y.length()+1;
        
        int mat[][]=new int[n][m];
        
        fil_col_zero(mat,n,m);
        int res=lcs(x,y,mat,n,m);
        
        System.out.print(res);
    }
    
}
