package socialbookstore.formsdata;

public class RecommendationsFormData extends SearchFormData {
    private String[] preferredCategories;
    private String[] authorKeywords;

    public String[] getPreferredCategories() {
        return preferredCategories;
    }

    public void setPreferredCategories(String[] preferredCategories) {
        this.preferredCategories = preferredCategories;
    }

    public String[] getAuthorKeywords() {
        return authorKeywords;
    }

    public void setAuthorKeywords(String[] authorKeywords) {
        this.authorKeywords = authorKeywords;
    }
}
