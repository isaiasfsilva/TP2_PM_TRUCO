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
public class SuperRodada {
    private int pontos_em_disputa;
    private boolean truco;
    private static Jogador DonoDoBaralho;
    private Dupla Desafiante; // Quem chamou o truco!!!
    public SuperRodada(){
        this.pontos_em_disputa=0;
        this.truco=false;
        this.Desafiante=null;
        this.addPontosEmDisputa(2);
        Game game = Game.getGame();
         DonoDoBaralho=(DonoDoBaralho==null)?game.getDupla(1).getJogadorA():this.proximoAJogar(DonoDoBaralho);
           
    }
    
    public void addPontosEmDisputa(int n){
        this.pontos_em_disputa+=n;
    }
    
    public int getPontosEmDisputa(){
        return this.pontos_em_disputa;
    }
    
    public Dupla Play(){
        
            
        
            Game game = Game.getGame();
            Baralho baralho = Baralho.getBaralho();
            
            Rodada rodada1= new Rodada();
            Rodada rodada2= new Rodada();
            Rodada rodada3= new Rodada();
            
            Jogador quemcomeca = DonoDoBaralho;
           
            this.distribuiCartas(quemcomeca);
            
            
            //Jogador da dupla 1 sempre começa jogando

            this.jogaAsCartas(quemcomeca, rodada1);

            if(isTruco()==false){
                System.out.println("A maior carta jogada foi: "+rodada1.getMaiorCartaAtual().getNome()+" - Jogador: "+rodada1.getJogadorVencedorTemp().getNome());
                System.out.println("\nVamos para a rodada 2!!\n\n");
               
                
                quemcomeca=rodada1.getVencedor();
                this.jogaAsCartas(quemcomeca, rodada2);
                if(isTruco()==false){
                  if(game.getDuplaFromJogador(rodada1.getVencedor())==game.getDuplaFromJogador(rodada2.getVencedor())){
                        return game.getDuplaFromJogador(rodada1.getVencedor());
                        
                    }else{
                         System.out.println("A maior carta jogada foi: "+rodada2.getMaiorCartaAtual().getNome()+" - Jogador: "+rodada2.getJogadorVencedorTemp().getNome());
                        System.out.println("Estão empatados! Vamos para a rodada 3!!\n");
        //Rodada 3
                       
                        quemcomeca=rodada2.getVencedor();
                       
                        this.jogaAsCartas(quemcomeca, rodada3);

                        System.out.println("A maior carta jogada foi: "+rodada3.getMaiorCartaAtual().getNome()+" - Jogador: "+rodada3.getJogadorVencedorTemp().getNome());
                        if(isTruco())
                            return getDesafiante();
                        
                            return game.getDuplaFromJogador(rodada3.getVencedor());
                  }
                }else{
                    return getDesafiante();
                }
                
            }else{
               
                return getDesafiante();
            }
            
            
          
    }
    
        private void distribuiCartas(Jogador dono) {
        Baralho baralho = Baralho.getBaralho();
        baralho.embaralha();
        this.proximoAJogar(dono).zeraMao();
        this.proximoAJogar(dono).addCarta(baralho.getCarta(1));        
        this.proximoAJogar(dono).addCarta(baralho.getCarta(2));
        this.proximoAJogar(dono).addCarta(baralho.getCarta(3));
        
        Jogador tmp = proximoAJogar(dono);
        this.proximoAJogar(tmp).zeraMao();
        this.proximoAJogar(tmp).addCarta(baralho.getCarta(4));
        this.proximoAJogar(tmp).addCarta(baralho.getCarta(5));
        this.proximoAJogar(tmp).addCarta(baralho.getCarta(6));
        
        tmp = proximoAJogar(tmp);
        this.proximoAJogar(tmp).zeraMao();
        this.proximoAJogar(tmp).addCarta(baralho.getCarta(7));        
        this.proximoAJogar(tmp).addCarta(baralho.getCarta(8));
        this.proximoAJogar(tmp).addCarta(baralho.getCarta(9));
        
        dono.zeraMao();
        dono.addCarta(baralho.getCarta(10));
        dono.addCarta(baralho.getCarta(11));
        dono.addCarta(baralho.getCarta(12));
    }
        
        
   private Jogador proximoAJogar(Jogador j){
       //Simula um "mini-estado", pois ele muda o jogador que vai jogar
        Game game = Game.getGame();
        if(game.getDupla(1).getJogadorA()==j)
            return game.getDupla(2).getJogadorA();
        if(game.getDupla(2).getJogadorA()==j)
            return game.getDupla(1).getJogadorB();
        if(game.getDupla(1).getJogadorB()==j)
            return game.getDupla(2).getJogadorB();
        if(game.getDupla(2).getJogadorB()==j)
            return game.getDupla(1).getJogadorA();
        
        return null;
    }
    
            
            
    private void listaTodasAsCartasParaJogar() {
        Game game = Game.getGame();
        System.out.println("Cartas da dupla 1:\n\t"+game.getDupla(1).getJogadorA().getNome());
        game.getDupla(1).getJogadorA().listaCartasDisponiveis();
        System.out.println("\n\t"+game.getDupla(1).getJogadorB().getNome());
        game.getDupla(1).getJogadorB().listaCartasDisponiveis();

        System.out.println("Cartas da dupla 2:\n\t"+ game.getDupla(2).getJogadorA().getNome());
        game.getDupla(2).getJogadorA().listaCartasDisponiveis();
        System.out.println("\n\t"+ game.getDupla(2).getJogadorB().getNome());
        game.getDupla(2).getJogadorB().listaCartasDisponiveis();
    }

    
    private void jogaAsCartas(Jogador jogador, Rodada rodada) {
        Game game = Game.getGame();
        //Esse Do-While faz com que cada jogador jogue
         Jogador tmp = jogador;
         do{
        
            rodada.addCarta(tmp.escolheUmaCarta(rodada.getMaiorCartaAtual(), rodada.getJogadorVencedorTemp(), rodada.getJogadorVencedorTemp()==game.getDuplaFromJogador(tmp).getMeuParceiro(jogador)), tmp);
            tmp=this.proximoAJogar(tmp);
            
        }while(tmp!=jogador && this.isTruco()==false);

 }
    
    public void setTruco(){
        this.truco=true;
    }
    
    public boolean isTruco(){
        return this.truco;
    }
    
    public Dupla getDesafiante(){
        return this.Desafiante;
    }
    
    public void setDesafiante(Dupla d){
        this.Desafiante=d;
    }
}
