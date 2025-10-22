package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter @Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Sobrenome é obrigatório.")
    private String sobrenome;
    /*@CPF
    @NotBlank
    private String cpf;*/
    @NotBlank
    @Pattern(regexp = "^\\d{2} \\d \\d{4}-\\d{4}$", message = "Telefone deve estar no formato: 99 9 9999-9999.")
    private String telefone;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

}
