package com.example.android.network.sync.basicsyncadapter.retrofit;

import com.example.android.network.sync.basicsyncadapter.model.UserInfo;

import retrofit.http.GET;

public interface SymptomManagerSvcApi {
    public static final String PATIENT_ID_1 = "patient001";
    public static final String PATIENT_ID_2 = "patient002";
    public static final String PATIENT_ID_3 = "patient003";
    public static final String PATIENT_ID_4= "patient004";

    public static final String DOCTOR_ID_1 = "doctor001";
    public static final String DOCTOR_ID_2 = "doctor002";

    public static final String DOCTOR_SEARCH_BY_PATIENT_PATH = SymptomManagerSvcApi.DOCTOR_SVC_PATH + "/search/findByPatient";

    public static final String PATIENT_SVC_PATH = "/patient";

    public static final String DOCTOR_SVC_PATH = "/doctor";

    public static final String TOKEN_PATH = "/oauth/token";
    public static final String CHECKIN_SVC_PATH = "/checkin";

    public static final String GCM_SVC_PATH = "/userinfo/gcm";

    @GET(value="/userinfo")
    public UserInfo verifyUser();
}