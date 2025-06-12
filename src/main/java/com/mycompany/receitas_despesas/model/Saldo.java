/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;



/**
 *
 * @author T-Gamer
 */
public class Saldo {
    protected double valor;

    public void adicionar(double valor) {
        this.valor += valor;
    }
    
    public boolean subtrair(double valor) {
        if (valor > this.valor){
            System.out.println("Saldo Insuficiente");
            return false;
            
        }
        this.valor -= valor;
        return true;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
