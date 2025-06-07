/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import static com.mycompany.receitas_despesas.model.TipoReceitas.SALARIO;
import java.time.LocalDate;



/**
 *
 * @author T-Gamer
 */

public class Receitas extends Lancamentos{
    
    public Receitas(String tipo, String descricao, double recebimentos, LocalDate data) {
        super(tipo, recebimentos, data, descricao);
    }

    @Override
    public String getTipo() {
        return "receita";
    }
}
