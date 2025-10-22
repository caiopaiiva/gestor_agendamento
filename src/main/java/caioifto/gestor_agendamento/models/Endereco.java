package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "^[0-9]{5}-?[0-9]{3}$", message = "CEP inválido. Use o formato 99999-999, apenas números e hífen são permitidos.")
    private String cep; //validação de formato
    @NotBlank(message = "Informe um logradouro.")
    private String logradouro;
    private String complemento;
    @NotNull(message = "O número é obrigatório.")
    @Min(value = 1, message = "O número deve ser maior que zero.")
    private Integer numero;
    @NotBlank(message = "Informe um Bairro.")
    private String bairro;
    @NotNull
    @ManyToOne
    private Cidade cidade;
}
