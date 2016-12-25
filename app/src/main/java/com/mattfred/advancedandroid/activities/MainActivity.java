package com.mattfred.advancedandroid.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.mattfred.advancedandroid.R;
import com.mattfred.advancedandroid.models.Post;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        button.setOnClickListener(View -> getPosts());
    }

    private void getPosts() {
        getRetrofitService().getPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.i("Main Activity", response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}
