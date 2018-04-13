package vn.edu.imic.databindingprofile.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by MyPC on 13/04/2018.
 */

public class User extends BaseObservable{
    /*Class User ke thua BaseObservable (de class thanh mot Observable).
    * Observable va ObservableField duoc su dung trong cung mot class.
    * Doi voi cac bien nhu name, email, profileImage, about. @Bindable annotation
    * duoc su dung va notifyPropertyChanged() duoc goi de thiet lap du lieu moi.
    * Cac bien numberOfPost, numberOfFollowers, numberOfFollowing duoc khai bao
    * bang ObservableFields.
    * @BindingAdapter duoc su dung de bind profileImage vao ImageView va load
    * image bang Glide.*/
    String name;
    String email;
    String profileName;
    String about;

    /*Cac truong profile meta se duoc cap nhat ui khi co gia tri moi*/
    public ObservableField<Long> numberOfFollowers = new ObservableField<>();
    public ObservableField<Long> numberOfPosts = new ObservableField<>();
    public ObservableField<Long> numberOfFollowing = new ObservableField<>();

    public User(){}

    @Bindable
    public String getName(){
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getProfileName() {
        return profileName;
    }

    @Bindable
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Bindable
    public String getAbout() {
        return about;
    }

    @Bindable
    public void setAbout(String about) {
        this.about = about;
    }

    public ObservableField<Long> getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public ObservableField<Long> getNumberOfPosts() {
        return numberOfPosts;
    }

    public ObservableField<Long> getNumberOfFollowing() {
        return numberOfFollowing;
    }

    @BindingAdapter({"profileImage"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);

    }
}
