package myy803.springboot.sb_tutorial_7_signup_signin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_requests")
public class BookRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_offer_id", nullable = false)
    private BookOffer bookOffer;

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

    public BookOffer getBookOffer() {
        return bookOffer;
    }

    public void setBookOffer(BookOffer bookOffer) {
        this.bookOffer = bookOffer;
    }
}
