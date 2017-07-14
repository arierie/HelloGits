package id.arieridwan.hellogits.mvvm.main;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import id.arieridwan.hellogits.R;
import id.arieridwan.hellogits.base.BaseActivity;
import id.arieridwan.hellogits.databinding.MainActivityBinding;

public class MainActivity extends BaseActivity<MainActivityVM,MainActivityBinding> {

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    public int getResLayout() {
        return R.layout.main_activity;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this,mBinding);
    }

    @Override
    public void bindViewModel(MainActivityBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.loadData){
            mViewModel.callApi();
        }
        return super.onOptionsItemSelected(item);
    }
}
