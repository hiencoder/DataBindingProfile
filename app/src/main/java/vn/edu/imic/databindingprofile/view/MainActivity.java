package vn.edu.imic.databindingprofile.view;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.imic.databindingprofile.R;
import vn.edu.imic.databindingprofile.callback.PostClickListener;
import vn.edu.imic.databindingprofile.databinding.ActivityMainBinding;
import vn.edu.imic.databindingprofile.model.Post;
import vn.edu.imic.databindingprofile.model.User;
import vn.edu.imic.databindingprofile.utils.GridSpacingItemDecoration;

public class MainActivity extends AppCompatActivity implements PostClickListener {
    private MyClickHandler myClickHandler;
    private PostAdapter postAdapter;
    private RecyclerView rvPost;
    private ActivityMainBinding binding;

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.txt_toolbar_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myClickHandler = new MyClickHandler(this);

        renderProfile();

        initRecyclerView();
    }

    /**
     * Config recyclerview
     */
    private void initRecyclerView() {
        rvPost = binding.content.recyclerView;
        rvPost.setLayoutManager(new GridLayoutManager(this, 3));
        rvPost.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        rvPost.setItemAnimator(new DefaultItemAnimator());
        rvPost.setNestedScrollingEnabled(false);
        postAdapter = new PostAdapter(this, getPost(), this);
        rvPost.setAdapter(postAdapter);
    }

    /*Tao danh sach cac Post*/
    private List<Post> getPost() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setImageUrl("https://api.androidhive.info/images/nature/" + i + ".jpg");

            /*add to list*/
            posts.add(post);
        }
        return posts;
    }

    /**
     * Convert from dp to px
     *
     * @param dp
     * @return
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        int px = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
        return px;
    }

    /**
     * Render profile user
     */
    private void renderProfile() {
        user = new User();
        user.setName("Nguyen Van Hien");
        user.setEmail("mrphonglinh2605@gmail.com");
        user.setProfileName("https://api.androidhive.info/images/nature/david.jpg");
        user.setAbout("Naturalist");

        /*ObservableField khong goi phuong thuc setter ma su dung phuong thuc set
        * */
        user.numberOfPosts.set(3400L);
        user.numberOfFollowers.set(3050890L);
        user.numberOfFollowing.set(150L);

        /*Hien thi user*/
        binding.setUser(user);

        /*Dang ky su kien click*/
        binding.content.setHandlers(myClickHandler);
    }

    @Override
    public void onClick(Post post) {
        Toast.makeText(this, post.getImageUrl() + "", Toast.LENGTH_SHORT).show();
    }

    public class MyClickHandler {
        Context context;

        public MyClickHandler(Context context) {
            this.context = context;
        }

        /**
         * Demonstrating updating bind data
         * Profile name, number of posts and profile image
         * will be updated on Fab click
         */
        public void onProfileFabClicked(View view) {
            user.setName("Sir David Attenborough");
            user.setProfileName("https://api.androidhive.info/images/nature/david1.jpg");

            // updating ObservableField
            user.numberOfPosts.set(5500L);
            user.numberOfFollowers.set(5050890L);
            user.numberOfFollowing.set(180L);
        }

        public boolean onProfileImageLongPressed(View view) {
            Toast.makeText(getApplicationContext(), "Profile image long pressed!", Toast.LENGTH_LONG).show();
            return false;
        }


        public void onFollowersClicked(View view) {
            Toast.makeText(context, "Followers is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onFollowingClicked(View view) {
            Toast.makeText(context, "Following is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onPostsClicked(View view) {
            Toast.makeText(context, "Posts is clicked!", Toast.LENGTH_SHORT).show();
        }

    }
}
