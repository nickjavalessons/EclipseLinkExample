package repository;

import org.eclipse.persistence.jpa.jpql.parser.TrimExpression;

import java.util.List;

public interface Repository<T, PK> {
    void add(T t); // добавление в бд
    void update(T t); // обновление записи в бд
    void delete(PK pk); // удаление записи из бд
    T getByPk(PK pk); // получение записи по идентификатору
    List<T> getAll(); // получение весх записей
    List<T> getBySpecification(TrimExpression.Specification spec);
}
