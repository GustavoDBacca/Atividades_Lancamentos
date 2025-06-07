/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class GestorLancamentos {
    private ArrayList<Lancamentos> lista = new ArrayList<>();

    public void adicionar(Lancamentos l) {
        lista.add(l);
    }

    public ArrayList<Lancamentos> getTodos() {
        return lista;
    }

    public void salvarCSV(String caminho) {
        
    }

    public void carregarCSV(String caminho) {
        // carrega do arquivo
    }

    public double calcularSaldo() {
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
}
