/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Skylake-Adry
 */
public class Practica {
    /**
     *
     * @param argv
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] argv) throws IOException{
        
 
        String cad = null;
        int m=argv.length;
        List<String> noms= new ArrayList<String>();
        List<String> ncadenes=new ArrayList<String>();
        List<Genoma> genomes = new ArrayList<Genoma>();
        
        noms.add("Bovi");noms.add("Cocodril");noms.add("Conill");noms.add("Gallina");noms.add("Gat");noms.add("Gos"); noms.add("huma");noms.add("macaco"); noms.add("orangutan");
        noms.add("ovi"); noms.add("porc");noms.add("ratoli");noms.add("ximpanze");
        for(int i=0;i < m; i++){
            String cadena;
            File fichero;
            FileReader f;
            BufferedReader b;
            fichero = new File("C:/Users/Skylake-Adry/Desktop/PROP/Nucleotids proteina albumina/",argv[i]);
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
        
    }

   /* public void taula_coincideincies(ArrayList<Genomes> a){
        int [][] taula_coinci=new int [a.lenght()][a.lenght()];
        for(int i=0;i<a.lenght();++i){
            for(int k=0;k<a.lenght();++k){
                taula_coinci[i][k]=this.lcs(a[i],a[k]);
            }
        }
        return taula_coinci;
    }
    */


    
}
