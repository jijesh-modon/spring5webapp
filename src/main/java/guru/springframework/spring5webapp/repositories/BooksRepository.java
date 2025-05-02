package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
}
