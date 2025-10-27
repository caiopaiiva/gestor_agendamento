package caioifto.gestor_agendamento.models;

import caioifto.gestor_agendamento.models.enums.StatusAgendamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Agenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataHoraAgendamento;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;
    @NotNull
    @ManyToOne
    private Cliente cliente;
    @NotNull
    @ManyToOne
    private Prestador prestador;
}
