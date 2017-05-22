import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by ogilo on 15/05/2017.
 */
public class LCS {
    // default arguments on i,j equale to 0
    public char b[];
    public char c [];
    public LCS(){
        Scanner first=new Scanner(System.in);
        Scanner second=new Scanner(System.in);
        this.b=new char[1000000];
        this.c=new char[1000000];
        int i=0;
        while(first.hasNext()){
            b[i]=first.next().charAt(0);
            ++i;
        }
        i=0;
        while(second.hasNext()){
            c[i]=second.next().charAt(0);
            ++i;
        }
        int [][] result = new int [b.length][c.length];
        result=this.LCS(b,c);
    }
    public int [][] LCS_recursivo(char b [], char c[], int i, int j){
        int [][] result =new int [b.length][c.length];
        int [][] result_aux =new int [b.length][c.length];
        for (int k = 0; k <b.length ; k++) {
            result[k][0]=0;
        }
        for (int k = 0; k <c.length ; k++) {
            result[0][k]=0;
        }
        while(i<b.length){
            while(j<c.length){
                if(b[i]==c[j]){
                    result[i][j]=1;
                }
                else{
                    result=this.LCS_recursivo(b,c,i+1,j);
                    result_aux=this.LCS_recursivo(b,c,i,j+1);
                }
            }
        }
        for(int l=1;l<b.length;++i){
            for (int k = 0; k <c.length ; k++) {
                if(result_aux[i][j]==1){
                    result[i][j]=1;
                }
            }
        }
        return result;
    }

    public int [][] LCS(char[] b,char[] c){
        int [][] result =new int [b.length][c.length];
        for (int k = 0; k <b.length ; k++) {
            result[k][0]=0;
        }
        for (int k = 0; k <c.length ; k++) {
            result[0][k]=0;
        }
        for (int i = 0; i <b.length ; i++) {
            for (int j = 0; j <c.length ; j++) {
                if(b[i]==c[j]) result[i][j]=1;
            }
        }
    return result;
    }


}

