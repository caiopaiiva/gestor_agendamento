package caioifto.gestor_agendamento.dtos;

import java.util.List;

public record PrestadorResponseDTO(
        Long id,
        String nome,
        String sobrenome,
        String cpf,
        String telefone,
        String email,
        String cnpj,
        String razaoSocial,
        EnderecoDTO endereco,
        List<ServicoResponseDTO> servicos
) {
}
