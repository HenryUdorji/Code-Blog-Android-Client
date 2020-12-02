package com.codemountain.codeblog.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codemountain.codeblog.R;
import com.codemountain.codeblog.dto.PostDto;
import com.codemountain.codeblog.fragment.HomeFragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReadPostActivity extends AppCompatActivity {

    private static final String TAG = "ReadPostActivity";
    private Toolbar toolbar;
    private TextView titleText, contentText, nameText, timeText;
    private CircleImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post);

        Intent intent = getIntent();
        int position = intent.getIntExtra("POSITION", 0);

        initViews();
        getPost(position);
    }


    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        titleText = findViewById(R.id.titleText);
        contentText = findViewById(R.id.contentText);
        //timeText = findViewById(R.id.timeText);
        //nameText = findViewById(R.id.nameText);
        //imageView = findViewById(R.id.userImage);
    }

    private void getPost(int position) {
        PostDto postDto = HomeFragment.posts.get(position);
        titleText.setText(postDto.getTitle());
        contentText.setText(postDto.getContent());
        //timeText.setText(postDto.getCreatedDate());
        //nameText.setText(postDto.getUsername());

    }
}