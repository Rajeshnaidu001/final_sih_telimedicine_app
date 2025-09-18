package com.example.final_sih_telimedicine_app.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginPageViewModel extends ViewModel {

    private final MutableLiveData<String> language = new MutableLiveData<>("English");
    private final MutableLiveData<Boolean> otpRequested = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> resendRequested = new MutableLiveData<>(false);
    private final MutableLiveData<String> lastLoginOtp = new MutableLiveData<>(null);

    public LiveData<String> getLanguage() { return language; }
    public LiveData<Boolean> getOtpRequested() { return otpRequested; }
    public LiveData<Boolean> getResendRequested() { return resendRequested; }
    public LiveData<String> getLastLoginOtp() { return lastLoginOtp; }

    public void toggleLanguage() {
        String current = language.getValue();
        if (current == null || current.equals("English")) language.setValue("हिन्दी");
        else if (current.equals("हिन्दी")) language.setValue("తెలుగు");
        else if (current.equals("తెలుగు")) language.setValue("ਪੰਜਾਬੀ");
        else language.setValue("English");
    }

    public void onOtpRequested() { otpRequested.setValue(true); }

    public void onResendRequested() { resendRequested.setValue(true); }

    public void onLoginAttempt(String otp) { lastLoginOtp.setValue(otp); }
}

