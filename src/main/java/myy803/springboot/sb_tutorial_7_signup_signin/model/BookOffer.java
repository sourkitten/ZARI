package myy803.springboot.sb_tutorial_7_signup_signin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_offers")
public class BookOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "authors", nullable = false)
    private String authors;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "summary", nullable = false)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "taken_by_user_id")
    private User takenByUser;
    
    // New field to track the user who gave the book
    @ManyToOne
    @JoinColumn(name = "given_by_user_id")
    private User givenByUser;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public User getTakenByUser() {
        return takenByUser;
    }

    public void setTakenByUser(User takenByUser) {
        this.takenByUser = takenByUser;
    }

    public User getGivenByUser() {
        return givenByUser;
    }

    public void setGivenByUser(User givenByUser) {
        this.givenByUser = givenByUser;
    }

}
