/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 *
 * @author isaiasfaria
 */
public final class Rodada {
    private int pontos_em_disputa;
    private Map<Jogador,Carta> cartas_na_mesa = new HashMap<Jogador,Carta>();
    private boolean empate;
    public Rodada(){
        this.setPontos(2);
        this.empate=false;
    }
    
    private void setPontos(int ptos){
        this.pontos_em_disputa=ptos;
    }
    
    public void addPontos(int ptos){
        this.pontos_em_disputa+=ptos;
    }
    
    public int getPontos(){
        return this.pontos_em_disputa;
    }
    
    public void addCarta(Carta carta, Jogador jogador){
        this.cartas_na_mesa.put(jogador, carta);
    }
//Retorna qual jogador que mandou a maior carta.
//Se der empate ele retorna o último (o que cangou)
    public Jogador getVencedor(){  
        Jogador maior=null;
        for(Entry<Jogador,Carta> c : this.cartas_na_mesa.entrySet()){
            if(maior==null || this.cartas_na_mesa.get(maior).getPeso()<= c.getValue().getPeso()){
                if(this.cartas_na_mesa.get(maior).getPeso()== c.getValue().getPeso())
                    this.empate=true;
                else
                    this.empate=false;
                maior=c.getKey();
            }
                
        }
        return maior;
    }
    
      public boolean isEmpate(){        
        return this.empate;
    }
}
