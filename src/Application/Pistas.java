package Application;

import Application.Aviao;
import java.util.ArrayList;
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
public class Pistas implements Runnable {

    /*Implementando a interface Runnable para
inicialização da threads que irão realizar tarefas de forma concorrente*/

    public String name;
    public ArrayList<Aviao> lista;

    public Pistas(String name) {    //Construtor da classe
        this.name = name;
        this.lista = new ArrayList<>(); //Inicializador da ArrayList (lista de objetos)
        new Thread(this, name).start(); //Inicializador da thread
    }

    synchronized void func() {  //Criando uma função sincronizada para percorrer a lista
        for (int i = 0; i < this.lista.size(); i++) {
            this.lista.get(i).exec();   //Executando a função exec() do objeto da classe Aviao
        }
    }

    @Override
    public void run() { //Execução da thread
        try {
            Thread.sleep(1000); //Para fins de organização, para a thread por 1 segundo
        } catch (InterruptedException ex) {
            Logger.getLogger(Pistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        func(); //Executando a função func()
    }

}
