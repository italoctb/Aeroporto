package Application;


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
public final class Aviao implements Runnable{
    Random aleatorio = new Random();
    private final String name;
    private final boolean pertenceUm;
    private boolean andamento;
    public Aviao(String name, Pistas p1, Pistas p2){ 
        this.name = name;
        int ppista = aleatorio.nextInt(2);
        if(ppista == 0){
            p1.lista.add(this);
            System.out.println("O "+this.name+" irá para a "+p1.name);
        }else{
            p2.lista.add(this);
            System.out.println("O "+this.name+" irá para a "+p2.name);
        }
        pertenceUm = verify(p1);
        new Thread(this, name).start();
    }

    public boolean verify(Pistas p1){
        return p1.lista.contains(this);
    }
    public void manobra(){
        int r = aleatorio.nextInt(5) +3;
        try {
            Thread.sleep(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O "+this.name+" está manobrando. Duração :"+r+" segundos");
    }
    public void taxiar(){
        int r = aleatorio.nextInt(4) +2;
        try {
            Thread.sleep(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O "+this.name+" está taxiando. Duração :"+r+" segundos");
    }
    public void posicionar(){
        int r = aleatorio.nextInt(4) +1;
        try {
            Thread.sleep(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O "+this.name+" posicionou-se na cabeceira da pista. Duração :"+r+" segundos");
    }
    public void acelerar(){
        int r = aleatorio.nextInt(3) +3;   
        try {
            Thread.sleep(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O "+this.name+" acelerou e irá decolar. Duração :"+r+" segundos");
    }
    public void decolar(){
        int r = aleatorio.nextInt(4) +4;   
        try {
            Thread.sleep(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O "+this.name+" decolou. Duração :"+r+" segundos");
    }
    public void afastar(){
        int r = aleatorio.nextInt(5) +2;   
        try {
            Thread.sleep(r*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O "+this.name+" afastou-se. Duração :"+r+" segundos");
    }
    public void exec(){
        this.manobra();
        this.taxiar();
        this.posicionar();
        this.acelerar();
        this.decolar();
        this.afastar(); 
    }
    public synchronized void execPistaUm(){
           exec();
           andamento = true;
           notify();
           while(andamento){
               try {
                   wait();
               } catch (InterruptedException ex) {
                   Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
    }
    public synchronized void execPistaDois(){
            exec();
            andamento = false;
            notify();
            while(andamento){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    @Override
    public void run() {
        if(pertenceUm){
            execPistaUm();
        }else{
            execPistaDois();
        }
    }
}
