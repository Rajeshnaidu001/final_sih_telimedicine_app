package com.example.final_sih_telimedicine_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.final_sih_telimedicine_app.R;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);

        MaterialButton btnMedicine = root.findViewById(R.id.btn_medicine);
        MaterialButton btnConsult  = root.findViewById(R.id.btn_consult);
        MaterialButton btnReports  = root.findViewById(R.id.btn_reports);
        MaterialButton btnSymptom  = root.findViewById(R.id.btn_symptom);
        MaterialButton btnSos      = root.findViewById(R.id.btn_sos);

        View.OnClickListener todo = v -> {
            // TODO: Hook up Navigation actions when wiring flows
            // Example:
            NavHostFragment.findNavController(this).navigate(R.id.action_home_to_feature);
        };

        btnMedicine.setOnClickListener(todo);
        btnConsult.setOnClickListener(todo);
        btnReports.setOnClickListener(todo);
        btnSymptom.setOnClickListener(todo);
        btnSos.setOnClickListener(todo);
    }
}
