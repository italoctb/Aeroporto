package Application;

import static java.lang.Thread.currentThread;
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
public final class Aviao {   //Criação da classe Aviao

    Random aleatorio = new Random();    //Instanciando a classe aleatorio.
    public final String name;

    public Aviao(String name, Pistas p1, Pistas p2) {   //Construtor da classe
        this.name = name;
        int ppista = aleatorio.nextInt(2);  //Variável aleatória (0 ou 1) para escolha da pista
        if (ppista == 0) {  //Algoritmo de associação das pistas
            p1.lista.add(this);
            System.out.println("O " + this.name + " irá para a " + p1.name);
        } else {
            p2.lista.add(this);
            System.out.println("O " + this.name + " irá para a " + p2.name);
        }
    }
//Implementação das tarefas realizadas pelos aviões

    public void manobra() {
        int r = aleatorio.nextInt(5) + 3;
        try {
            Thread.sleep(r * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O " + this.name + " está manobrando. Duração :" + r + " segundos");
    }

    public void taxiar() {
        int r = aleatorio.nextInt(4) + 2;
        try {
            Thread.sleep(r * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O " + this.name + " está taxiando. Duração :" + r + " segundos");
    }

    public void posicionar() {
        int r = aleatorio.nextInt(4) + 1;
        try {
            Thread.sleep(r * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O " + this.name + " posicionou-se na cabeceira da pista. Duração :" + r + " segundos");
    }

    public void acelerar() {
        int r = aleatorio.nextInt(3) + 3;
        try {
            Thread.sleep(r * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O " + this.name + " acelerou e irá decolar. Duração :" + r + " segundos");
    }

    public void decolar() {
        int r = aleatorio.nextInt(4) + 4;
        try {
            Thread.sleep(r * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O " + this.name + " decolou. Duração :" + r + " segundos");
    }

    public void afastar() {
        int r = aleatorio.nextInt(5) + 2;
        try {
            Thread.sleep(r * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aviao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O " + this.name + " afastou-se. Duração :" + r + " segundos");
    }

    //Chamada das tarefas
    public void exec() {
        this.manobra();
        this.taxiar();
        this.posicionar();
        this.acelerar();
        this.decolar();
        this.afastar();
    }
}
