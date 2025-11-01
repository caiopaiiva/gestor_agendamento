package caioifto.gestor_agendamento.repositorys;

import caioifto.gestor_agendamento.models.Servico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ServicoRepository {
    @PersistenceContext
    private EntityManager em;

    public void insert(Servico servico) {
        em.persist(servico);
    }
}
