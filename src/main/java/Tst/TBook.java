package Tst;

import entity.Author;
import entity.Book;
import entity.Publisher;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.PublisherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;

public class TBook {
    public static void run(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = factory.createEntityManager();
        BookRepository bookRepository = new BookRepository(entityManager);
        PublisherRepository publisherRepository = new PublisherRepository(entityManager);
        AuthorRepository authorRepository = new AuthorRepository(entityManager);
        Random random = new Random();
        for (int i = 0; i < Const.BOOKS; i++) {
            Book book = new Book();
            book.setTitle("Book #" + i);
            book.setPictureCount(random.nextInt(100));
            book.setPageCount(random.nextInt(400) + 50);
            book.setPrice(random.nextInt(1000) + 500);
            book.setYear(random.nextInt(500) + 1500);

            int publisherId = random.nextInt(Const.PUBLISHERS);
            Publisher publisher = publisherRepository.getByPk(publisherId);
            book.setPublisher(publisher);
            int authorId1 = random.nextInt(Const.AUTHORS);
            int authorId2 = random.nextInt(Const.AUTHORS);
            Author author1 = authorRepository.getByPk(authorId1);
            book.getAuthors().add(author1);
            if(authorId1 != authorId2){
                Author author2 = authorRepository.getByPk(authorId2);
                book.getAuthors().add(author2);
            }
            bookRepository.add(book);
        }
        entityManager.close();
        factory.close();
    }
}
