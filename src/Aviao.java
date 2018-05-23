
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ítalo
 */
public class Aviao{
    Random aleatorio = new Random();
    int ppista = aleatorio.nextInt(2);
    private String name;
    public Aviao(String name){
        this.name = name;
    }
    private String gerarfila(){
        if(ppista == 0){
            return "Pista1";
        }
        return "Pista2";
    }
    public void manobra(){
        int r = aleatorio.nextInt(5) +3;
        System.out.println("O "+this.name+" está manobrando. Duração :"+r+" segundos");
        try {
            wait(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void taxiar(){
        int r = aleatorio.nextInt(4) +2;
        System.out.println("O "+this.name+" está taxiando. Duração :"+r+" segundos");
        try {
            wait(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void posicionar(){
        int r = aleatorio.nextInt(4) +1;
        System.out.println("O "+this.name+" posicionou-se na cabeceira da pista. Duração :"+r+" segundos");
        try {
            wait(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void acelerar(){
        int r = aleatorio.nextInt(3) +3;
        System.out.println("O "+this.name+" acelerou e irá decolar. Duração :"+r+" segundos");
        try {
            wait(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void decolar(){
        int r = aleatorio.nextInt(4) +4;
        System.out.println("O "+this.name+" decolou. Duração :"+r+" segundos");
        try {
            wait(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void afastar(){
        int r = aleatorio.nextInt(5) +2;
        System.out.println("O "+this.name+" afastou-se. Duração :"+r+" segundos");
        try {
            wait(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
