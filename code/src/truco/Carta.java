/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;

/**
 *
 * @author isaiasfaria
 */
public final class Carta {
    private String nome;
    private int peso;
    
    public Carta(String nome, int peso){
        this.setNome(nome);
        this.setPeso(peso);
        
    }
   
    private void setNome(String nome){
        this.nome=nome;
    }

    public String getNome(String nome){
        return this.nome;
    }    

    public int getPeso(){
        return this.peso;
    }
    
    private void setPeso(int peso) {
        this.peso=peso;
    }
}
