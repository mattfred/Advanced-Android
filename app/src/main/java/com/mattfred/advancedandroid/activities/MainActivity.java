package com.mattfred.advancedandroid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mattfred.advancedandroid.AndroidApplication;
import com.mattfred.advancedandroid.R;
import com.mattfred.advancedandroid.models.Post;
import com.mattfred.advancedandroid.retofitService.ApiService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Inject
    ApiService retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((AndroidApplication) getApplication()).getNetComponent().inject(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPosts();
            }
        });
    }

    private void getPosts() {
        retrofit.getPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Timber.i(response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}
