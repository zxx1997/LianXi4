package greendao.bewei.com.lianxi;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 大白 on 2017/11/21.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private List<Bean.DataBean> list;
    private Context context;


    public Myadapter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);
        //放在OnCreateViewHolder
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Uri uri = Uri.parse(list.get(position).getImage_url());
        holder.sdv.setImageURI(uri);

        holder.tv.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv = itemView.findViewById(R.id.tv);
        }
    }




     //接口回调
         private OnItemClickListener listener;

         public interface OnItemClickListener {
             void onItemClick(int position);
         }

         public void setOnItemClickListener(OnItemClickListener listener) {
             this.listener = listener;
         }







}
