package com.mycompany.receitas_despesas.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar os lançamentos financeiros do sistema,
 * incluindo receitas e despesas.
 * <p>
 * Possui funcionalidades para adicionar, filtrar, salvar e carregar lançamentos,
 * além de calcular saldos e gerar listagens.
 * </p>
 * 
 * @author Miguel
 */
public class GestorLancamentos {

    /**
     * Lista estática que armazena todos os lançamentos (receitas e despesas).
     */
    private static final ArrayList<Lancamentos> lista = new ArrayList<>();

    /**
     * Adiciona um lançamento à lista.
     *
     * @param l Objeto do tipo {@link Lancamentos} a ser adicionado.
     */
    public static void adicionar(Lancamentos l) {
        lista.add(l);
    }

    /**
     * Retorna todos os lançamentos cadastrados.
     *
     * @return Lista de todos os lançamentos.
     */
    public static ArrayList<Lancamentos> getTodos() {
        return lista;
    }

    /**
     * Filtra e retorna apenas os lançamentos do tipo "receita".
     *
     * @return Lista com os lançamentos do tipo "receita".
     */
    public static ArrayList<Lancamentos> filtrarReceitas() {
        ArrayList<Lancamentos> filtro = new ArrayList<>();
        for (Lancamentos l : lista) {
            if (l.getTipo().equals("receita")) {
                filtro.add(l);
            }
        }
        return filtro;
    }

    /**
     * Filtra e retorna apenas os lançamentos do tipo "despesa".
     *
     * @return Lista com os lançamentos do tipo "despesa".
     */
    public static ArrayList<Lancamentos> filtrarDespesas() {
        ArrayList<Lancamentos> filtro = new ArrayList<>();
        for (Lancamentos l : lista) {
            if (l.getTipo().equals("despesa")) {
                filtro.add(l);
            }
        }
        return filtro;
    }

    /**
     * Retorna os lançamentos cuja data é anterior à data atual.
     *
     * @return Lista com os lançamentos passados.
     */
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

    /**
     * Calcula o saldo considerando apenas os lançamentos com data anterior à atual.
     *
     * @return Saldo de lançamentos passados.
     */
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

    /**
     * Salva um lançamento no formato CSV no arquivo especificado.
     *
     * @param lancamento Lançamento a ser salvo.
     * @param caminho Caminho do arquivo CSV.
     */
    public static void salvarCSV(Lancamentos lancamento, File caminho) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho, true))) {
            writer.printf("%s;%s;%.2f;%s;%s\n",
                    lancamento.getTipo() != null ? lancamento.getTipo().replace(";", " ") : "",
                    lancamento.getDescricao() != null ? lancamento.getDescricao().replace(";", " ") : "",
                    lancamento.getValor(),
                    lancamento.getData().format(formatter),
                    lancamento.getCategoria() != null ? lancamento.getCategoria().replace(";", " ") : ""
            );
            System.out.println("Arquivo CSV salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar CSV: " + e.getMessage());
        }
    }

    /**
     * Carrega lançamentos a partir de um arquivo CSV e os adiciona à lista.
     * O arquivo deve conter os campos: tipo, descrição, valor, data e categoria.
     *
     * @param arquivo Arquivo CSV de origem.
     */
    public static void carregarCSV(File arquivo) {
        lista.clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (Scanner scan = new Scanner(arquivo)) {
            if (scan.hasNextLine()) scan.nextLine(); // Pula o cabeçalho

            while (scan.hasNextLine()) {
                String linha = scan.nextLine();
                String[] partes = linha.split(";");
                if (partes.length < 5) {
                    System.err.println("Linha inválida (menos de 5 colunas): " + linha);
                    continue;
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

    /**
     * Calcula o saldo total com base em todas as receitas e despesas.
     *
     * @return Valor total do saldo.
     */
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

    /**
     * Retorna uma string contendo todos os lançamentos cadastrados.
     *
     * @return String com os lançamentos.
     */
    public static String listarLancamentos() {
        StringBuilder sb = new StringBuilder();
        for (Lancamentos l : lista) {
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Retorna o saldo atual, equivalente ao valor retornado por {@link #calcularSaldo()}.
     *
     * @return Saldo atual.
     */
    public static double getSaldo() {
        return calcularSaldo();
    }
}
