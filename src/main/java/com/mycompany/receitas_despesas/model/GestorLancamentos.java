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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    public static ArrayList<Lancamentos> getDatasPassadas() {

        ArrayList<Lancamentos> filtrados = new ArrayList<>();
        LocalDate ateHoje = LocalDate.now();

        for (Lancamentos l : lista) {
            if (l.getData().isBefore(ateHoje)) {
                filtrados.add(l);
            }
        }

        return filtrados;
    }

    public static double getSaldoDataPassadas() {

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

    public static void salvarCSV(Lancamentos lancamento, File caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho, true))) {
            writer.printf("%s;%s;%.2f;%s;%s\n",
                    lancamento.getTipo() != null ? lancamento.getTipo().replace(";", " ") : "",
                    lancamento.getDescricao() != null ? lancamento.getDescricao().replace(";", " ") : "",
                    lancamento.getValor(),
                    lancamento.getData(),
                    lancamento.getCategoria() != null ? lancamento.getCategoria().replace(";", " ") : ""
            );
            System.out.println("Arquivo CSV salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar CSV: " + e.getMessage());
        }
    }

    public static void carregarCSV(File arquivo) {
        lista.clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (Scanner scan = new Scanner(arquivo)) {

            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String linha = scan.nextLine();
                String[] partes = linha.split(";");
                if (partes.length < 5) {
                    System.err.println("Linha inválida (menos de 5 colunas): " + linha);
                    continue; // pula linha inválida
                }

                String tipo = partes[0];
                String descricao = partes[1];
                double valor;
                LocalDate data;
                String categoria = partes[4];

                try {
                    valor = Double.parseDouble(partes[2].replace(",", "."));
                } catch (NumberFormatException e) {
                    System.err.println("Valor inválido na linha: " + linha);
                    continue;
                }

                try {
                    data = LocalDate.parse(partes[3], formatter);
                } catch (DateTimeParseException e) {
                    System.err.println("Data inválida na linha: " + linha);
                    continue;
                }

                if (tipo.equalsIgnoreCase("Receita")) {
                    adicionar(new Receitas(categoria, descricao, valor, data));
                } else if (tipo.equalsIgnoreCase("Despesa")) {
                    adicionar(new Despesas(categoria, descricao, valor, data));
                } else {
                    System.err.println("Tipo inválido na linha: " + linha);
                }
            }

            System.out.println("Arquivo CSV carregado com sucesso!");
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

    public static String listarLancamentos() {
        StringBuilder sb = new StringBuilder();
        for (Lancamentos l : lista) {
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }

    public static double getSaldo() {
        double saldo = calcularSaldo();
        return saldo;
    }
}
