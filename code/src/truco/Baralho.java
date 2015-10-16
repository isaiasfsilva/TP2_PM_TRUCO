/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author isaiasfaria
 */
public final class Baralho {
    public ArrayList<Carta> cartas = new ArrayList<Carta>();
    
    public Baralho(){
        this.loadCartas();
    }

    private void loadCartas() {
    //Paus     
        this.cartas.add(new Carta("5 de Paus",2));
        this.cartas.add(new Carta("6 de Paus",3));
        this.cartas.add(new Carta("7 de Paus",4));
        this.cartas.add(new Carta("Dama de Paus",5));
        this.cartas.add(new Carta("Valete de Paus",6));
        this.cartas.add(new Carta("Rei de Paus",7));
        this.cartas.add(new Carta("Ás de Paus",8));
        this.cartas.add(new Carta("2 de Paus",9));
        this.cartas.add(new Carta("3 de Paus",10));        
        this.cartas.add(new Carta("Zap",14));
    //Copas
       
        this.cartas.add(new Carta("4 de Copas",1));
        this.cartas.add(new Carta("5 de Copas",2));
        this.cartas.add(new Carta("6 de Copas",3));
        this.cartas.add(new Carta("Dama de Copas",5));
        this.cartas.add(new Carta("Valete de Copas",6));
        this.cartas.add(new Carta("Rei de Copas",7));
        this.cartas.add(new Carta("Ás de Copas",8));
        this.cartas.add(new Carta("2 de Copas",9));
        this.cartas.add(new Carta("3 de Copas",10));        
        this.cartas.add(new Carta("7 Copas",13));
        
    //Ouros
        
        this.cartas.add(new Carta("4 de Ouros",1));
        this.cartas.add(new Carta("5 de Ouros",2));
        this.cartas.add(new Carta("6 de Ouros",3));
        this.cartas.add(new Carta("Dama de Ouros",5));
        this.cartas.add(new Carta("Valete de Ouros",6));
        this.cartas.add(new Carta("Rei de Ouros",7));
        this.cartas.add(new Carta("Ás de Ouros",8));
        this.cartas.add(new Carta("2 de Ouros",9));
        this.cartas.add(new Carta("3 de Ouros",10));        
        this.cartas.add(new Carta("7 Ouros",11));
        
    //Espadas
        
        this.cartas.add(new Carta("4 de Espadas",1));
        this.cartas.add(new Carta("5 de Espadas",2));
        this.cartas.add(new Carta("6 de Espadas",3));
        this.cartas.add(new Carta("7 de Espadas",4));
        this.cartas.add(new Carta("Dama de Espadas",5));
        this.cartas.add(new Carta("Valete de Espadas",6));
        this.cartas.add(new Carta("Rei de Espadas",7));
        this.cartas.add(new Carta("2 de Espadas",9));
        this.cartas.add(new Carta("3 de Espadas",10));        
        this.cartas.add(new Carta("Espadilha",12));
    }
    
    public final void embaralha(){        
        Collections.shuffle(this.cartas);       
    }
    
    public final Carta getCarta(int i){

        return this.cartas.get(i);
    }
    
    public final void retornaCarta(Carta c){
        this.cartas.add(c);
    }

}
