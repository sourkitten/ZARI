package socialbookstore.formsdata;

public class SearchFormData {
    private String keyword; // Search keyword for books
    private boolean exactMatch; // Whether to use exact matching
    private String[] authorKeywords; // Additional keywords for author names if needed

    // Constructor
    public SearchFormData() {}

    // Getter for keyword
    public String getKeyword() {
        return keyword;
    }

    // Setter for keyword
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    // Getter for exactMatch
    public boolean isExactMatch() {
        return exactMatch;
    }

    // Setter for exactMatch
    public void setExactMatch(boolean exactMatch) {
        this.exactMatch = exactMatch;
    }

    // Getter for authorKeywords
    public String[] getAuthorKeywords() {
        return authorKeywords;
    }

    // Setter for authorKeywords
    public void setAuthorKeywords(String[] authorKeywords) {
        this.authorKeywords = authorKeywords;
    }
    
    public String getTitle() {
    	return this.getTitle();
    }
    
    public String getAuthorKeyword() {
    	return this.getAuthorKeyword();
    }
    
    public String getUsername() {
    	return this.getUsername();
    }
}
