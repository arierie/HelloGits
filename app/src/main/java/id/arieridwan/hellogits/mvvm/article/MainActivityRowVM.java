package id.arieridwan.hellogits.mvvm.article;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import id.arieridwan.hellogits.R;
import id.arieridwan.hellogits.databinding.MainActivityRowBinding;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by ASUS on 06/10/2016.
 */

public class MainActivityRowVM extends GitsRowVM<MainActivityRequest.Articles,MainActivityRowBinding> {

    ObservableField<String> bImageHeadline = new ObservableField<>();
    ObservableField<String> bTextJudul = new ObservableField<>();

    public MainActivityRowVM(Context context, MainActivityRowBinding binding, MainActivityRequest.Articles data) {
        super(context, binding, data);
        bTextJudul.set(data.getJudul());
        bImageHeadline.set(data.getImg());
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(view.getContext())
                    .load(imageUrl)
                    .placeholder(R.color.placeholder)
                    .error(R.color.error_placeholder)
                    .fit()
                    .centerCrop()
                    .into(view);
        }
    }
}
