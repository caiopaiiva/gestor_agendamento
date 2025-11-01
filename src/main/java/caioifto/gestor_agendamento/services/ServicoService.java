package caioifto.gestor_agendamento.services;

import caioifto.gestor_agendamento.dtos.ServicoRequestDTO;
import caioifto.gestor_agendamento.models.Prestador;
import caioifto.gestor_agendamento.models.Servico;
import caioifto.gestor_agendamento.repositorys.PrestadorRepository;
import caioifto.gestor_agendamento.repositorys.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private PrestadorRepository prestadorRepository;

    public void inserir(Long idPrestador, ServicoRequestDTO dto) {
        Prestador prestador = prestadorRepository.getById(idPrestador);
        if (prestador != null) {
            Servico servico = new Servico();
            servico.setPrestador(prestador);
            servico.setDescricao(dto.descricao());
            servico.setPreco(dto.preco());
            servico.setTempoMedioEmMinutos(dto.tempoMedioEmMinutos());
            servicoRepository.insert(servico);
        }
    }
}
