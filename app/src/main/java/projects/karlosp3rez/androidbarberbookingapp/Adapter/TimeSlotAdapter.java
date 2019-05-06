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
import projects.karlosp3rez.androidbarberbookingapp.Model.TimeSlot;
import projects.karlosp3rez.androidbarberbookingapp.R;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.TimeSlotViewHolder> {

    Context context;
    List<TimeSlot> timeSlotList;
    List<CardView> cardViewList;
    LocalBroadcastManager localBroadcastManager;

    public TimeSlotAdapter(Context context) {
        this.context = context;
        this.timeSlotList = new ArrayList<>();
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
        cardViewList = new ArrayList<>();
    }

    public TimeSlotAdapter(Context context, List<TimeSlot> timeSlotList) {
        this.context = context;
        this.timeSlotList = timeSlotList;
        this.localBroadcastManager = LocalBroadcastManager.getInstance(context);
        cardViewList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TimeSlotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_time_slot, viewGroup, false);
        return new TimeSlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TimeSlotViewHolder timeSlotViewHolder, final int i) {
        timeSlotViewHolder.txt_time_slot.setText(new StringBuilder(Common.convertTimeSlotToString(i)).toString());
        if(timeSlotList.size() == 0) {
            //if all position is available, just show list
            timeSlotViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
                    .getColor(android.R.color.white));
            timeSlotViewHolder.txt_time_slot_description.setText(R.string.Available);
            timeSlotViewHolder.txt_time_slot_description.setTextColor(context.getResources()
                    .getColor(android.R.color.black));
            timeSlotViewHolder.txt_time_slot.setTextColor(context.getResources()
                    .getColor(android.R.color.black));
        } else { //if have position is full (booked)
            for(TimeSlot slotValue : timeSlotList) {
                //Loop all time slot from server and set different color
                int slot = Integer.parseInt(slotValue.getSlot().toString());
                if(slot == i) { // if slot == position
                    //we will set tag for all time slot is full
                    //So base on tag, we can set all remain card background without change full time slot
                    timeSlotViewHolder.card_time_slot.setTag(Common.DISABLE_TAG);
                    timeSlotViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
                            .getColor(android.R.color.darker_gray));
                    timeSlotViewHolder.txt_time_slot_description.setText(R.string.full);
                    timeSlotViewHolder.txt_time_slot_description.setTextColor(context.getResources()
                            .getColor(android.R.color.white));
                    timeSlotViewHolder.txt_time_slot.setTextColor(context.getResources()
                            .getColor(android.R.color.white));
                }
            }
        }

        //Add all card to list (20 card because we have 20 time slot
        //No add card already in cardViewList
        if(!cardViewList.contains(timeSlotViewHolder.card_time_slot))
            cardViewList.add(timeSlotViewHolder.card_time_slot);

        //check if card time slot is available
        timeSlotViewHolder.setiRecyclerItemSelectedListener(new IRecyclerItemSelectedListener() {
            @Override
            public void onItemSelectedListener(View view, int position) {
                //loop all card in card list
                for(CardView cardView : cardViewList) {
                    if(cardView.getTag() == null) //only available card time slot be change
                        cardView.setCardBackgroundColor(context.getResources()
                                .getColor(android.R.color.white));
                }
                //Our selected card will be change color
                timeSlotViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
                .getColor(android.R.color.holo_orange_dark));
                //After that, send broadcast to enable button NEXT
                Intent intent = new Intent(Common.KEY_ENABLE_BUTTON_TEXT);
                intent.putExtra(Common.KEY_TIME_SLOT, i); //put index of time slot we have selected
                intent.putExtra(Common.KEY_STEP, 3); //go to step 3
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Common.TIME_SLOT_TOTAL;
    }

    public class TimeSlotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt_time_slot, txt_time_slot_description;
        CardView card_time_slot;

        IRecyclerItemSelectedListener iRecyclerItemSelectedListener;

        public void setiRecyclerItemSelectedListener(IRecyclerItemSelectedListener iRecyclerItemSelectedListener) {
            this.iRecyclerItemSelectedListener = iRecyclerItemSelectedListener;
        }

        public TimeSlotViewHolder(@NonNull View itemView) {
            super(itemView);

            card_time_slot = itemView.findViewById(R.id.card_time_slot);
            txt_time_slot = itemView.findViewById(R.id.txt_time_Slot);
            txt_time_slot_description = itemView.findViewById(R.id.txt_time_Slot_description);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            iRecyclerItemSelectedListener.onItemSelectedListener(view, getAdapterPosition());
        }
    }
}
