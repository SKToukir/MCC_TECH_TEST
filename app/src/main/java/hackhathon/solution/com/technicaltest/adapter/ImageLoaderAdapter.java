package hackhathon.solution.com.technicaltest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hackhathon.solution.com.technicaltest.R;

/**
 * Created by toukir on 8/5/18.
 */

public class ImageLoaderAdapter extends RecyclerView.Adapter<ImageLoaderAdapter.ImageViewHolder>{

    private String[] imgList;
    private Context mContext;

    public ImageLoaderAdapter(Context context, String[] list){
        this.imgList = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.row_image,parent,false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        String imgUrl = imgList[position];


        Glide.with(mContext).load(imgUrl).into(holder.imgItem);

    }

    @Override
    public int getItemCount() {
        return imgList.length;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgItem;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
        }
    }
}
