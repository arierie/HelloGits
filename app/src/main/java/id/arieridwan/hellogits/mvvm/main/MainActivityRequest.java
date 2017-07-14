package id.arieridwan.hellogits.mvvm.main;

import java.util.ArrayList;
import java.util.List;

import id.arieridwan.dao.ArticleApiDao;
import rx.Observable;

/**
 * Created by ASUS on 06/10/2016.
 */

public interface MainActivityRequest {

    Observable<viewListResponse> requestArticle(String source, String sortBy,String apiKey);

    class viewListResponse {
        List<ArticleApiDao> mList = new ArrayList<>();

        public viewListResponse(List<ArticleApiDao> mList) {
            this.mList = mList;
        }

        public List<ArticleApiDao> getList() {
            return mList;
        }
    }

}
