package id.arieridwan;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import id.arieridwan.dao.BaseApiDao;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    ApiInterface mApiInterface;

    public ApiClient(String baseUrl) {

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(baseUrl)
                .build();
        mApiInterface = retrofit.create(ApiInterface.class);
    }

    private class MyInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request original = chain.request();
            Request.Builder reqBuilder = original.newBuilder();
            Request request = reqBuilder.build();
            Response response = chain.proceed(request);

            String rawJson = response.body().string();
            if (!response.isSuccessful()) {
                BaseApiDao errorApiDao = new Gson().fromJson(rawJson, BaseApiDao.class);
                String errorMessage;
                if (errorApiDao != null) {
                    errorMessage = errorApiDao.getStatus();
                } else {
                    errorMessage = response.message();
                }
                return response.newBuilder().body(ResponseBody.create(response.body().contentType(), rawJson)).message(errorMessage).build();
            } else {
                return response.newBuilder().body(ResponseBody.create(response.body().contentType(), rawJson)).build();
            }
        }
    }

    public ApiInterface getInterface() {
        return mApiInterface;
    }
}
