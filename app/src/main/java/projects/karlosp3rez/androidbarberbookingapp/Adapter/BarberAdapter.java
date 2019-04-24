package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Barber;
import projects.karlosp3rez.androidbarberbookingapp.R;

public class BarberAdapter extends RecyclerView.Adapter<BarberAdapter.BarberViewHolder> {

    Context context;
    List<Barber> barberList;

    public BarberAdapter(Context context, List<Barber> barberList) {
        this.context = context;
        this.barberList = barberList;
    }

    @NonNull
    @Override
    public BarberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_barber, viewGroup, false);
        return new BarberViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BarberViewHolder barberViewHolder, int i) {
        barberViewHolder.txt_barber_name.setText(barberList.get(i).getName());
        barberViewHolder.ratingBar.setRating((float)barberList.get(i).getRating());
    }

    @Override
    public int getItemCount() {
        return barberList.size();
    }

    public class BarberViewHolder extends RecyclerView.ViewHolder {

        TextView txt_barber_name;
        RatingBar ratingBar;

        public BarberViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_barber_name = itemView.findViewById(R.id.txt_barber_name);
            ratingBar = itemView.findViewById(R.id.rtb_barber);
        }
    }
}
