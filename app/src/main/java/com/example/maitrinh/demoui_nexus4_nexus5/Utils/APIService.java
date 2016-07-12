package com.example.maitrinh.demoui_nexus4_nexus5.Utils;

import com.example.maitrinh.demoui_nexus4_nexus5.models.ServiceInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mai Trinh on 7/12/2016.
 */
public interface APIService {

    @GET(Constant.SERVICE_URL)
    Call<ServiceInfo> serviceRequestInfor();
}
