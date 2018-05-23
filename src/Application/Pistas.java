package Application;


import Application.Aviao;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ítalo
 */
public class Pistas {
    public String name;
    public ArrayList<Aviao> lista;
    public Pistas(String name){
        this.name = name;
        this.lista = new ArrayList<>();
    }
}
