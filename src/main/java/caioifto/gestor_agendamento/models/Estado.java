package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Pattern(regexp = "^[A-Z]{2}$", message = "A sigla deve conter exatamente duas letras maiúsculas (ex: SP, RJ, TO).")
    private String sigla;
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Cidade> cidades;
}
