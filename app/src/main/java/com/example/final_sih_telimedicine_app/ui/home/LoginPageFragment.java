package com.example.final_sih_telimedicine_app.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.final_sih_telimedicine_app.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

//after otp authentication, to get into home page after clicking login
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


public class LoginPageFragment extends Fragment {

    private LoginPageViewModel viewModel;

    private MaterialButton buttonLanguage;
    private TextInputEditText inputPhone;
    private TextInputEditText inputOtp;
    private Button buttonEnter;
    private Button buttonLogin;
    private MaterialButton buttonResendOtp;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_page, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LoginPageViewModel.class);

        // Views
        buttonLanguage = root.findViewById(R.id.button_language);
        inputPhone = root.findViewById(R.id.input_phone);
        inputOtp = root.findViewById(R.id.input_otp);
        buttonEnter = root.findViewById(R.id.button_enter);
        buttonLogin = root.findViewById(R.id.button_login);
        buttonResendOtp = root.findViewById(R.id.button_resend_otp);

        // Observe title text if needed (example kept for parity)
        // TextView title = root.findViewById(R.id.text_home_new);
        // viewModel.getTitleText().observe(getViewLifecycleOwner(), title::setText);
        NavHostFragment.findNavController(this).navigate(R.id.homeFragment);

        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_loginPageFragment_to_homeFragment);

        buttonLanguage.setOnClickListener(v -> {
            // Placeholder: show a simple chooser or cycle languages
            viewModel.toggleLanguage();
            Toast.makeText(requireContext(), "Language selector tapped", Toast.LENGTH_SHORT).show();
        });

        buttonEnter.setOnClickListener(v -> {
            String phone = valueOf(inputPhone);
            if (phone.length() == 10 && TextUtils.isDigitsOnly(phone)) {
                viewModel.onOtpRequested();
                Toast.makeText(requireContext(), "OTP sent to " + phone, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Enter valid 10-digit phone", Toast.LENGTH_SHORT).show();
            }
        });

        buttonResendOtp.setOnClickListener(v -> {
            viewModel.onResendRequested();
            Toast.makeText(requireContext(), "OTP resent", Toast.LENGTH_SHORT).show();
        });

        buttonLogin.setOnClickListener(v -> {
            String otp = valueOf(inputOtp);
            if (otp.length() == 6 && TextUtils.isDigitsOnly(otp)) {
                viewModel.onLoginAttempt(otp);
                Toast.makeText(requireContext(), "Login attempt", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Enter 6-digit OTP", Toast.LENGTH_SHORT).show();
            }
        });
        buttonLogin.setOnClickListener(v -> {
            String otp = valueOf(inputOtp);
            if (otp.length() == 6 && android.text.TextUtils.isDigitsOnly(otp)) {
                viewModel.onLoginAttempt(otp); // optional
                NavController nav = NavHostFragment.findNavController(this);
                nav.navigate(R.id.action_loginPageFragment_to_homeFragment); // via action
                // Fallback if the action ID isn't generated yet:
                // nav.navigate(R.id.homeFragment);
            } else {
                android.widget.Toast.makeText(requireContext(), "Enter 6-digit OTP", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String valueOf(TextInputEditText et) {
        CharSequence cs = et.getText();
        return cs == null ? "" : cs.toString().trim();
    }
    @Override public void onResume() {
        super.onResume();
        var act = (androidx.appcompat.app.AppCompatActivity) requireActivity();
        var ab = act.getSupportActionBar();
        if (ab != null) ab.hide();
    }
    @Override public void onPause() {
        super.onPause();
        var act = (androidx.appcompat.app.AppCompatActivity) requireActivity();
        var ab = act.getSupportActionBar();
        if (ab != null) ab.show();
    }

}