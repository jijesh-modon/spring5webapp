package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Books;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Here we go..! BootStrap is getting started");

        Publisher publisher = new Publisher();
        publisher.setName("Jijesh M");
        publisher.setAddressLine("Modon House");
        publisher.setCity("kannur");
        publisher.setState("Kerala");
        publisher.setZip(612670);

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Books ddd = new Books("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooksSet().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Books noEJB = new Books("J2EE Development without EJB", "489");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooksSet().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Loading all the Authors and Books");
        System.out.println("The total number of books available is : " + bookRepository.count());
        System.out.println("Eric ID : " + eric.getId());
        System.out.println("Rod ID : " + rod.getId());
        System.out.println("The total number of publishers : " + publisherRepository.count());

    }

}
