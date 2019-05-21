package repository;

import entity.Publisher;
import org.eclipse.persistence.jpa.jpql.parser.TrimExpression;

import javax.persistence.EntityManager;
import java.util.List;

public class PublisherRepository implements Repository<Publisher, Integer> {
    private EntityManager entityManager;

    public PublisherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
    }

    public void update(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.merge(publisher);
        entityManager.getTransaction().commit();
    }

    public void delete(Integer integer) {
        entityManager.getTransaction().begin();
        Publisher publisher = getByPk(integer);
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
    }

    public Publisher getByPk(Integer integer) {
        return entityManager.find(Publisher.class, integer);
    }

    public List<Publisher> getAll() {
        return null;
    }

    public List<Publisher> getBySpecification(TrimExpression.Specification spec) {
        return null;
    }
}
