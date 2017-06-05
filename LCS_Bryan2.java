import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LCS_Bryan2 {

 
  
    public static void fil_col_zero (int mat[][], int n , int m){ // n i m guardan la longitud de las cades x e y
        int i, j;
        for(i=0; i< n ; i++){
            mat[i][0]=2*i;
        }

        for (j=0; j< m; j++){
            mat[0][j]=2*j;
        }
    }

    
    public static  int lcs (String x, String y, int n, int m){
        int [][] mat= new int[n][m];
        for(int i=1; i< n ; i++){
            for(int j=1; j< m;j++){
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

    



    public static void main(String[] argv) throws IOException{
        String cad = null;
        int m=argv.length;
        List<String> noms= new ArrayList<String>();
        List<String> ncadenes=new ArrayList<String>();
        ArrayList<Genoma> genomes = new ArrayList<Genoma>();

        noms.add("Bovi");noms.add("Cocodril");noms.add("Conill");noms.add("Gallina");noms.add("Gat");noms.add("Gos"); noms.add("huma");noms.add("macaco"); noms.add("orangutan");
        noms.add("ovi"); noms.add("porc");noms.add("ratoli");noms.add("ximpanze");
        for(int i=0;i < m; i++){
            String cadena;
            File fichero;
            FileReader f;
            BufferedReader b;
            fichero = new File("C:/Users/ogilo/IdeaProjects/ProjecteFinal/Nucleotids proteina albumina",argv[i]);
            f=new FileReader(fichero);
            b=new BufferedReader(f);
            String linea;
            while((linea=b.readLine())!=null){
                cad=linea;
            }
            ncadenes.add(cad);
        }

        Iterator it=noms.iterator();
        Iterator it2=ncadenes.iterator();

        while(it.hasNext() && it2.hasNext()){
            Genoma g;
            g=new Genoma((String) it2.next(), (String) it.next());
            genomes.add(g);
        }

        int[][] taula=new int[genomes.size()][genomes.size()];
        taula=taula_coincidencies(genomes);
        for (int i = 0; i < genomes.size(); i++) {
            for (int j = 0; j <genomes.size() ; j++) {
                System.out.print(taula[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }


    }
    public static  int[][] taula_coincidencies(ArrayList<Genoma> a){
        int [][]taula=new int [a.size()][a.size()];
        for (int i = 0; i < a.size() ; i++) {
            for (int j = 0; j < a.size() ; j++) {
                taula[i][j]=lcs(a.get(i).getCadena(),a.get(j).getCadena(),a.get(i).getCadena().length(),a.get(j).getCadena().length());
            }

        }
        return taula;
    }


}
