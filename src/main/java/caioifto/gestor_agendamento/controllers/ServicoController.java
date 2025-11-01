package caioifto.gestor_agendamento.controllers;

import caioifto.gestor_agendamento.dtos.ServicoRequestDTO;
import caioifto.gestor_agendamento.services.ServicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/servico")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @PostMapping("/inserir/{idPrestador}")
    public void inserirServico(@PathVariable Long idPrestador, @RequestBody ServicoRequestDTO servicoRequestDTO) {
        servicoService.inserir(idPrestador, servicoRequestDTO);
    }
}
