package phs.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        chamaRetrofit();
    }

    private void chamaRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        Endpoint endpoint = retrofit.create(Endpoint.class);
        Call<List<Objeto>> endpointResponse = endpoint.pegaObj();
        endpointResponse.enqueue(new Callback<List<Objeto>>() {
            @Override
            public void onResponse(Call<List<Objeto>> call, Response<List<Objeto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    textView.setText(response.body().get(0).getTitle());
                }
            }
            @Override
            public void onFailure(Call<List<Objeto>> call, Throwable t) {
            }
        });
    }
}
