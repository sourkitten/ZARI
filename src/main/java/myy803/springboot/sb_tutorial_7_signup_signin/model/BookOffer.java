package myy803.springboot.sb_tutorial_7_signup_signin.model;

import jakarta.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOffer bookOffer = (BookOffer) o;
        return Objects.equals(id, bookOffer.id) &&
                Objects.equals(title, bookOffer.title) &&
                Objects.equals(authors, bookOffer.authors) &&
                Objects.equals(category, bookOffer.category) &&
                Objects.equals(summary, bookOffer.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, category, summary);
    }

    @Override
    public String toString() {
        return "BookOffer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", category='" + category + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
