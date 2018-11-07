package id.papapaok.aliabdurrahman.indonesianews4.View;

import java.util.List;

import id.papapaok.aliabdurrahman.indonesianews4.Base.BaseView;
import id.papapaok.aliabdurrahman.indonesianews4.Model.ArticlesItem;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public interface MainView extends BaseView{

    void onError(String msg);
    void onSucces(List<ArticlesItem> data);
}
