package projects.karlosp3rez.androidbarberbookingapp.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.accountkit.AccountKit;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import projects.karlosp3rez.androidbarberbookingapp.Adapter.HomeSliderAdapter;
import projects.karlosp3rez.androidbarberbookingapp.Adapter.LookBookAdapter;
import projects.karlosp3rez.androidbarberbookingapp.Common.Common;
import projects.karlosp3rez.androidbarberbookingapp.Interface.IBannerLoadListener;
import projects.karlosp3rez.androidbarberbookingapp.Interface.ILookbookLoadListener;
import projects.karlosp3rez.androidbarberbookingapp.Model.Banner;
import projects.karlosp3rez.androidbarberbookingapp.R;
import projects.karlosp3rez.androidbarberbookingapp.Service.PicassoImageLoadingService;
import ss.com.bannerslider.Slider;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IBannerLoadListener, ILookbookLoadListener {

    private Unbinder unbinder;

    @BindView(R.id.layout_user_information)
    LinearLayout layout_user_information;
    @BindView(R.id.txt_user_name)
    TextView txt_user_name;
    @BindView(R.id.banner_slider)
    Slider banner_slider;
    @BindView(R.id.recycler_look_book)
    RecyclerView recyclerView_look_book;

    //FireStore
    CollectionReference bannerRef, lookbookRef;

    //Interface
    IBannerLoadListener iBannerLoadListener;
    ILookbookLoadListener iLookbookLoadListener;

    public HomeFragment() {
        bannerRef = FirebaseFirestore.getInstance().collection("Banner");
        lookbookRef = FirebaseFirestore.getInstance().collection("Lookbook");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this,view);

        //init
        Slider.init(new PicassoImageLoadingService());
        iBannerLoadListener = this;
        iLookbookLoadListener = this;

        //Checkis logged
        if(AccountKit.getCurrentAccessToken() != null) {
            setUserInformation();
            loadBanner();
            loadLookBook();
        }
        return view;
    }

    private void loadLookBook() {
        lookbookRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Banner> lookbooks = new ArrayList<>();
                        if(task.isSuccessful()) {
                            for(QueryDocumentSnapshot bannerSnapShot:task.getResult()) {
                                Banner banner = bannerSnapShot.toObject(Banner.class);
                                lookbooks.add(banner);
                            }
                            iLookbookLoadListener.onLookbookLoadSuccess(lookbooks);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                iLookbookLoadListener.onLookbookLoadFailure(e.getMessage());
            }
        });
    }

    private void loadBanner() {
        bannerRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Banner> banners = new ArrayList<>();
                        if(task.isSuccessful()) {
                            for(QueryDocumentSnapshot bannerSnapShot:task.getResult()) {
                                Banner banner = bannerSnapShot.toObject(Banner.class);
                                banners.add(banner);
                            }
                            iBannerLoadListener.onBannerLoadSuccess(banners);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                iBannerLoadListener.onBannerLoadFailure(e.getMessage());
            }
        });
    }

    private void setUserInformation() {
        layout_user_information.setVisibility(View.VISIBLE);
        //TODO fix crash getName null
        //txt_user_name.setText(Common.currentUser.getName());
    }

    @Override
    public void onBannerLoadSuccess(List<Banner> banners) {
        banner_slider.setAdapter(new HomeSliderAdapter(banners));
    }

    @Override
    public void onBannerLoadFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLookbookLoadSuccess(List<Banner> banners) {
        recyclerView_look_book.setHasFixedSize(true);
        recyclerView_look_book.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_look_book.setAdapter(new LookBookAdapter(getActivity(), banners));
    }

    @Override
    public void onLookbookLoadFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
