/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;

import static com.mycompany.receitas_despesas.model.TipoReceitas.SALARIO;



/**
 *
 * @author T-Gamer
 */

public class Receitas extends Lancamentos{
    
    public Receitas(String descricao, double recebimentos, String data) {
        super(descricao, recebimentos, data);
    }

    public TipoReceitas tipoReceitas(TipoReceitas tipoReceitas){
        switch (tipoReceitas) {
            case SALARIO:
                
                break;
                
            case DECIMO_TERCEIRO:
                
                break;
                
            case FERIAS:
                
                break;
            case OUTRA_RECEITA:
                
                break;
            default:
                throw new AssertionError();
        }
        return null;
    }
}
