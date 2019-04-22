package projects.karlosp3rez.androidbarberbookingapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import projects.karlosp3rez.androidbarberbookingapp.Fragments.BookingStep1Fragment;
import projects.karlosp3rez.androidbarberbookingapp.Fragments.BookingStep2Fragment;
import projects.karlosp3rez.androidbarberbookingapp.Fragments.BookingStep3Fragment;
import projects.karlosp3rez.androidbarberbookingapp.Fragments.BookingStep4Fragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i) {
            case 0: return BookingStep1Fragment.getInstance();
            case 1: return BookingStep2Fragment.getInstance();
            case 2: return BookingStep3Fragment.getInstance();
            case 3: return BookingStep4Fragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
