package vn.edu.imic.databindingprofile.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import vn.edu.imic.databindingprofile.R;
import vn.edu.imic.databindingprofile.callback.PostClickListener;
import vn.edu.imic.databindingprofile.databinding.PostRowItemBinding;
import vn.edu.imic.databindingprofile.model.Post;

/**
 * Created by MyPC on 13/04/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder>{
    private Context context;
    private List<Post> posts;
    private PostClickListener postClickListener;
    public PostAdapter(Context context, List<Post> posts, PostClickListener postClickListener) {
        this.context = context;
        this.posts = posts;
        this.postClickListener = postClickListener;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostRowItemBinding postRowItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.post_row_item,
                parent,false
        );
        return new PostHolder(postRowItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        final Post post = posts.get(position);
        holder.postRowItemBinding.setPost(post);
        holder.postRowItemBinding.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postClickListener != null){
                    postClickListener.onClick(post);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        PostRowItemBinding postRowItemBinding;
        public PostHolder(PostRowItemBinding binding) {
            super(binding.getRoot());
            this.postRowItemBinding = binding;
        }
    }
}
