package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataHoraAtendimento;
    private String observacao;
    @OneToOne(cascade = CascadeType.ALL)
    private Agenda agendamento;
    @ManyToMany
    private List<Servico> servicos;
    @NotNull
    @ManyToOne
    private Cliente cliente;
    @NotNull
    @ManyToOne
    private Prestador prestador;
}
