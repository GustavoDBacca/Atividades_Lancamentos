/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;


//Classe para calcular o saldo.
public class Saldo {
    protected double valor;

    //Soma valor ao saldo
    public void adicionar(double valor) {
        this.valor += valor;
    }
    
    //Subtrai valor do saldo
    public void subtrair(double valor) {
        this.valor -= valor;
    }
        
    //Retorna o valor do saldo
    public double getValor() {
        return valor;
    }

    //Define o valor do saldo
    public void setValor(double valor) {
        this.valor = valor;
    } 
}
