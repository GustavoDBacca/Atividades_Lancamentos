/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//Classe abstrata que representa um lançamento genérico (receita ou despesa).
public abstract class Lancamentos {
    protected String descricao;
    protected double valor;
    protected LocalDate data;
    protected String categoria;

    //Construtor onde define a categoria, descrição, valor e data.
    public Lancamentos(String categoria, double valor, LocalDate data, String descricao) {
        setCategoria(categoria);
        setDescricao(descricao);
        setValor(valor);
        setData(data);   
    }
    
    //Método abstrato implementado pelas subclasses. Retornar o tipo do lançamento (ex: "Receita" ou "Despesa").
    public abstract String getTipo(); 

    //Retorna uma representação em string do lançamento de forma formatada.
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[Lançamento [%s] - %s | %.2f | %s | %s]",
                getTipo(), categoria, valor, data.format(formatter), descricao);
    }

    //Retorna a descrição
    public String getDescricao() {
        return descricao;
    }

    //Define a descrição
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Retorna o valor
    public double getValor() {
        return valor;
    }

    //Define o valor
    public void setValor(double valor) {
        this.valor = valor;
    }

    //Retorna a data
    public LocalDate getData() {
        return data;
    }

    //Define a data
    public void setData(LocalDate data) {
        this.data = data;
    }

    //Retorna a categoria
    public String getCategoria() {
        return categoria;
    }

    //Define a categoria
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }   
}
