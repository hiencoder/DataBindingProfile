package vn.edu.imic.databindingprofile.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by MyPC on 13/04/2018.
 */

public class Post {
    /*Class nay hien thi cac bai Post cung cap data cho RecyclerView*/
    String imageUrl;

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
