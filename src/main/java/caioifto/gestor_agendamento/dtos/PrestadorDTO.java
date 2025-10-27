package caioifto.gestor_agendamento.dtos;

public record PrestadorDTO(
        Long id,
        String nome,
        String sobrenome,
        String cpf,
        String telefone,
        String email,
        String cnpj,
        String razaoSocial,
        EnderecoDTO enderecoDTO) {
}
