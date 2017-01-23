package id.arieridwan.hellogits.mvvm.article;


import id.arieridwan.ApiClient;
import id.arieridwan.BaseRequest;
import rx.Observable;

/**
 * Created by ASUS on 06/10/2016.
 */

public class MainActivityImpl extends BaseRequest implements MainActivityRequest {

    private String mSource;
    private String mSortBy;

    public MainActivityImpl(ApiClient apiClient, String source, String sortBy, String apiKey) {
        super(apiClient);
        mSource = source;
        mSortBy = sortBy;
    }

    @Override
    public Observable<HeadlineRespones> requestHeadlineRespones() {
        return null;
    }
}
