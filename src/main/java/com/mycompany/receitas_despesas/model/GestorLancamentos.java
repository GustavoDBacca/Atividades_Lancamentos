/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
        
        ArrayList<Lancamentos> filtrados = new ArrayList<>();        
        LocalDate ateHoje = LocalDate.now();

        for (Lancamentos l : lista){
            if (l.getData().isBefore(ateHoje))
                filtrados.add(l);
        }

        return filtrados;
    }
    public static double getSaldoDataPassadas(){
        
        double totalDatasPassadas = 0;
            for (Lancamentos l : getDatasPassadas()) {
                if (l instanceof Receitas) {
                    totalDatasPassadas += l.getValor();
                } else {
                    totalDatasPassadas -= l.getValor();
                }
            }
        return totalDatasPassadas;
    }

    public static void salvarCSV(Lancamentos lancamento,File caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho, true))) {
            writer.printf("%s;%s;%.2f;%s;%s\n",
            lancamento.getTipo().replace(",", " "),
            lancamento.getDescricao().replace(",", " "),
            lancamento.getValor(),
            lancamento.getData(), 
            lancamento.getCategoria().replace(",", " ")
            );
            System.out.println("Arquivo CSV salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar CSV: " + e.getMessage());
        }
    }

    public static void carregarCSV(String caminho) {
        lista.clear();
        File arquivo = new File(caminho);
        try (Scanner scan = new Scanner(arquivo)) {
        if (scan.hasNextLine()) scan.nextLine(); 

            while (scan.hasNextLine()) {
                String[] partes = scan.nextLine().split(",");
                String tipo = partes[0];
                String descricao = partes[1];
                double valor = Double.parseDouble(partes[2]);
                LocalDate data = LocalDate.parse(partes[3]);
                String categoria = partes[4];

                if (tipo.equalsIgnoreCase("Receita")) {
                    adicionar(new Receitas(categoria, descricao, valor, data));
                } else {
                    adicionar(new Despesas(categoria, descricao, valor, data));
                }
        }

        System.out.println("Arquivo CSV carregado (sem validações).");
    } catch (IOException e) {
        System.err.println("Erro ao carregar CSV: " + e.getMessage());
    }
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