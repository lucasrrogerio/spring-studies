package br.uff.lucasrogerio.desafiopickpaybackend.service.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.entity.User;
import br.uff.lucasrogerio.desafiopickpaybackend.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private UserType userType;
    private Date createdAt;

    UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.userType = user.getUserType();
        this.createdAt = user.getCreatedAt();
    }

    public static UserResponseDTO dtoFromUser(User user) {
        return new UserResponseDTO(user);
    }

    public static List<UserResponseDTO> dtoListFromUsers(List<User> users) {
        return users.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

}
