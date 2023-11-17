package br.uff.lucasrogerio.desafiopickpaybackend.service.dto;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class UserDTO {
    private String name;
    private String email;
    private String password;

    UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
