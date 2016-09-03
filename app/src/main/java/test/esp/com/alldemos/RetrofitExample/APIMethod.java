package test.esp.com.alldemos.RetrofitExample;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by hardikjani on 6/13/16.
 */
public interface APIMethod {
    @GET("/get/curators.json")
    MyBean getBean(
            @Query("api_key") String key
    );
}
