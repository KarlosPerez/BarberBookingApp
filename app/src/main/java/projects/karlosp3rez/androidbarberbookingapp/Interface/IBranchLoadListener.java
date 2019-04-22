package projects.karlosp3rez.androidbarberbookingapp.Interface;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Salon;

public interface IBranchLoadListener {
    void onBranchLoadSuccess(List<Salon> salonList);
    void onBranchLoadFailed(String message);
}
