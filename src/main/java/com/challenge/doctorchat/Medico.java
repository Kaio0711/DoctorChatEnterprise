package com.challenge.doctorchat;

import com.challenge.valueObjects.CNPJ;
import com.challenge.valueObjects.CPF;
import com.challenge.valueObjects.Endereco;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Médico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Embedded
    private CPF CPF;
    @Embedded
    private CNPJ CNPJ;
    private String CMR;
    private String especialidade = "Clinico Geral";
    @Embedded
    private Endereco endereco;
    private boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "Agendamento_Id")
    private Agendamento Agendamento;

    @ManyToMany
    @JoinTable(name = "Médico_Hospital",
                joinColumns = @JoinColumn(name = "Médico_Id"),
                inverseJoinColumns = @JoinColumn(name = "Hospital_Id"))
    private List<Hospital> hospitais;
}
