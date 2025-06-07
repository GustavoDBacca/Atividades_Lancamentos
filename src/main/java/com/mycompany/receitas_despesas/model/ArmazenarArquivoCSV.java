/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class ArmazenarArquivoCSV {
    
    public static void ArmazenarInfos(ArrayList<Lancamentos> lancar, String caminho){
        try (FileWriter write = new FileWriter(caminho)){
            
            write.write("descricao,valor,data\n");
            
            for(Lancamentos l : lancar){
                write.write(String.format("%s,%.2f,%s\n",
                    l.getDescricao(),
                    l.getValor(),
                    l.getData()
                        ));
                
            }
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar CSV: " + e.getMessage());
        }
        
    }
}
