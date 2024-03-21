package com.example.lavarapidoapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.lavarapidoapi.validation.TipoAgendamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Agendamento {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{agendamento.descricao.notblank}")
    @Size(min = 3, message = "{agendamento.descricao.size}")
    private String descricao;

    @Positive
    private BigDecimal valor;
    private LocalDate data;

    @TipoAgendamento(message = "{agendamento.tipo.tipoagendamento}")
    private String tipo;
}
