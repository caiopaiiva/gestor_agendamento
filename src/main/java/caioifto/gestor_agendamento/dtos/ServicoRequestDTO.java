package caioifto.gestor_agendamento.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicoRequestDTO(
        @NotBlank String descricao,
        @NotNull Double preco,
        @NotNull Integer tempoMedioEmMinutos
) {
}
