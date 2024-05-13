package socialbookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import socialbookstore.domainmodel.Book;
import socialbookstore.domainmodel.UserProfile;
import socialbookstore.formsdata.BookFormData;
import socialbookstore.formsdata.RecommendationsFormData;
import socialbookstore.formsdata.SearchFormData;
import socialbookstore.formsdata.UserProfileFormData;
import socialbookstore.mapper.BookMapper;
import socialbookstore.mapper.UserProfileMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public UserProfileFormData retrieveProfile(String username) {
        UserProfile profile = userProfileMapper.findByUsername(username);
        return convertToUserProfileFormData(profile);
    }

    @Override
    public void save(UserProfileFormData userProfileFormData) {
        UserProfile userProfile = convertToUserProfile(userProfileFormData);
        if (userProfileMapper.findByUsername(userProfile.getUsername()) != null) {
            userProfileMapper.updateUserProfile(userProfile);
        } else {
            userProfileMapper.insertUserProfile(userProfile);
        }
    }

    @Override
    public List<BookFormData> retrieveBookOffers(String username) {
        List<Book> books = bookMapper.findBooksByUser(username);
        return books.stream().map(this::convertToBookFormData).collect(Collectors.toList());
    }

    @Override
    public void addBookOffer(String username, BookFormData bookFormData) {
        Book book = convertToBook(bookFormData);
        bookMapper.insertBook(book);
    }

    @Override
    public List<BookFormData> searchBooks(SearchFormData searchFormData) {
        List<Book> books = bookMapper.searchBooks(searchFormData.getKeyword(), searchFormData.isExactMatch());
        return books.stream().map(this::convertToBookFormData).collect(Collectors.toList());
    }

    @Override
    public List<BookFormData> recommendBooks(String username, RecommendationsFormData recomFormData) {
        List<Book> books = bookMapper.recommendBooks(username, recomFormData.getPreferredCategories());
        return books.stream().map(this::convertToBookFormData).collect(Collectors.toList());
    }

    @Override
    public void requestBook(int bookId, String username) {
        userProfileMapper.addBookRequest(username, bookId);
    }

    @Override
    public List<BookFormData> retrieveBookRequests(String username) {
        List<Book> books = userProfileMapper.findBookRequestsByUsername(username);
        return books.stream().map(this::convertToBookFormData).collect(Collectors.toList());
    }

    @Override
    public List<UserProfileFormData> retrieveRequestingUsers(int bookId) {
        List<UserProfile> profiles = userProfileMapper.findUsersByBookId(bookId);
        return profiles.stream().map(this::convertToUserProfileFormData).collect(Collectors.toList());
    }

    @Override
    public void deleteBookOffer(String username, int bookId) {
        bookMapper.deleteBookOffer(username, bookId);
    }

    @Override
    public void deleteBookRequest(String username, int bookId) {
        userProfileMapper.deleteBookRequest(username, bookId);
    }
    
    @Override
    public void acceptRequest(String username, int bookId) {
        // Assuming there's a method to update the request status to 'accepted'
        userProfileMapper.updateRequestStatus(username, bookId, "Accepted");
    }

    // Helper methods for converting domain models to FormData and vice versa
    private UserProfileFormData convertToUserProfileFormData(UserProfile userProfile) {
        UserProfileFormData formData = new UserProfileFormData();
        formData.setUsername(userProfile.getUsername());
        formData.setFullName(userProfile.getFullName());
        formData.setAge(userProfile.getAge());
        // Add other fields as necessary
        return formData;
    }

    private UserProfile convertToUserProfile(UserProfileFormData formData) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(formData.getUsername());
        userProfile.setFullName(formData.getFullName());
        userProfile.setAge(formData.getAge());
        // Set other fields as needed
        return userProfile;
    }

    private BookFormData convertToBookFormData(Book book) {
        BookFormData formData = new BookFormData();
        formData.setBookId(book.getBookId());
        formData.setTitle(book.getTitle());
        // Convert and set other fields as needed
        return formData;
    }

    private Book convertToBook(BookFormData formData) {
        Book book = new Book();
        book.setBookId(formData.getBookId());
        book.setTitle(formData.getTitle());
        // Set other properties as necessary
        return book;
    }
    
    
}
