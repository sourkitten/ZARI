package socialbookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import socialbookstore.domainmodel.Book;
import socialbookstore.formsdata.RecommendationsFormData;
import socialbookstore.formsdata.SearchFormData;
import socialbookstore.mapper.BookMapper;

import java.util.Arrays;
import java.util.List;

@Service
public class RecommendationsStrategy extends TemplateSearchStrategy {

    @Autowired
    private BookMapper bookMapper;

    @Override
    protected List<Book> initializeListOfBooks(SearchFormData searchFormData) {
        if (!(searchFormData instanceof RecommendationsFormData)) {
            throw new IllegalArgumentException("Expected RecommendationsFormData instance");
        }
        RecommendationsFormData formData = (RecommendationsFormData) searchFormData;

        return bookMapper.recommendBooks(formData.getUsername(), formData.getPreferredCategories());
    }

    @Override
    protected boolean checkIfAuthorMatches(SearchFormData searchFormData, Book book) {
        if (!(searchFormData instanceof RecommendationsFormData)) {
            return true; // Default to true if not RecommendationsFormData
        }

        RecommendationsFormData formData = (RecommendationsFormData) searchFormData;
        String[] preferredAuthors = formData.getAuthorKeywords();

        return book.getBookAuthors().stream()
                   .anyMatch(author -> Arrays.asList(preferredAuthors).contains(author.getName()));
    }
}
