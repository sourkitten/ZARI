package socialbookstore.service;

import socialbookstore.formsdata.BookFormData;
import socialbookstore.formsdata.RecommendationsFormData;
import socialbookstore.formsdata.SearchFormData;
import socialbookstore.formsdata.UserProfileFormData;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserProfileService {
    UserProfileFormData retrieveProfile(String username);
    void save(UserProfileFormData userProfileFormData);
    List<BookFormData> retrieveBookOffers(String username);
    void addBookOffer(String username, BookFormData bookFormData);
    List<BookFormData> searchBooks(SearchFormData searchFormData);
    List<BookFormData> recommendBooks(String username, RecommendationsFormData recomFormData);
    void requestBook(int bookid, String username);
    List<BookFormData> retrieveBookRequests(String username);
    List<UserProfileFormData> retrieveRequestingUsers(int bookid);
    void deleteBookOffer(String username, int bookid);
    void deleteBookRequest(String username, int bookid);
    void acceptRequest(String username, int bookId);
}
