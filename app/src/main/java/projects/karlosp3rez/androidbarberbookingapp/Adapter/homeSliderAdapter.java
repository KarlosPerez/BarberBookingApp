package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import java.util.List;

import projects.karlosp3rez.androidbarberbookingapp.Model.Banner;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class homeSliderAdapter extends SliderAdapter {

    List<Banner> bannerList;

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        imageSlideViewHolder.bindImageSlide(bannerList.get(position).getImage());
    }
}
