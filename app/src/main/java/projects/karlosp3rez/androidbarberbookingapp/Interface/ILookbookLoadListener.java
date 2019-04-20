package projects.karlosp3rez.androidbarberbookingapp.Interface;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Banner;

public interface ILookbookLoadListener {
    void onLookbookLoadSuccess(List<Banner> banners);
    void onLookbookLoadFailure(String message);
}
