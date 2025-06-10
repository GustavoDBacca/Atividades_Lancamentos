/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class GestorLancamentos {
    private static final ArrayList<Lancamentos> lista = new ArrayList<>();

    public static void adicionar(Lancamentos l) {
        lista.add(l);
    }

    //Retorna todos os lançamentos
    public static ArrayList<Lancamentos> getTodos() {
        return lista;
    }
    
    public static ArrayList<Lancamentos> getDatasPassadas(){
        //Array criado para guardar os lancamentos filtrados pela data.
        ArrayList<Lancamentos> filtrados = new ArrayList<>();        
        LocalDate ateHoje = LocalDate.now();
        
        //Verifica se a data é anterior ao dia de hoje
        for (Lancamentos l : lista){
            if (l.getData().isBefore(ateHoje))
                filtrados.add(l);
        }

        return filtrados;
    }

    public void salvarCSV(String caminho) {
        
    }

    public void carregarCSV(String caminho) {
       
    }

    public static double calcularSaldo() {
        double saldo = 0;
        for (Lancamentos l : lista) {
            if (l instanceof Receitas) {
                saldo += l.getValor();
            } else {
                saldo -= l.getValor();
            }
        }
        return saldo;
    }
    
    public static double getSaldo(){
        double saldo = calcularSaldo();
        return saldo;
    }
}
