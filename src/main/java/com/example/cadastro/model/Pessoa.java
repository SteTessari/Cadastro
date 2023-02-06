package com.example.cadastro.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(name = "NOME")
    private String nome;

    @NonNull
    @Column(name = "CPF")
    private String cpf;

    @NonNull
    @Column(name = "IDADE")
    private Integer idade;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataDeNascimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getId(), pessoa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
