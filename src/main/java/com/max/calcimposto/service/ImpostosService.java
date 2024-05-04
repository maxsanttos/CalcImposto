package com.max.calcimposto.service;

import org.springframework.stereotype.Service;



@Service
public class ImpostosService {

    private static final double[] LIMITES_FAIXAS_IRRF = {1903.98, 2826.65, 3751.05, 4664.68, 5627.20};
    private static final double[] ALIQUOTAS_IRRF = {7.5, 15.0, 22.5, 27.5, 30.0};
    private static final double[] DEDUCOES_IRRF = {142.80, 354.00, 636.15, 869.30, 1006.60};

    private static final double[] LIMITES_FAIXAS_INSS = {1659.59, 2761.60, 3304.82, 4153.60, 60844.00};
    private static final double[] ALIQUOTAS_INSS = {7.50, 8.00, 9.00, 11.00, 12.00};

    public double calcularImpostoINSS(double salarioBruto) {
        double impostoINSS = 0.0;
        int faixa = determinarFaixa(salarioBruto, LIMITES_FAIXAS_INSS);
        
        if (faixa >= 0) {
            double aliquotaINSS = ALIQUOTAS_INSS[faixa];
            impostoINSS = salarioBruto * aliquotaINSS / 100;
        }
        
        return impostoINSS;
    }

    public double calcularImpostoIRRF(double salarioBruto, double inss) {
        double rendaTributavel = salarioBruto - inss;
        double impostoIRRF = 0.0;
        
        int faixa = determinarFaixa(rendaTributavel, LIMITES_FAIXAS_IRRF);
        
        if (faixa >= 0) {
            double aliquotaIRRF = ALIQUOTAS_IRRF[faixa];
            double deducaoIRRF = DEDUCOES_IRRF[faixa];
            impostoIRRF = (rendaTributavel * aliquotaIRRF / 100) - deducaoIRRF;
            impostoIRRF = Math.max(0, impostoIRRF); // Imposto não pode ser negativo
        }
        
        return impostoIRRF;
    }

    private int determinarFaixa(double valor, double[] limites) {
        for (int i = 0; i < limites.length; i++) {
            if (valor <= limites[i]) {
                return i;
            }
        }
        return limites.length - 1; // Retorna a última faixa se exceder todas as faixas
    }
}
