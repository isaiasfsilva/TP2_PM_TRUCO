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
public final class Jogador {
    private String nome;
    private Carta[] cartas= new Carta[3];
    private boolean IA; //Se é um jogador virtual
    
    public Jogador(String nome){
        this.setNome(nome);
        this.zeraMao();
        this.IA=false;
    }
    
    public Jogador(String nome, boolean IA){
        this(nome+" - IA");
        this.IA=true;
    }
    
    private void setNome(String nome){
        this.nome=nome;
    } 
    
    public String getNome(){
       return this.nome;
    } 
        
    public void zeraMao(){
        this.cartas[0]=null;
        this.cartas[1]=null;
        this.cartas[2]=null;
    }
    
    public Carta jogaCarta(int i){
        if(i==1 || i==2 || i==3){       //Se carta válida
            if(this.cartas[i-1]!=null){
                Carta tmp=this.cartas[i-1];
                this.cartas[i-1]=null;  //Tira a carta do jogador
                return tmp;
            }else{
                return null; //Se o jogador não está com essa carta na mao
            }
        }
        return null;
    }
    
    public boolean addCarta(Carta carta){
        int i=0;
        while(this.cartas[i]!=null && i<2)
            i++;
        
        if(this.cartas[i]==null){ //Se na mão da pessoa tem menos de 3 cartas
            this.cartas[i]=carta;
            return true;
        }else{
            return false;
        }
    }
    
    public void listaCartasDisponiveis(){
       for(int i=0;i<3;i++){
            if(this.cartas[i]!=null){
                System.out.println("Carta "+(i+1)+": "+this.cartas[i].getNome());
            }
        }
             
    }
    
    public Carta getMaiorCarta(){
        Carta maior=null;
      
       for(int i=0;i<3;i++){
            if(this.cartas[i]!=null && (maior==null || maior.getPeso()<this.cartas[i].getPeso())){
                if(maior==null){
                    maior = this.cartas[i];
                    this.cartas[i]=null;
                }else{
                    Carta tmp=maior;
                    maior = this.cartas[i];
                    this.cartas[i]=tmp;
                }
                    
                
            }
        }
       
       return maior;
    }
    
    
    public boolean isIA(){
        return this.IA;
    }

    public Carta escolheUmaCarta(Carta maiorCartaDaMesa, Jogador quemJogou, Boolean isMeuParceiro) {
        Game game = Game.getGame();
        if(this.isIA())
        {
            //IMPLEMENTAR IAAAAAA
            return this.getMaiorCarta();
        }else{
            System.out.println("Olá "+this.getNome()+", sua vez de jogar! \n"+((maiorCartaDaMesa!=null)?"A carta "+maiorCartaDaMesa.getNome()+" está dominando esta rodada..":"Nenhuma carta foi jogada. Você é o primeiro!")+((isMeuParceiro)?"\n\tLembre-se: Seu parceiro está fazendo esta rodada":""));
            System.out.println("Você possui as seguintes cartas:\n");
            this.listaCartasDisponiveis();
            System.out.println("\n\tQual delas deseja jogar? (Aperte '0' para "+((game.getSuperRodada().getPontosEmDisputa()==2)?"chamar ":"aumentar o ")+" TRUCO!)");
            
            Scanner s = new Scanner(System.in);
            int id = s.nextInt();
            
           if(id==0 && game.getSuperRodada().getDesafiante()!=game.getDuplaFromJogador(this)){ //Está chamando truco!
               
                    int aceita =0;
                    game.getSuperRodada().setDesafiante(game.getDuplaFromJogador(this));
                  
                    do{
                         System.out.println(game.getDuplaAdversaria(game.getSuperRodada().getDesafiante()).getNome()+", aceita? \n\t1 = SIM\n\t0 = NAO\n\t2 = AUMENTAR");
                         aceita = s.nextInt();
                          if(aceita==0){
                             game.getSuperRodada().setTruco(); //Acabou com um truco
                          }else{
                             game.getSuperRodada().addPontosEmDisputa(2);
                             if(aceita==2) // Aumentou!
                                 game.getSuperRodada().setDesafiante(game.getDuplaAdversaria(game.getSuperRodada().getDesafiante()));
                         }
                        
                         
                    }while(aceita==2);
            
                if(game.getSuperRodada().isTruco()==false){
                                   System.out.println("Olá "+this.getNome()+", sua vez de jogar! \n"+((maiorCartaDaMesa!=null)?"A carta "+maiorCartaDaMesa.getNome()+" está dominando esta rodada..":"Nenhuma carta foi jogada. Você é o primeiro!")+((isMeuParceiro)?"\n\tLembre-se: Seu parceiro está fazendo esta rodada":""));
            System.out.println("Você possui as seguintes cartas:\n");
            this.listaCartasDisponiveis();
            System.out.println("\n\tQual delas deseja jogar?");
            id = s.nextInt();
          
               
                }
           }
           
           if(game.getSuperRodada().isTruco()==false){//Se ainda tá valendo.
               while(id < 0 || id>3 || this.cartas[id-1]==null){               
                    System.out.println("\nCarta inválida! Escolha outra para continuar...\n");
                    id = s.nextInt();

                }
                Carta carta_tmp =this.cartas[id-1];
                this.cartas[id-1]=null;
                
                return carta_tmp;
            }else{
                  
                   return null;
               }
        }
    }
}
