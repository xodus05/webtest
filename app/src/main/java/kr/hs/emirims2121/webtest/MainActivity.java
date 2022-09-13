package kr.hs.emirims2121.webtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public RetrofitAPI api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        api = RetrofitInit.getRetrofit();

        Call<JsonObject> checkExist = api.checkExist("a1");
        checkExist.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String res = response.body().get("result").getAsString();
                Log.v("결과값:",res);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t){
                t.printStackTrace();
                Log.v("실패:","실패");
            }
        });
    }
}