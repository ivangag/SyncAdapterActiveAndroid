package com.example.android.network.sync.basicsyncadapter.retrofit;


import com.example.android.network.sync.basicsyncadapter.model.UserInfo;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.ApacheClient;

/**
 * Created by igaglioti on 30/10/2014.
 */
public class DownloadHelper {


    private String userName;
    private String password;
    private static DownloadHelper downloadHelper = new DownloadHelper();
    private UserInfo userInfo;

    private DownloadHelper() {

    }

    public static DownloadHelper get(){
        return downloadHelper;
    }

    public DownloadHelper setUserName(String userName) {
        this.userName = userName;
        return this;
    }


    public DownloadHelper setPassword(String password) {
        this.password = password;
        return this;
    }

    public void setUser(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUser() {
        return userInfo;
    }

    private static class ErrorRecorder implements ErrorHandler {

        private RetrofitError error;

        @Override
        public Throwable handleError(RetrofitError cause) {
            error = cause;
            return error.getCause();
        }

        public RetrofitError getError() {
            return error;
        }
    }
    private static final String GAE_URL_TRUSTED = "https://spring-mvc-capstone-test.appspot.com";
    private static final String TEST_URL_REMOTE_TRUSTED = "https://spring-mvc-capstone-test.appspot.com";

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "pass";
    private final String CLIENT_PATIENT_ID = "patient";
    private static final String CLIENT_DOCTOR_ID = "doctor";
    static ErrorRecorder error = new ErrorRecorder();

    private static SymptomManagerSvcApi symptomManagerSvcClient;

    SecuredRestBuilder builder =  new SecuredRestBuilder()
            .setLoginEndpoint(GAE_URL_TRUSTED + SymptomManagerSvcApi.TOKEN_PATH)
            .setClientId(this.CLIENT_PATIENT_ID)
            .setClient(new ApacheClient(UnsafeHttpsClient.createUnsafeClient()))
            //.setErrorHandler(error)
            .setEndpoint(GAE_URL_TRUSTED).setLogLevel(RestAdapter.LogLevel.FULL);

    public SymptomManagerSvcApi withRetrofitClient() {
        symptomManagerSvcClient =
                builder
                        .setUsername(this.userName)
                        .setPassword(this.password)
                        .setErrorHandler(error)
                        .build()
                        .create(SymptomManagerSvcApi.class);
        return symptomManagerSvcClient;
    }


/*
    public static class WithRetrofitClient {
        private String userName;
        private String password;

        public WithRetrofitClient setUserName(String userName){
            this.userName = userName;
            return this;
        }
        public WithRetrofitClient setPassword(String password){
            this.password = password;
            return this;
        }

        public SymptomManagerSvcApi Build(){

            return makeRetrofitClient(userName,password);
        }
    }*/
}
