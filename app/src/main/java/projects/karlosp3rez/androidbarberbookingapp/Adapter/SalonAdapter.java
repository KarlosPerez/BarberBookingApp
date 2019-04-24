package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Common.Common;
import projects.karlosp3rez.androidbarberbookingapp.Interface.IRecyclerItemSelectedListener;
import projects.karlosp3rez.androidbarberbookingapp.Model.Salon;
import projects.karlosp3rez.androidbarberbookingapp.R;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.SalonViewHolder> {

    private List<Salon> salonList;
    private Context context;
    List<CardView> cardViewList;
    LocalBroadcastManager localBroadcastManager;

    public SalonAdapter(List<Salon> salonList, Context context) {
        this.salonList = salonList;
        this.context = context;
        cardViewList = new ArrayList<>();
        localBroadcastManager = LocalBroadcastManager.getInstance(context);
    }

    @NonNull
    @Override
    public SalonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_salon, viewGroup, false);
        return new SalonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SalonViewHolder salonViewHolder, int i) {
        salonViewHolder.txt_salon_name.setText(salonList.get(i).getName());
        salonViewHolder.txt_salon_address.setText(salonList.get(i).getAddress());
        if(!cardViewList.contains(salonViewHolder.card_salon)) {
            cardViewList.add(salonViewHolder.card_salon);
        }
        salonViewHolder.setiRecyclerItemSelectedListener(new IRecyclerItemSelectedListener() {
            @Override
            public void onItemSelectedListener(View view, int position) {
                //set white background for all card not be selected
                for(CardView cardView:cardViewList) {
                    cardView.setCardBackgroundColor(context.getResources().getColor(android.R.color.white));
                }
                //Set selected background for only selected item
                salonViewHolder.card_salon.setCardBackgroundColor(context.getResources()
                        .getColor(android.R.color.holo_orange_dark));
                //Send broadcast to tell Booking activity enable button next
                Intent intent = new Intent(Common.KEY_ENABLE_BUTTON_TEXT);
                intent.putExtra(Common.KEY_SALON_STORE, salonList.get(position));
                localBroadcastManager.sendBroadcast(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return salonList.size();
    }

    class SalonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_salon_name, txt_salon_address;
        CardView card_salon;
        IRecyclerItemSelectedListener iRecyclerItemSelectedListener;

        public void setiRecyclerItemSelectedListener(IRecyclerItemSelectedListener iRecyclerItemSelectedListener) {
            this.iRecyclerItemSelectedListener = iRecyclerItemSelectedListener;
        }

        SalonViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_salon_name = itemView.findViewById(R.id.txt_salon_name);
            txt_salon_address = itemView.findViewById(R.id.txt_salon_address);
            card_salon = itemView.findViewById(R.id.card_salon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            iRecyclerItemSelectedListener.onItemSelectedListener(view, getAdapterPosition());
        }
    }
}
