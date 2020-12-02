package com.codemountain.codeblog.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.codemountain.codeblog.R;
import com.codemountain.codeblog.activity.MainActivity;
import com.codemountain.codeblog.activity.ReadPostActivity;
import com.codemountain.codeblog.adapters.MainAdapter;
import com.codemountain.codeblog.dto.PostDto;
import com.codemountain.codeblog.retrofit.ApiInterface;
import com.codemountain.codeblog.retrofit.ServiceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    public static List<PostDto> posts = new ArrayList<>();
    private LottieAnimationView lottieAnimationView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);
        getPosts();
        return view;
    }

    private void initViews(View view) {

        lottieAnimationView = view.findViewById(R.id.animation);
        //recyclerview
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getPosts() {
        lottieAnimationView.setVisibility(View.VISIBLE);
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
        Call<List<PostDto>> call = service.getPosts();
        call.enqueue(new Callback<List<PostDto>>() {
            @Override
            public void onResponse(Call<List<PostDto>> call, Response<List<PostDto>> response) {
                if (response.isSuccessful()) {
                    lottieAnimationView.setVisibility(View.GONE);
                    posts.clear();
                    if (response.body() != null) {
                        for (PostDto postDto : response.body()) {
                            posts.addAll(Collections.singleton(postDto));
                            //Log.e(TAG, "onResponse: "+ posts.add(postDto));
                        }
                        mainAdapter = new MainAdapter(getContext(), posts);
                        mainAdapter.setOnItemClickListener((view, position) -> {
                            startActivity(new Intent(getContext(), ReadPostActivity.class)
                            .putExtra("POSITION", position));
                            ((MainActivity)getContext()).overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        });
                        recyclerView.setAdapter(mainAdapter);
                    }
                    else {
                        Log.e(TAG, "onResponse: "+ response.body() );
                    }
                }
                else {
                    Log.e(TAG, "onResponse:Error==> "+ response.code());
                }
            }

            @Override
            public void onFailure(Call<List<PostDto>> call, Throwable t) {
                Toast.makeText(getContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: "+ t.getMessage());
            }
        });
    }
}