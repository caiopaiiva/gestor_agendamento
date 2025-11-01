package caioifto.gestor_agendamento.controllers;

import caioifto.gestor_agendamento.dtos.ClienteResponseDTO;
import caioifto.gestor_agendamento.services.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<ClienteResponseDTO> listar() {
        return clienteService.getAllCliente();
    }
}
