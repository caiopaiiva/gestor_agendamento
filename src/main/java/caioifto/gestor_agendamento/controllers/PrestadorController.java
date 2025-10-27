package caioifto.gestor_agendamento.controllers;

import caioifto.gestor_agendamento.dtos.PrestadorDTO;
import caioifto.gestor_agendamento.services.PrestadorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/prestador")
public class PrestadorController {
    @Autowired
    private PrestadorService prestadorService;

    @GetMapping("/listar")
    public List<PrestadorDTO> listar() {
        return prestadorService.getAllPrestadores();
    }
}
