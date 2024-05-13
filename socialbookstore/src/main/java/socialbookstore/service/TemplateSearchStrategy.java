package socialbookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import socialbookstore.domainmodel.Book;
import socialbookstore.formsdata.SearchFormData;
import socialbookstore.mapper.BookMapper;

@Service
public abstract class TemplateSearchStrategy implements SearchStrategy {
    @Autowired
    protected BookMapper bookMapper;

    public List<Book> search(SearchFormData searchFormData) {
        List<Book> books = initializeListOfBooks(searchFormData);
        return filterBooks(searchFormData, books);
    }

    protected abstract List<Book> initializeListOfBooks(SearchFormData searchFormData);
    protected abstract boolean checkIfAuthorMatches(SearchFormData searchFormData, Book book);

    private List<Book> filterBooks(SearchFormData searchFormData, List<Book> books) {
        return books.stream()
                    .filter(book -> checkIfAuthorMatches(searchFormData, book))
                    .toList();
    }
}
