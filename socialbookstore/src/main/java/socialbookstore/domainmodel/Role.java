package socialbookstore.domainmodel;


public enum Role {
    ADMIN("Admin"),
    USER("User"),
    GUEST("Guest");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}