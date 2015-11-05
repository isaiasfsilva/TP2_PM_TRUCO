/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;

import java.util.Scanner;

/**
 *
 * @author isaiasfaria
 */
public final class Game {
    private Dupla dupla1, dupla2; 
    private static Game game;
    private SuperRodada srAtual;
    private Game(){
         carregaGame();
        
    }
    
    public static Game getGame(){
    if(game==null)
        game=new Game();
    return game;
    }
    
    public Dupla getDupla(int i){
        return ((i==1)?this.dupla1:this.dupla2);
    }
    
    public void playNow(){
        System.out.println("Vamos começar!");
        mostraPlacar();
        //Laço do jogo
       
        while(this.getDupla(1).getPontos()<=10 && this.getDupla(2).getPontos()<=10){
            
            SuperRodada sr = new SuperRodada();
            this.setSuperRodada(sr);
           
            
            Dupla venc = sr.Play();
            venc.addPontos(sr.getPontosEmDisputa());
            System.out.println("Wow!, "+sr.getPontosEmDisputa()+" pontos para a dupla "+venc.getNome());
             //Próximo dono do baralho
        }
        if(this.dupla1.getPontos()>10){
            System.out.println("TAM TAM TAM TAM!!!! \n\tA dupla 1 venceu!\n\t"+this.dupla1.getJogadorA().getNome()+" & "+this.dupla1.getJogadorB().getNome()+" jogam muito!\n\n");
        }else{
            System.out.println("TAM TAM TAM TAM!!!! \n\tA dupla 2 venceu!\n\t"+this.dupla2.getJogadorA().getNome()+" & "+this.dupla2.getJogadorB().getNome()+" jogam muito!\n\n");
        }
        
        System.out.println("E aí, aceita uma arrevanche? haha");
    }
    private void carregaGame(){
        
        System.out.println("Insira informações da dupla 1:");
        System.out.println("\tInsira '1' para duas pessoas\n\tInsira '2' para fazer dupla com uma IA\n\tInsira '3' para ser uma dupla de IA's");
        this.dupla1=this.criaDupla();   
        this.dupla1.setNome("Dupla 1");
        System.out.println("Dupla 1 criada com sucesso...");
        
        System.out.println("Insira informações da dupla 2:");
        System.out.println("\tInsira '1' para duas pessoas\n\tInsira '2' para fazer dupla com uma IA\n\tInsira '3' para ser uma dupla de IA's");
         this.dupla2=this.criaDupla();
         this.dupla2.setNome("Dupla 2");
        System.out.println("Dupla 2 criada com sucesso...");
    }
    
    
    //Cria as duplas para o jogo
    private Dupla criaDupla(){
        Scanner s = new Scanner(System.in);
        Dupla d =null;
        switch(s.next()){
            case "1":{//Dupla com dois jogadores reais
               System.out.println("Insira o nome do Jogador 1:");
               String j1=s.next();
               System.out.println("Insira o nome do Jogador 2:");
               String j2=s.next();
               d=new Dupla(new Jogador(j1), new Jogador(j2));
            }break;
            case "2":{//Dupla com um jogador real
               System.out.println("Insira o nome do Jogador 1:");
               String j1=s.next();               
               d=new Dupla(new Jogador(j1));              
            }break;
            case "3":{
                d=new Dupla();
            }break;
            default: {
                System.out.println("Opção Inválida. Finalizando o programa...");
                System.exit(0);
            }break;
        }
       return d;
    }
    

    
    private void mostraPlacar(){
        
        System.out.println("O placar atual é:\n\t Dupla 1: "+this.getDupla(1).getPontos()+"\n\t Dupla 2: "+this.getDupla(2).getPontos()+"\n");
    }




    public Dupla getDuplaFromJogador(Jogador j){
        if(j==null) 
            return null;
        if(this.getDupla(1).getJogadorA()==j || this.getDupla(1).getJogadorB()==j)
            return this.getDupla(1);
        else
            return this.getDupla(2);
    }
    public SuperRodada getSuperRodada(){
        return this.srAtual;
    }
    
    private void setSuperRodada(SuperRodada sr) {
        this.srAtual=sr;
    }
    
    public Dupla getDuplaAdversaria(Dupla d){
        return (d==this.dupla2)?this.dupla1:this.dupla2;
    }
}
