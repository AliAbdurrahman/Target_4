package id.papapaok.aliabdurrahman.indonesianews4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.papapaok.aliabdurrahman.indonesianews4.Adapter.MainAdapter;
import id.papapaok.aliabdurrahman.indonesianews4.Model.ArticlesItem;
import id.papapaok.aliabdurrahman.indonesianews4.Presenter.MainPresenter;
import id.papapaok.aliabdurrahman.indonesianews4.View.MainView;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter();
        onAttachView();

    }

    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
        mainPresenter.getData();
    }

    @Override
    public void onDettach() {

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSucces(List<ArticlesItem> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainAdapter(MainActivity.this, data));
    }
}
