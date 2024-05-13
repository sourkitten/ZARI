package socialbookstore.service;

import socialbookstore.domainmodel.Book;
import socialbookstore.formsdata.SearchFormData;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExactSearchStrategy extends TemplateSearchStrategy {
    @Override
    protected List<Book> initializeListOfBooks(SearchFormData searchFormData) {
        return bookMapper.findBooksExactly(searchFormData.getTitle(), searchFormData.getAuthorKeywords());
    }

    @Override
    protected boolean checkIfAuthorMatches(SearchFormData searchFormData, Book book) {
        // Convert the array to a list and then check if the list contains the author name
        List<String> authorKeywordsList = Arrays.asList(searchFormData.getAuthorKeywords());
        return book.getBookAuthors().stream()
                   .anyMatch(author -> authorKeywordsList.contains(author.getName()));
    }
}
