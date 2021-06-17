package com.techzone.vodafonetask.ui.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.techzone.vodafonetask.R;
import com.techzone.vodafonetask.databinding.AddAirlineSheetBinding;


public class AddAirLineButtonSheet extends BottomSheetDialogFragment {

    private AddAirlineSheetBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  View view = inflater.inflate(R.layout.add_airline_sheet, container, false);
        binding = AddAirlineSheetBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
