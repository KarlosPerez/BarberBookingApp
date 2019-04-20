package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Banner;
import projects.karlosp3rez.androidbarberbookingapp.R;
import projects.karlosp3rez.androidbarberbookingapp.Service.PicassoImageLoadingService;

public class LookBookAdapter extends RecyclerView.Adapter<LookBookAdapter.LookBookViewHolder> {

    Context context;
    List<Banner> lookbook;

    public LookBookAdapter(Context context, List<Banner> lookbook) {
        this.context = context;
        this.lookbook = lookbook;
    }

    @NonNull
    @Override
    public LookBookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.layout_look_book, viewGroup, false);
        return new LookBookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LookBookViewHolder lookBookViewHolder, int i) {
        Picasso.get().load(lookbook.get(i).getImage()).into(lookBookViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return lookbook.size();
    }

    public class LookBookViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public LookBookViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_look_book);
        }
    }
}
