package id.papapaok.aliabdurrahman.indonesianews4.Presenter;

import java.util.List;

import id.papapaok.aliabdurrahman.indonesianews4.Base.BasePresenter;
import id.papapaok.aliabdurrahman.indonesianews4.Model.ArticlesItem;
import id.papapaok.aliabdurrahman.indonesianews4.Model.ResponseGetIndonesia;
import id.papapaok.aliabdurrahman.indonesianews4.Network.ConfigRetrofit;
import id.papapaok.aliabdurrahman.indonesianews4.View.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;
    private String key = "4625d046da30459a80a62d89415b77be";
    private String country = "id";

    public void getData() {
        call().enqueue(new Callback<ResponseGetIndonesia>() {
            @Override
            public void onResponse(Call<ResponseGetIndonesia> call, Response<ResponseGetIndonesia> response) {
                if (response.isSuccessful()) {
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSucces(articlesItems);
                } else {
                    mainView.onError(response.body().getStatus());
                }
            }

            @Override
            public void onFailure(Call<ResponseGetIndonesia> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    private Call<ResponseGetIndonesia> call() {
        return ConfigRetrofit.getInstance().getFocusData(country, key);

    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDettach() {
        mainView = null;
    }
}
