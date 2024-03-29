package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher puba = new Publisher("Publisher A", "NY");
        Book ddd = new Book("Domain Driven Design", "1234", puba);
        eric.getBooks().add(ddd);
        publisherRepository.save(puba);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher pubb = new Publisher("Publisher B", "India");
        Book noEJB = new Book("J2EE Developement without EJB", "1234", pubb);
        rod.getBooks().add(noEJB);

        publisherRepository.save(pubb);
        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }
}
