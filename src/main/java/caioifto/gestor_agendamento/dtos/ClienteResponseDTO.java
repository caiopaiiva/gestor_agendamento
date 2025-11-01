package caioifto.gestor_agendamento.dtos;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String sobrenome,
        String cpf,
        String telefone,
        String email,
        EnderecoDTO endereco
) {
}
