package id.arieridwan.dao;

/**
 * Created by ASUS on 06/10/2016.
 */

public class BaseApiDao <T>{
    private String status;
    private String source;
    private String sortBy;
    T articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public T getArticles() {
        return articles;
    }

    public void setArticles(T articles) {
        this.articles = articles;
    }
}
