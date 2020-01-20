package com.eloisapaz.caixaeletronico.service;

import com.eloisapaz.caixaeletronico.exception.SaqueException;

public class SaqueService {

    public String getSaque(int valor) {

        int[] notas = {10,20,50,100};
        int[] numeroNotas = {0,0,0,0};
        StringBuilder stringBuilder = new StringBuilder();

        if(valor == 0) {
            throw new SaqueException("Valor do saque não pode ser 0!");
        }

        if(valor < 0) {
            throw new SaqueException("Valor de saque não pode ser negativo!");
        }

        if(valor % 10 != 0){
            throw new SaqueException("Valor inválido!");
        } else{
            for (int i = notas.length - 1; i >= 0; i--) {
                while (valor >= notas[i]) {
                    valor -= notas[i];
                    numeroNotas[i]++;
                }
                if(numeroNotas[i] > 0){
                    stringBuilder.append(numeroNotas[i]);
                    stringBuilder.append(" de R$: ");
                    stringBuilder.append(notas[i]);
                    stringBuilder.append("; ");
                }
            }
        }
        return stringBuilder.toString();
    }
}