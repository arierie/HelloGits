package id.arieridwan.hellogits.mvvm.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import id.arieridwan.MySubscriber;
import id.arieridwan.dao.ArticleApiDao;
import id.arieridwan.hellogits.dagger.Injector;
import id.arieridwan.hellogits.databinding.MainActivityBinding;
import id.arieridwan.hellogits.util.Constant;
import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS on 06/10/2016.
 */

public class MainActivityVM extends GitsVM {

    @Inject
    MainActivityRequest mRequest;

    public MainAdapter bAdapter;
    public LayoutManager bLayoutManager;
    public List<ArticleApiDao> mList = new ArrayList<>();
    public MainActivityBinding mBinding;

    public MainActivityVM(Context context, MainActivityBinding binding) {
        super(context);
        Injector.component.inject(this);
        this.mBinding = binding;
        bAdapter = new MainAdapter(mList);
        bLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        callApi();
    }

    public void callApi() {
        addSubscription(mRequest.requestArticle("bbc-sport","top", Constant.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new MySubscriber<MainActivityRequest.viewListResponse>() {
                    @Override
                    public void onError(String errorMessage) {
                        Toast.makeText(mContext, errorMessage, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNextAndCompleted(MainActivityRequest.viewListResponse viewListResponse) {
                        mList.addAll(viewListResponse.getList());
                        bAdapter.notifyDataSetChanged();
                    }
                }));
    }
}
