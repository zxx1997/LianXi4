package greendao.bewei.com.lianxi.presenter;

import greendao.bewei.com.lianxi.Bean;
import greendao.bewei.com.lianxi.model.ShowModel;
import greendao.bewei.com.lianxi.model.ShowModelSx;
import greendao.bewei.com.lianxi.view.FinishListener;
import greendao.bewei.com.lianxi.view.ShowVIew;

/**
 * Created by 大白 on 2017/11/20.
 */

public class ShowPresenterSx implements  ShowPresenter ,FinishListener{

    private ShowVIew showVIew;
    private final ShowModel showModel;

    public ShowPresenterSx(ShowVIew showVIew) {
        this.showVIew = showVIew;
        showModel = new ShowModelSx();
    }

    @Override
    public void passData() {
         showModel.getData(this);
    }

    @Override
    public void Success(Bean bean) {
         showVIew.showData(bean);
    }
}
