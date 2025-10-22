package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Disponibilidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate dataInicio;
    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate dataFim;
    @NotNull
    @Temporal(TemporalType.TIME)
    private LocalTime horaInicio;
    @NotNull
    @Temporal(TemporalType.TIME)
    private LocalTime horaFim;
    @NotNull
    @Min(20) @Max(150)
    private Integer tempoAtendimento;
    @NotNull
    private boolean estaAtivo;

    //PROFISSIONAL-EMPRESA-CLIENTE
}
