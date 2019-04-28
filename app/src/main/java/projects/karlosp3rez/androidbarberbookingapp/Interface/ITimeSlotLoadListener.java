package projects.karlosp3rez.androidbarberbookingapp.Interface;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.TimeSlot;

public interface ITimeSlotLoadListener {
    void onTimeSlotLoadSuccess(List<TimeSlot> timeSlotList);
    void onTimeSlotLoadFailure(String message);
    void onTimeSlotLoadEmpty();
}
