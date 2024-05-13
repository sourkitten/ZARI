package socialbookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import socialbookstore.domainmodel.Book;
import socialbookstore.formsdata.SearchFormData;

@Service
	public interface SearchStrategy {
	    List<Book> search(SearchFormData searchFormData);
	}

