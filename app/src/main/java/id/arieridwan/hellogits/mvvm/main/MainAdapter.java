package id.arieridwan.hellogits.mvvm.main;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

import id.arieridwan.dao.ArticleApiDao;
import id.arieridwan.hellogits.R;
import id.arieridwan.hellogits.databinding.MainActivityRowBinding;
import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by arieridwan on 23/01/2017.
 */

public class MainAdapter extends GitsAdapter<ArticleApiDao,MainActivityRowVM,MainActivityRowBinding> {

    public MainAdapter(List<ArticleApiDao> collection) {
        super(collection);
    }

    @Override
    public MainActivityRowVM createViewModel(AppCompatActivity activity, MainActivityRowBinding binding, ArticleApiDao item, int position) {
        return new MainActivityRowVM(activity,binding,item,position);
    }

    @Override
    public int getResLayout() {
        return R.layout.main_activity_row;
    }

    @Override
    public void render(MainActivityRowBinding binding, MainActivityRowVM viewModel, ArticleApiDao item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(ArticleApiDao data, int position) {

    }
}
