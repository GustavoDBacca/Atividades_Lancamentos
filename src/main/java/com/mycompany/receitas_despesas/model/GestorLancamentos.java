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
    
    public static double getSaldoDataPassadas(){
        
        //fitro para pegar o valor do saldo com as datas de lançamentos passados
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

    public void salvarCSV(String caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
            writer.println("Tipo,Descricao,Valor,Data,Categoria");
            for (Lancamentos l : lista) {
                // Evitar vírgula na descrição/categoria
                String descricao = l.getDescricao().replace(",", "");
                String categoria = l.getCategoria().replace(",", "");
                writer.printf("%s,%s,%.2f,%s,%s%n",
                    l.getTipo(), descricao, l.getValor(), l.getData(), categoria);
            }
            System.out.println("Arquivo CSV salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar CSV: " + e.getMessage());
        }
    }

    public void carregarCSV(String caminho) {
        lista.clear();
        File arquivo = new File(caminho);
        try (Scanner scan = new Scanner(arquivo)) {
            if (scan.hasNextLine()) scan.nextLine(); // pular cabeçalho
            while (scan.hasNextLine()) {
                String linha = scan.nextLine();
                String[] partes = linha.split(",");
                if (partes.length == 5) {
                    String tipo = partes[0];
                    String descricao = partes[1];
                    double valor = Double.parseDouble(partes[2]);
                    LocalDate data = LocalDate.parse(partes[3]);
                    String categoria = partes[4];
                    if (tipo.equalsIgnoreCase("Receita")) {
                        adicionar(new Receitas(categoria, descricao, valor, data));
                    } else if (tipo.equalsIgnoreCase("Despesa")) {
                        adicionar(new Despesas(categoria, descricao, valor, data));
                    } else {
                        System.out.println("Tipo desconhecido: " + tipo);
                    }
                } else {
                    System.out.println("Linha malformada: " + linha);
                }
            }
            System.out.println("Arquivo CSV carregado com sucesso!");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
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
