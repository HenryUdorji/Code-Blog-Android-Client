package com.codemountain.codeblog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codemountain.codeblog.R;
import com.codemountain.codeblog.dto.PostDto;
import com.codemountain.codeblog.interfaces.OnItemClickListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<PostDto> posts;

    private OnItemClickListener listener;

    public MainAdapter(Context context, List<PostDto> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_layout, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, int position) {
        PostDto posts = this.posts.get(position);
        holder.nameText.setText(posts.getUsername());
        holder.titleText.setText(posts.getTitle());
        holder.contentText.setText(posts.getContent());
        holder.numberOfLikes.setText(posts.getLikesCount() + " Like(s)");
        holder.numberOfComments.setText(posts.getCommentCount() + " Comment(s)");
        holder.timeText.setText(posts.getCreatedDate());
        /*Glide.with(context).load(posts.getUsername())
                .placeholder(R.drawable.account_image_placeholder).into(holder.circleImageView);*/
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button numberOfLikes, numberOfComments;
        private CircleImageView circleImageView;
        private TextView nameText, titleText, contentText, timeText;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            numberOfComments = itemView.findViewById(R.id.numberOfComments);
            numberOfLikes = itemView.findViewById(R.id.numberOfLikes);
            circleImageView = itemView.findViewById(R.id.userProfileImage);
            nameText = itemView.findViewById(R.id.nameText);
            titleText = itemView.findViewById(R.id.titleText);
            contentText = itemView.findViewById(R.id.contentText);
            timeText = itemView.findViewById(R.id.timeText);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.itemClick(v, position);
                }
            });
        }

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}

