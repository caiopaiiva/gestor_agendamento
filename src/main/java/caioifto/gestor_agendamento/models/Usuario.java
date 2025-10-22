package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank(message = "E-mail obrigatório")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Senha obrigatória")
    private String senha;
    @ManyToMany
    private List<Role> roles;
}
