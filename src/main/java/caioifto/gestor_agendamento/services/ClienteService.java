package caioifto.gestor_agendamento.services;

import caioifto.gestor_agendamento.dtos.ClienteResponseDTO;
import caioifto.gestor_agendamento.dtos.EnderecoDTO;
import caioifto.gestor_agendamento.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteResponseDTO> getAllCliente() {
        return clienteRepository.getAll().stream().map(
                cliente -> new ClienteResponseDTO(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getSobrenome(),
                        cliente.getCpf(),
                        cliente.getTelefone(),
                        cliente.getUsuario().getEmail(),
                        new EnderecoDTO(
                                cliente.getEndereco().getId(),
                                cliente.getEndereco().getCep(),
                                cliente.getEndereco().getLogradouro(),
                                cliente.getEndereco().getComplemento(),
                                cliente.getEndereco().getNumero(),
                                cliente.getEndereco().getBairro(),
                                cliente.getEndereco().getCidade().getNome() + "/" + cliente.getEndereco().getCidade().getEstado().getSigla()
                        )
                )).toList();
    }
}
