/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;

//Classe que representa uma receita financeira no sistema.
public class Receitas extends Lancamentos{
    
    //Utilizado para criar um novo objeto do tipo Receita com base nas informações fornecidas.
    public Receitas(String categoria, String descricao, double valor, LocalDate data) {
        super(categoria, valor, data, descricao);
    }

    //Sobrescreve o método abstrato ou herdado da classe.
    @Override
    public String getTipo() {
        return "receita";
    }
}
