package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Books;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BooksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BooksRepository booksRepository;

    public BootStrapData(AuthorRepository authorRepository, BooksRepository booksRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Books ddd = new Books("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        booksRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Books noEJB = new Books("J2EE Development without EJB", "489");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        booksRepository.save(noEJB);

        System.out.println("Loading all the Authors and Books");
        System.out.println("The total number of books available is : " + booksRepository.count());
        System.out.println("Eric ID : " + eric.getId());
        System.out.println("Rod ID : " + rod.getId());

    }

}
