package projects.karlosp3rez.androidbarberbookingapp.Interface;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Banner;

public interface IBannerLoadListener {
    void onBannerLoadSuccess(List<Banner> banners);
    void onBannerLoadFailure(String message);
}
