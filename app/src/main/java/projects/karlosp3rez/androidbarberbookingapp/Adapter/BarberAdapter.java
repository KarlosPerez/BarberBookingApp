package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Common.Common;
import projects.karlosp3rez.androidbarberbookingapp.Interface.IRecyclerItemSelectedListener;
import projects.karlosp3rez.androidbarberbookingapp.Model.Barber;
import projects.karlosp3rez.androidbarberbookingapp.R;

public class BarberAdapter extends RecyclerView.Adapter<BarberAdapter.BarberViewHolder> {

    Context context;
    List<Barber> barberList;
    List<CardView> cardViewList;
    LocalBroadcastManager localBroadcastManager;

    public BarberAdapter(Context context, List<Barber> barberList) {
        this.context = context;
        this.barberList = barberList;
        cardViewList = new ArrayList<>();
        localBroadcastManager = LocalBroadcastManager.getInstance(context);
    }

    @NonNull
    @Override
    public BarberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_barber, viewGroup, false);
        return new BarberViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BarberViewHolder barberViewHolder, int i) {
        barberViewHolder.txt_barber_name.setText(barberList.get(i).getName());
        barberViewHolder.ratingBar.setRating((float)barberList.get(i).getRating());
        if(!cardViewList.contains(barberViewHolder.card_barber)) {
            cardViewList.add(barberViewHolder.card_barber);
        }
        barberViewHolder.setiRecyclerItemSelectedListener(new IRecyclerItemSelectedListener() {
            @Override
            public void onItemSelectedListener(View view, int position) {
                //set Background for all item not choice
                for(CardView cardView: cardViewList) {
                    cardView.setCardBackgroundColor(context.getResources().getColor(android.R.color.white));
                }

                //set Background for choice
                barberViewHolder.card_barber.setCardBackgroundColor(
                        context.getResources().getColor(android.R.color.holo_orange_dark));

                //send local broadcast to enable button next
                Intent intent = new Intent(Common.KEY_ENABLE_BUTTON_TEXT);
                intent.putExtra(Common.KEY_BARBER_SELECTED, barberList.get(position));
                intent.putExtra(Common.KEY_STEP, 2);
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return barberList.size();
    }

    public class BarberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt_barber_name;
        RatingBar ratingBar;
        CardView card_barber;
        IRecyclerItemSelectedListener iRecyclerItemSelectedListener;

        public void setiRecyclerItemSelectedListener(IRecyclerItemSelectedListener iRecyclerItemSelectedListener) {
            this.iRecyclerItemSelectedListener = iRecyclerItemSelectedListener;
        }

        public BarberViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_barber_name = itemView.findViewById(R.id.txt_barber_name);
            ratingBar = itemView.findViewById(R.id.rtb_barber);
            card_barber = itemView.findViewById(R.id.card_barber);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            iRecyclerItemSelectedListener.onItemSelectedListener(view, getAdapterPosition());
        }
    }
}
