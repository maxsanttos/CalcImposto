package com.max.calcimposto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.calcimposto.model.Impostos;
import com.max.calcimposto.model.User;
import com.max.calcimposto.repository.ImpostosRepository;
import com.max.calcimposto.repository.UserRepository;

@Service
public class CalcImpostosService {

     @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImpostosRepository impostosRepository;

    @Autowired
    private ImpostosService impostosService;

    public Impostos calcularImpostos(Long userId) {
        User user = userRepository.findById(userId)
                                  .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        double salario = user.getSalario();
        double inss = impostosService.calcularImpostoINSS(salario);
        double irrf = impostosService.calcularImpostoIRRF(salario, inss);
        double salarioLiquido = salario - inss - irrf;

        Impostos novosImpostos = new Impostos();
        novosImpostos.setInss(inss);
        novosImpostos.setIrrf(irrf);
        novosImpostos.setSalarioLiquido(salarioLiquido);
        novosImpostos.setUser(user);

        // Salvar os novos impostos no banco de dados
        return impostosRepository.save(novosImpostos);
    }
}
