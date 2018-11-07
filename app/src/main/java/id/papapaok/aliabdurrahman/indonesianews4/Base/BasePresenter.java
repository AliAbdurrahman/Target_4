package id.papapaok.aliabdurrahman.indonesianews4.Base;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public interface BasePresenter <T extends BaseView> {

    void onAttach(T v);
    void onDettach();

}
