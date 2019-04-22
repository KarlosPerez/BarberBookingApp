package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Salon;
import projects.karlosp3rez.androidbarberbookingapp.R;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.SalonViewHolder> {

    private List<Salon> salonList;
    private Context context;

    public SalonAdapter(List<Salon> salonList, Context context) {
        this.salonList = salonList;
        this.context = context;
    }

    @NonNull
    @Override
    public SalonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_salon, viewGroup, false);
        return new SalonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SalonViewHolder salonViewHolder, int i) {
        salonViewHolder.txt_salon_name.setText(salonList.get(i).getName());
        salonViewHolder.txt_salon_address.setText(salonList.get(i).getAddress());
    }

    @Override
    public int getItemCount() {
        return salonList.size();
    }

    class SalonViewHolder extends RecyclerView.ViewHolder {
        TextView txt_salon_name, txt_salon_address;
        SalonViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_salon_name = itemView.findViewById(R.id.txt_salon_name);
            txt_salon_address = itemView.findViewById(R.id.txt_salon_address);
        }
    }
}
