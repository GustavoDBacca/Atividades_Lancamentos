/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class Lancamentos {
    protected String descricao;
    protected double valor;
    protected String data;
    protected ArrayList<Lancamentos> lancamentos = new ArrayList<>();
    

    public Lancamentos(String descricao, double valor, String data) {
        setDescricao(descricao);
        setValor(valor);
        setData(data);
    }
    
    @Override
    public String toString(){
        return "Lancamento = {"
                + "Descrição: '" + descricao + '\''
                + ", valor: " + valor
                + "data: '" + data + '\'' +
                "}"; 
    }
    
    
    
    public void valorSaldo(){
        Saldo saldo = new Saldo();

        for (Lancamentos l : lancamentos){
            if (l instanceof Receitas){
                saldo.Adicionar(l.getValor());
            } else {
                saldo.Subtrair(l.getValor());
            }
            System.out.println(l);
        }
    }

    public ArrayList<Lancamentos> getLancamento(){
        return lancamentos;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
