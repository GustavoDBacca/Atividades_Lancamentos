/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.io.*;
import java.time.LocalDate;


/**
 *
 * @author T-Gamer
 */
public abstract class Lancamentos {
    protected String descricao;
    protected double valor;
    protected LocalDate data;
    protected String categoria;

    public Lancamentos(String descricao, double valor, LocalDate data, String categoria) {
        setDescricao(descricao);
        setValor(valor);
        setData(data);
        setCategoria(categoria);
    }
    
    public abstract String getTipo(); 

    @Override
    public String toString() {
        return String.format("Lançamento [%s] - %s | %.2f | %s | %s",
                getTipo(), descricao, valor, data, categoria);
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
}
