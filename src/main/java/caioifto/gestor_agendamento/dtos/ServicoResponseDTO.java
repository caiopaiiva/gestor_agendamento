package caioifto.gestor_agendamento.dtos;

public record ServicoResponseDTO(
        Long id,
        String descricao,
        Double preco,
        Integer tempoAtendimento
) {
}
