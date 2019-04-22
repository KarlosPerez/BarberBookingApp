package projects.karlosp3rez.androidbarberbookingapp.Interface;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Salon;

public interface IBanchLoadListener {
    void onBranchLoadSuccess(List<Salon> salonList);
    void onBranchLoadFailed(String message);
}
