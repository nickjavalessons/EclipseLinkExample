package repository;

import entity.Author;
import entity.Publisher;
import org.eclipse.persistence.jpa.jpql.parser.TrimExpression;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorRepository implements Repository<Author, Integer> {
    private EntityManager entityManager;

    public AuthorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public void update(Author author) {
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
    }

    public void delete(Integer integer) {
        entityManager.getTransaction().begin();
        Author author = getByPk(integer);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
    }

    public Author getByPk(Integer integer) {
        return entityManager.find(Author.class, integer);
    }

    public List<Author> getAll() {
        return null;
    }

    public List<Author> getBySpecification(TrimExpression.Specification spec) {
        return null;
    }
}
