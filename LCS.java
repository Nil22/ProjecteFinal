import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by ogilo on 15/05/2017.
 */
public class LCS {
    // default arguments on i,j equale to 0

    public int [][] LCS(char b [], char c[], int i, int j){
        int [][] result =new int [b.length()][c.length()];
        int [][] result_aux =new int [b.length()][c.length()];
        for (int k = 0; k <b.length() ; i++) {
            result[k][0]=0;
        }
        for (int k = 0; k <c.length() ; i++) {
            result[0][k]=0;
        }
        while(i<b.length()){
            while(j<c.length()){
                if(b[i]==c[j]){
                    result[i][j]=1;
                }
                else{
                    result=this.LCS(b,c,i+1,j);
                    result_aux=this.LCS(b,c,i,j+1);
                }
            }
        }
        for(int i=1;i<b.length();++i){
            for (int k = 0; k <c.length() ; k++) {
                if(result_aux[i][j]==1){
                    result[i][j]=1;
                }
            }
        }
        return result;
    }



}

