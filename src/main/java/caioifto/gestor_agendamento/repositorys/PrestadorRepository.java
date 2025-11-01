package caioifto.gestor_agendamento.repositorys;

import caioifto.gestor_agendamento.models.Prestador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrestadorRepository {
    @PersistenceContext
    EntityManager em;

    public List<Prestador> getAll() {
        return em.createQuery("from Prestador", Prestador.class).getResultList();
    }

    public Prestador getById(Long id) {
        return em.find(Prestador.class, id);
    }
}
