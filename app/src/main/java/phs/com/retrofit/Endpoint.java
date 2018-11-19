package phs.com.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
    @GET("posts/3")
    Call<List<Objeto>> pegaObj();
}
