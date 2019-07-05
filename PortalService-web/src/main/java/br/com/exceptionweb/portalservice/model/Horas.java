/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.model;

import java.text.DecimalFormat;

/**
 *
 * @author johnny
 */
public class Horas {
    private int minuto = 0;
    private String horas50;
    private String horas100;
    private String banco;
    private String folgas;
    private String saldo;
    
    public Horas(String horas) {
        if(horas != null){
            String[] hrs = horas.split(":");
                this.minuto = (Integer.parseInt(hrs[0]) * 60)
                                + (Integer.parseInt(hrs[1]));
        }
        else{
            String[] hrs = "00:00".split(":");
                this.minuto = (Integer.parseInt(hrs[0]) * 60)
                                + (Integer.parseInt(hrs[1]));
        }
    }

    public void Zera() {
        this.minuto = 0;
    }

    public String getHoras() {
        String horas;
        DecimalFormat fmt = new DecimalFormat("00");
        horas = Integer.toString(this.minuto / 60);
        
        horas += ":";
        horas += fmt.format(this.minuto % 60);
        if(horas.length() == 4){
            horas = "0"+horas;
        }
        
        if(horas.indexOf("-") > 0){
            String texto = "";
            int regex = horas.indexOf("-");
            texto = horas.substring(0, regex);
            texto = texto+horas.substring(regex+1);
            if(texto.length() == 4){
                texto = "0"+texto;
            }
            return "-"+texto;
        }
        else{
            return horas;
        }
    }
    
}
