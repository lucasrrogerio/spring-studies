package br.uff.lucasrogerio.desafiopickpaybackend.domain.entity;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("1")
public class NaturalPerson extends User {

    @Column(name = "cpf", length = 14, unique = true)
    @NotNull(message = "CPF é obrigatório.")
    @CPF(message = "CPF inválido.")
    private String cpf;

    public NaturalPerson(Long id, String name, String email, String password, String cpf, Date createdAt,
            Date updatedAt) {
        super(id, name, email, password, UserType.COMMON, createdAt, updatedAt);
        this.setCpf(cpf);
    }

    public NaturalPerson() {
        super();
        this.setUserType(UserType.COMMON);
    }

}
