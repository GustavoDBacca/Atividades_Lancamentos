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
/*
* Está classe é unicamente para testar o armazenamento do arquivo.
*/

public class ArmazenarArquivoCSV {
    
    public static void ArmazenarInfos(ArrayList<Lancamentos> lancar, String caminho){
        try (FileWriter write = new FileWriter(caminho)){
            
            write.write("tipo,descricao,valor,data,categoria\n");
            
            for(Lancamentos l : lancar){
                write.append(String.format("[%s],%s,%.2f,%s,%s\n",
                    l.getTipo(),
                    l.getDescricao(),
                    l.getValor(),
                    l.getData(),
                    l.getCategoria()
                        ));
                
            }
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar CSV: " + e.getMessage());
        }
        
    }
}
