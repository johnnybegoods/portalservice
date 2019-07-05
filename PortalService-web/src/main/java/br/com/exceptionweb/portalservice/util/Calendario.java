/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exceptionweb.portalservice.util;

import java.util.Calendar;

/**
 *
 * @author johnny
 */
public class Calendario {

    public static Calendar getDate(String txt) {
        Calendar c = Calendar.getInstance();

        int dia = Integer.parseInt(txt.substring(8));
        int mes = Integer.parseInt(txt.substring(5, 7));
        int ano = Integer.parseInt(txt.substring(0, 4));
        mes = mes - 1;
        c.set(c.YEAR, ano);
        c.set(c.MONTH, mes);
        c.set(c.DAY_OF_MONTH, dia);

        return c;
    }

}
