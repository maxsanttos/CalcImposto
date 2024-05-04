package com.max.calcimposto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "impostos")
public class Impostos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inss")
    private Double inss;

    @Column(name = "irrf")
    private Double irrf;

    @Column(name = "salario_liquido")
    private Double salarioLiquido;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;


}
