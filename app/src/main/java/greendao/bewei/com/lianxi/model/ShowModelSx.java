package greendao.bewei.com.lianxi.model;

import greendao.bewei.com.lianxi.Api;
import greendao.bewei.com.lianxi.ApiService;
import greendao.bewei.com.lianxi.Bean;
import greendao.bewei.com.lianxi.RetrofitUtils;
import greendao.bewei.com.lianxi.view.FinishListener;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 大白 on 2017/11/20.
 */

public class ShowModelSx implements ShowModel{


    @Override
    public void getData(final FinishListener listener) {

        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.api_data, ApiService.class);
        Observable<Bean> observable = apiService.getData();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Bean bean) {
                 listener.Success(bean);
            }
        });

    }



}
