package br.uff.lucasrogerio.desafiopickpaybackend.domain.entity;

import java.util.Date;

import org.hibernate.validator.constraints.br.CNPJ;

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
@DiscriminatorValue("2")
public class LegalPerson extends User {

    @Column(name = "cnpj", length = 18, unique = true)
    @NotNull(message = "CNPJ é obrigatório.")
    @CNPJ(message = "CNPJ inválido.")
    private String cnpj;

    public LegalPerson(Long id, String name, String email, String password, String cnpj, Date createdAt,
            Date updatedAt) {
        super(id, name, email, password, UserType.SHOPKEEPER, createdAt, updatedAt);
        this.setCnpj(cnpj);
    }

    public LegalPerson() {
        super();
        this.setUserType(UserType.SHOPKEEPER);
    }

}
