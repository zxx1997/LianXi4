package greendao.bewei.com.lianxi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import greendao.bewei.com.lianxi.presenter.ShowPresenter;
import greendao.bewei.com.lianxi.presenter.ShowPresenterSx;
import greendao.bewei.com.lianxi.view.ShowVIew;

public class MainActivity extends AppCompatActivity implements ShowVIew{


    private RecyclerView recyclerView;
    private ShowPresenter showPresenter;
    private List<String> images;
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      recyclerView = (RecyclerView) findViewById(R.id.recycler);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showPresenter = new ShowPresenterSx(this);
        showPresenter.passData();

        banner = (Banner) findViewById(R.id.banner);
    }



    @Override
    public void showData(Bean bean) {


        final List<Bean.DataBean> list = bean.getData();
        Myadapter adapter = new Myadapter(list,MainActivity.this);
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("确认")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setMessage("确定下载")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this,ThreadActivity.class);
                                intent.putExtra("vedio",list.get(position).getVedio_url());
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("取消",null)
                        .show();

            }
        });

        images = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            String image_url = list.get(i).getImage_url();
            images.add(image_url);
        }

        banner.setImageLoader(new MyImage());
        banner.setImages(images);
        banner.setDelayTime(3000);
        banner.start();


    }

}
