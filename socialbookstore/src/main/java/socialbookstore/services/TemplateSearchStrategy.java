package socialbookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import socialbookstore.domainmodel.Book;
import socialbookstore.mappers.BookMapper;

public abstract class TemplateSearchStrategy /*implements SearchStrategy */{
    @Autowired
    protected BookMapper bookMapper;
    
    /*
    @Override
    public List<BookFormData> search(SearchFormData searchFormData, BookMapper bookMapper) {
        //
    }

    protected abstract List<BookFormData> makeInitializeListOfBooks(SearchFormData searchDto);

    protected abstract boolean checkIfAuthorMatches(SearchFormData searchFormData, Book book);*/
}

