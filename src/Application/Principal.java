/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author Ítalo
 */
public class Principal {
    
    public static void main(String[] args) {
        Pistas pistaUm = new Pistas("PistaUm");
        Pistas pistaDois = new Pistas("PistaDois");
        Aviao AviaoUM = new Aviao("AviaoUM", pistaUm, pistaDois);
        Aviao AviaoDOIS = new Aviao("AviaoDOIS", pistaUm, pistaDois);
        Aviao AviaoTRES = new Aviao("AviaoTRES", pistaUm, pistaDois);
        Aviao AviaoQUATRO = new Aviao("AviaoQUATRO", pistaUm, pistaDois);
    }
}
