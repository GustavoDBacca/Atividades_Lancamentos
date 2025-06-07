/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.receitas_despesas.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author T-Gamer
 */
public class Receitas_Despesas {

    public static void main(String[] args) {
        
        ArrayList<Lancamentos> lista = new ArrayList<>();

        
            lista.add(new Receitas("Salário", 3000.00, "2025-06-01"));
            lista.add(new Despesas("Mercado", 450.00, "2025-06-03"));
            
            lista.add(new Receitas("Decimo Terceiro", 1050.00, "2025-01-13"));

            // Caminho do arquivo
            String caminho = "C:\\Users\\T-Gamer\\Documents\\LancamentosTests.CSV";

            // Salva no CSV
            ArmazenarArquivoCSV.ArmazenarInfos(lista, caminho);
        
        File arquivoCSV = new File("C:\\Users\\T-Gamer\\Documents\\LancamentosTests.CSV");
        try {
            
            String linhasDoArquivo = new String();
            
            Scanner scan = new Scanner(arquivoCSV);
            scan.nextLine();
            
             while (scan.hasNextLine()) {
                String linha = scan.nextLine();
                String[] valoresEntreVirgulas = linha.split(",");

                // Exibe o conteúdo da linha
                System.out.println(" " + valoresEntreVirgulas[0] + " " + valoresEntreVirgulas[1] + "," + valoresEntreVirgulas[2] + " " + valoresEntreVirgulas[3]);
            }

            scan.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
    
    
}
