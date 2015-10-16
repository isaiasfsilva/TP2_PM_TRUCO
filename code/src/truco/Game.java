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
    private Baralho baralho;
    public Game(){
         this.carregaGame();
         this.criaBaralho();
     }
    
    
    public void playNow(){
        System.out.println("Vamos começar!");
        this.mostraPlacar();
        //Laço do jogo
        while(this.dupla1.getPontos()<=10 && this.dupla2.getPontos()<=10){
            //Rodada1
            Rodada rodada = new Rodada();
            this.embaralha();
            this.distribuiCartas();
            this.listaTodasAsCartasParaJogar();  
            
            
            
            
            this.dupla1.addPontos(30);
            
            //Rodada2
            
            //Rodada3
            
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
        System.out.println("Dupla 1 criada com sucesso...");
        
        System.out.println("Insira informações da dupla 2:");
        System.out.println("\tInsira '1' para duas pessoas\n\tInsira '2' para fazer dupla com uma IA\n\tInsira '3' para ser uma dupla de IA's");
         this.dupla2=this.criaDupla();            
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
    
    private void embaralha(){
        this.baralho.embaralha();
    }
    private void criaBaralho() {
        this.baralho=new Baralho();
    }
    
    private void mostraPlacar(){
        
        System.out.println("O placar atual é:\n\t Dupla 1: "+this.dupla1.getPontos()+"\n\t Dupla 2: "+this.dupla2.getPontos()+"\n");
    }

    private void distribuiCartas() {
        this.dupla1.getJogadorA().addCarta(this.baralho.getCarta(1));        
        this.dupla1.getJogadorA().addCarta(this.baralho.getCarta(2));
        this.dupla1.getJogadorA().addCarta(this.baralho.getCarta(3));
        this.dupla1.getJogadorB().addCarta(this.baralho.getCarta(4));
        this.dupla1.getJogadorB().addCarta(this.baralho.getCarta(5));
        this.dupla1.getJogadorB().addCarta(this.baralho.getCarta(6));
        
        this.dupla2.getJogadorA().addCarta(this.baralho.getCarta(7));        
        this.dupla2.getJogadorA().addCarta(this.baralho.getCarta(8));
        this.dupla2.getJogadorA().addCarta(this.baralho.getCarta(9));
        this.dupla2.getJogadorB().addCarta(this.baralho.getCarta(10));
        this.dupla2.getJogadorB().addCarta(this.baralho.getCarta(11));
        this.dupla2.getJogadorB().addCarta(this.baralho.getCarta(12));
    }

    private void listaTodasAsCartasParaJogar() {
        System.out.println("Cartas da dupla 1:\n\t"+this.dupla1.getJogadorA().getNome());
        this.dupla1.getJogadorA().listaCartasDisponiveis();
        System.out.println("\n\t"+this.dupla1.getJogadorB().getNome());
        this.dupla1.getJogadorB().listaCartasDisponiveis();

        System.out.println("Cartas da dupla 2:\n\t"+this.dupla2.getJogadorA().getNome());
        this.dupla2.getJogadorA().listaCartasDisponiveis();
        System.out.println("\n\t"+this.dupla2.getJogadorB().getNome());
        this.dupla2.getJogadorB().listaCartasDisponiveis();
    }
}
