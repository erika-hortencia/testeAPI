package ehpc.javaapi.model.repository;

import org.springframework.stereotype.Repository;

import ehpc.javaapi.model.Goal;
import ehpc.javaapi.model.Task;
import ehpc.javaapi.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class EventCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Long getNextEventId(User user, String eventType) {
        Class<?> eventClass;
        if ("GOAL".equals(eventType)) {
            eventClass = Goal.class;
        } else if ("TASK".equals(eventType)) {
            eventClass = Task.class;
        } else {
            throw new IllegalArgumentException("Tipo de evento desconhecido: " + eventType);
        }

        String sql = "SELECT COALESCE(MAX(e.id), 0) + 1 FROM Event e WHERE e.user = :user AND TYPE(e) = :eventType";
        
        return entityManager.createQuery(sql, Long.class)
                            .setParameter("user", user)
                            .setParameter("eventType", eventClass)
                            .getSingleResult();
    }
}
