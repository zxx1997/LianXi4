package greendao.bewei.com.lianxi;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 大白 on 2017/11/20.
 */

public interface ApiService {


    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio")
    Observable<Bean> getData();



}
