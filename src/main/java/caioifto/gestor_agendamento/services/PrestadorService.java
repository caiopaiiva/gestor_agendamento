package caioifto.gestor_agendamento.services;

import caioifto.gestor_agendamento.dtos.EnderecoDTO;
import caioifto.gestor_agendamento.dtos.PrestadorDTO;
import caioifto.gestor_agendamento.repositorys.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestadorService {
    @Autowired
    private PrestadorRepository prestadorRepository;

    public List<PrestadorDTO> getAllPrestadores() {
        return prestadorRepository.getAll().stream().map(
                prestador -> new PrestadorDTO(
                        prestador.getId(),
                        prestador.getNome(),
                        prestador.getSobrenome(),
                        prestador.getCpf(),
                        prestador.getTelefone(),
                        prestador.getUsuario().getEmail(),
                        prestador.getCnpj(),
                        prestador.getRazaoSocial(),
                        new EnderecoDTO(
                                prestador.getEndereco().getId(),
                                prestador.getEndereco().getCep(),
                                prestador.getEndereco().getLogradouro(),
                                prestador.getEndereco().getComplemento(),
                                prestador.getEndereco().getNumero(),
                                prestador.getEndereco().getBairro(),
                                prestador.getEndereco().getCidade().getNome() + "/" + prestador.getEndereco().getCidade().getEstado().getSigla()
                        )
                )).toList();
    }
}
