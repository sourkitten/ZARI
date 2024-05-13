package socialbookstore.service;

import socialbookstore.domainmodel.Book;
import socialbookstore.formsdata.SearchFormData;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ApproximateSearchStrategy extends TemplateSearchStrategy {
	@Override
    protected List<Book> initializeListOfBooks(SearchFormData searchFormData) {
        // Convert String[] to List<String> for authorKeywords
		String[]authorKeywordsList = searchFormData.getAuthorKeywords();
        return bookMapper.findBooksApproximately(searchFormData.getTitle(), authorKeywordsList);
    }

    @Override
    protected boolean checkIfAuthorMatches(SearchFormData searchFormData, Book book) {
        return book.getBookAuthors().stream()
                   .anyMatch(author -> author.getName().contains(searchFormData.getAuthorKeyword()));
    }
}
