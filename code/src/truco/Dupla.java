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
public final class Dupla {

    private Jogador jogadorA, jogadorB;
    private int pontos;
    private String nome;
    public Dupla(Jogador A, Jogador B){
       this.setJogadorA(A);
       this.setJogadorB(B);
       this.zeraPontos();
    }
    
    public Dupla(Jogador A){
        this.setJogadorA(A);
        this.setJogadorB(new Jogador("Jogador B",true)); //é Jogador com IA
        this.zeraPontos();
    }

    
    
    public Dupla(){
        this.setJogadorA(new Jogador("Jogador A", true)); //é Jogador com IA
        this.setJogadorB(new Jogador("Jogador B",true)); //é Jogador com IA
        this.zeraPontos();
    }
    
    public void setNome(String n){
        this.nome=n;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    
    private void zeraPontos(){
        this.pontos=0;
    }
    
    public int getPontos(){
        return this.pontos;
    }
    
    public void addPontos(int ptos){
        this.pontos+=ptos;
    }
    private void setJogadorA(Jogador A) {
        this.jogadorA=A;
    }

    private void setJogadorB(Jogador B) {
        this.jogadorB=B;
    }
    
    public Jogador getJogadorA() {
        return this.jogadorA;
    }

    public Jogador getJogadorB() {
        return  this.jogadorB;
    }
    
    public Jogador getMeuParceiro(Jogador j){
        if(j==this.getJogadorA())
            return this.getJogadorB();
        else
            return this.getJogadorA();
    }
}
