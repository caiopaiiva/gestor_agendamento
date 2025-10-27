package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn
public class Prestador extends Pessoa implements Serializable {
    @NotBlank
    private String razaoSocial;
    @CNPJ
    private String cnpj;
    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<Servico> servicos;
    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<Disponibilidade> disponibilidades;
    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agenda> agendas;
    @OneToMany(mappedBy = "prestador", fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos;
}
