package Tst;

import entity.Publisher;
import repository.PublisherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TPublisher {
    public static void run() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = factory.createEntityManager();
        PublisherRepository publisherRepository = new PublisherRepository(entityManager);
        for (int i = 0; i < Const.PUBLISHERS; i++) {
            Publisher publisher = new Publisher();
            publisher.setName("Publisher #" + i);
            publisherRepository.add(publisher);
        }

        Publisher publisherById = publisherRepository.getByPk(87);
        System.out.println(publisherById.getName());






        entityManager.close();
        factory.close();
    }
}
