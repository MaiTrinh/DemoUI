package com.example.maitrinh.demoui_nexus4_nexus5;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.maitrinh.demoui_nexus4_nexus5.Utils.APIService;
import com.example.maitrinh.demoui_nexus4_nexus5.Utils.RetrofitBuilder;
import com.example.maitrinh.demoui_nexus4_nexus5.models.Datum;
import com.example.maitrinh.demoui_nexus4_nexus5.models.ServiceInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static List<Datum> normalWashList = new ArrayList<>();
    public static List<Datum> dryWashList = new ArrayList<>();
    ServiceInfo serviceInfo = new ServiceInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadServiceInfo();
        setContentView(R.layout.new_layout);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.navi);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPage(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


    }

    public void setupViewPage(ViewPager upViewPage) {
        ViewPagerAdapter viewpagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpagerAdapter.addFragment(new OneFragment(),"Normal Wash");
        viewpagerAdapter.addFragment(new TwoFragment(),"Dry Wash");
        upViewPage.setAdapter(viewpagerAdapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentListTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentListTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentListTitle.get(position);
        }
    }

    public void loadServiceInfo(){
        final APIService service = RetrofitBuilder.getServiceInfo();
        Call<ServiceInfo> call = service.serviceRequestInfor();
        call.enqueue(new Callback<ServiceInfo>() {
            @Override
            public void onResponse(Call<ServiceInfo> call, Response<ServiceInfo> response) {
                Log.d("TAG-main","check code : " + response.code());
                Log.d("TAG-main","check list size " + response.body().getData().size());
                serviceInfo = response.body();
                for (int i = 0; i < response.body().getData().size(); i++){
                    if(response.body().getData().get(i).getServiceType().equals("Dry Wash")){
                        normalWashList.add(response.body().getData().get(i));
                        Log.d("TAG-main","check normal wash list " + normalWashList.size());
                    }else{
                        dryWashList.add(response.body().getData().get(i));
                        Log.d("TAG-main","check dry wash list " + dryWashList.size());
                    }
                }
            }

            @Override
            public void onFailure(Call<ServiceInfo> call, Throwable t) {

            }
        });
    }
}
