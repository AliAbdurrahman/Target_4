package id.papapaok.aliabdurrahman.indonesianews4.Network;

import id.papapaok.aliabdurrahman.indonesianews4.Model.ResponseGetIndonesia;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public interface ApiService {

    @GET("top-headlines")
    Call<ResponseGetIndonesia> getFocusData (
            @Query("country") String country,
            @Query("apikey") String key
    );

}
