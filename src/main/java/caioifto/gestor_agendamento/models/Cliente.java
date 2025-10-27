package caioifto.gestor_agendamento.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn
public class Cliente extends Pessoa implements Serializable {
    @OneToMany(mappedBy = "cliente")
    private List<Agenda> agendamentos;
    @OneToMany(mappedBy = "cliente")
    private List<Atendimento> atendimentos;
}
