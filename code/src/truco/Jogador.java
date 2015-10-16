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
public final class Jogador {
    private String nome;
    private Carta[] cartas= new Carta[3];
    private boolean IA;
    
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
            if(this.cartas[i]!=null)
                System.out.println("Carta "+i+": "+this.cartas[i].getNome(nome));
        }
             
    }
    
    public Carta getMaiorCarta(){
        Carta maior=null;
       for(int i=0;i<3;i++){
            if(this.cartas[i]!=null && (maior==null || maior.getPeso()<this.cartas[i].getPeso()))
                maior = this.cartas[i];
        }
       return maior;
    }
    
    
    public boolean isIA(){
        return this.IA;
    }
}
