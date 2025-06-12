/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.receitas_despesas.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author T-Gamer
 */
public class Receitas_Despesas {

    public static void main(String[] args) {
        
        ArrayList<Lancamentos> lista = new ArrayList<>();

        // O tipo fica implícito pela classe chamada. Ex: se a classe for Receitas então o tipo também é;
        Receitas r = new Receitas("Salário", "Salário", 3000.00, LocalDate.parse("2025-06-10"));
        Despesas d = new Despesas("Alimentos", "Mercado", 450.00, LocalDate.parse("2025-06-03"));
        
            lista.add(r);
            lista.add(d);
            
            //lista.add(new Receitas("Salário", "Decimo Terceiro", 1050.00, LocalDate.parse("2025-01-13")));

            
            String caminho = "C:\\Users\\T-Gamer\\Documents\\LancamentosTests.CSV";

            
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
                System.out.println(" " + valoresEntreVirgulas[0] + " " + valoresEntreVirgulas[1] + "," + valoresEntreVirgulas[2] + " " + valoresEntreVirgulas[3] + " " );
            }

            scan.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
    
    
}
