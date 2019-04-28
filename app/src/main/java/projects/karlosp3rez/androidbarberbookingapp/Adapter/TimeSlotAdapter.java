package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Common.Common;
import projects.karlosp3rez.androidbarberbookingapp.Model.TimeSlot;
import projects.karlosp3rez.androidbarberbookingapp.R;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.TimeSlotViewHolder> {

    Context context;
    List<TimeSlot> timeSlotList;

    public TimeSlotAdapter(Context context, List<TimeSlot> timeSlotList) {
        this.context = context;
        this.timeSlotList = timeSlotList;
    }

    @NonNull
    @Override
    public TimeSlotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_time_slot, viewGroup, false);
        return new TimeSlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeSlotViewHolder timeSlotViewHolder, int i) {
        timeSlotViewHolder.txt_time_slot.setText(new StringBuilder(Common.convertTimeSlotToString(i)).toString());
        if(timeSlotList.size() == 0) {
            //if all position is available, just show list
            timeSlotViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
                    .getColor(android.R.color.white));
            timeSlotViewHolder.txt_time_slot_description.setText(R.string.Available);
            timeSlotViewHolder.txt_time_slot_description.setTextColor(context.getResources()
                    .getColor(android.R.color.white));
            timeSlotViewHolder.txt_time_slot.setTextColor(context.getResources()
                    .getColor(android.R.color.white));
        } else { //if have position is full (booked)
            for(TimeSlot slotValue : timeSlotList) {
                //Loop all time slot from server and set different color
                int slot = Integer.parseInt(slotValue.getSlot().toString());
                if(slot == i) { // if slot == position
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
    }

    @Override
    public int getItemCount() {
        return Common.TIME_SLOT_TOTAL;
    }

    public class TimeSlotViewHolder extends RecyclerView.ViewHolder {

        TextView txt_time_slot, txt_time_slot_description;
        CardView card_time_slot;

        public TimeSlotViewHolder(@NonNull View itemView) {
            super(itemView);

            card_time_slot = itemView.findViewById(R.id.card_time_slot);
            txt_time_slot = itemView.findViewById(R.id.txt_time_Slot);
            txt_time_slot_description = itemView.findViewById(R.id.txt_time_Slot_description);

        }
    }
}
