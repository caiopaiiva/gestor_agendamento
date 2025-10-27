package caioifto.gestor_agendamento.dtos;

public record EnderecoDTO(
        Long id,
        String cep,
        String logradouro,
        String complemento,
        Integer numero,
        String bairro,
        String cidade
) {
}
