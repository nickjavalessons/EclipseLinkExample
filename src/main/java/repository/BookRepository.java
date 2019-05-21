package repository;

import entity.Author;
import entity.Book;
import org.eclipse.persistence.jpa.jpql.parser.TrimExpression;

import javax.persistence.EntityManager;
import java.util.List;

public class BookRepository implements Repository<Book, Integer> {

    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void add(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public void update(Book book) {
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }

    public void delete(Integer integer) {
        entityManager.getTransaction().begin();
        Book book = getByPk(integer);
        entityManager.remove(book);
        entityManager.getTransaction().commit();
    }

    public Book getByPk(Integer integer) {
        return entityManager.find(Book.class, integer);
    }

    public List<Book> getAll() {
        return null;
    }

    public List<Book> getBySpecification(TrimExpression.Specification spec) {
        return null;
    }
}
