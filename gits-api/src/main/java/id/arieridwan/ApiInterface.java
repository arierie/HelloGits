package id.arieridwan;


import id.arieridwan.dao.ArticleListDao;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ASUS on 06/10/2016.
 */

public interface ApiInterface {
    @GET("articles")
    Observable<ArticleListDao> getArticle(
            @Query("source") String source,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );
}
