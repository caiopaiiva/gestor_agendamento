package caioifto.gestor_agendamento.repositorys;

import caioifto.gestor_agendamento.models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Cliente> getAll() {
        return em.createQuery("from Cliente", Cliente.class).getResultList();
    }
}
