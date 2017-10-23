package groupone.green_red.boihaat.app;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("boihaat/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
