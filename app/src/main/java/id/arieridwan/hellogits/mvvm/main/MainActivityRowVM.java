package id.arieridwan.hellogits.mvvm.main;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import com.squareup.picasso.Picasso;
import id.arieridwan.dao.ArticleApiDao;
import id.arieridwan.hellogits.databinding.MainActivityRowBinding;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by ASUS on 06/10/2016.
 */

public class MainActivityRowVM extends GitsRowVM<ArticleApiDao,MainActivityRowBinding> {

    public ObservableField<String> bTextNumber = new ObservableField<>();
    public ObservableField<String> bTextJudul = new ObservableField<>();
    public ObservableField<String> bTextDesk = new ObservableField<>();
    public ObservableField<String> bImage = new ObservableField<>();

    public MainActivityRowVM(Context context, MainActivityRowBinding binding, ArticleApiDao data, int pos) {
        super(context, binding, data);
        int number = pos+1;
        bTextNumber.set(String.valueOf(number));
        bTextJudul.set(data.getTitle());
        bTextDesk.set(data.getDescription());
        bImage.set(data.getUrlToImage());
    }

    @BindingAdapter("imgUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

}
