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
    private Map<Jogador,Carta> cartas_na_mesa = new HashMap<Jogador,Carta>();
    private boolean empate, truco;
    private Jogador vencedorTruco;
    public Rodada(){
        this.empate=false;
        this.truco=false;
    }
    

    public void addCarta(Carta carta, Jogador jogador){
        if(carta!=null)
            this.cartas_na_mesa.put(jogador, carta);
    }
    
    public boolean isTruco(){
        return this.truco;
    }
//Retorna qual jogador que mandou a maior carta.
//Se der empate ele retorna o último (o que cangou)
    public Jogador getVencedor(){
        if(this.isTruco()){
            return this.vencedorTruco;
        }
        Jogador maior=null;
        for(Entry<Jogador,Carta> c : this.cartas_na_mesa.entrySet()){
            if(maior==null || this.cartas_na_mesa.get(maior).getPeso()<= c.getValue().getPeso()){
                if(maior!=null && this.cartas_na_mesa.get(maior).getPeso()== c.getValue().getPeso())
                    this.empate=true;
                else
                    this.empate=false;
                maior=c.getKey();
            }
                
        }
        return maior;
    }
    
    public Jogador getJogadorVencedorTemp(){
        return this.getVencedor();
    }  
    
    public Carta getMaiorCartaAtual(){
        Carta maior=null;
        for(Entry<Jogador,Carta> c : this.cartas_na_mesa.entrySet()){
            if(maior==null || maior.getPeso()<= c.getValue().getPeso()){
                maior=c.getValue();
            }
                
        }
                
        return maior;
    }
    public boolean isEmpate(){        
        return this.empate;
    }
}
