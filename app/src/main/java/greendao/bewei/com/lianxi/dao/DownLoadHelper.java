package greendao.bewei.com.lianxi.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 大白 on 2017/11/21.
 */

public class DownLoadHelper extends SQLiteOpenHelper{


    private static final String SQL_NAME = "download.db";
    private static final int DOWNLOAD_VERSION=1;
    public DownLoadHelper(Context context) {
        super(context, SQL_NAME, null, DOWNLOAD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table download_info(_id integer PRIMARY KEY AUTOINCREMENT, thread_id integer, "
                + "start_pos integer, end_pos integer, compelete_size integer,url char)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
