package Tst;

import entity.Author;
import entity.Publisher;
import repository.AuthorRepository;
import repository.PublisherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TAuthor {
    public static void run(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = factory.createEntityManager();
        AuthorRepository authorRepository = new AuthorRepository(entityManager);
        for (int i = 0; i < Const.AUTHORS; i++) {
            Author author = new Author();
            author.setName("Author #" + i);
            authorRepository.add(author);
        }

        entityManager.close();
        factory.close();

    }
}
