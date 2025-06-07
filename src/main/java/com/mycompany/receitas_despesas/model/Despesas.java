/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receitas_despesas.model;



/**
 *
 * @author T-Gamer
 */
public class Despesas extends Lancamentos{
    
    public Despesas(String descricao, double recebimentos, String data) {
        super(descricao, recebimentos, data);
    }

    public TipoDespesas tipoDespesas(TipoDespesas tipoDespesas){
        
        switch (tipoDespesas) {
            case ALIMENTOS:
                
                break;
            case EDUCACAO:
                
                break;
            case ENTRETERIMENTO:
                
                break;
            case RESIDENCIA:
                
                break;
            case SAUDE:
                
                break;
            case TRANSPORTE:
                
                break;
            case OUTRA_DESPESA:
                break;
            default:
                throw new AssertionError();
        }
        return null;
    }
}
