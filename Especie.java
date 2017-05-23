/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Skylake-Adry
 */
public class Especie {
    private Genoma adn;
    private String nom;
    
    public Especie(Genoma animal, String name){
        adn=animal;
        nom=name;
    }

    public Genoma getAdn() {
        return adn;
    }

    public String getNom() {
        return nom;
    }

    
    
}
