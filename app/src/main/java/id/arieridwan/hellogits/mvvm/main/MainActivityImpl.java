package id.arieridwan.hellogits.mvvm.main;

import id.arieridwan.ApiClient;
import id.arieridwan.BaseRequest;
import id.arieridwan.dao.ArticleApiDao;
import id.arieridwan.dao.ArticleListDao;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ASUS on 06/10/2016.
 */

public class MainActivityImpl extends BaseRequest implements MainActivityRequest {

    public MainActivityImpl(ApiClient apiClient) {
        super(apiClient);
    }

    @Override
    public Observable<viewListResponse> requestArticle(String source, String sortBy, String apiKey) {
        return mApiClient.getInterface().getArticle(source,sortBy,apiKey)
                .flatMapIterable(new Func1<ArticleListDao, Iterable<ArticleApiDao>>() {
                    @Override
                    public Iterable<ArticleApiDao> call(ArticleListDao articleListDao) {
                        return articleListDao.getArticles();
                    }
                })
                .toList()
                .map(viewListResponse::new);
    }
}
