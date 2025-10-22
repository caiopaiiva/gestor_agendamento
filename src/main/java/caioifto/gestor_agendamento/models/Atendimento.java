package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Atendimento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHoraAtendimento;
    private String observacao;
    @OneToOne(cascade = CascadeType.ALL)
    private Agenda agendamento;
    @ManyToMany
    private List<Servico> servicos;

    //CLIENTE
    //PROFISSIONAL-EMPRESA-PJ
}
