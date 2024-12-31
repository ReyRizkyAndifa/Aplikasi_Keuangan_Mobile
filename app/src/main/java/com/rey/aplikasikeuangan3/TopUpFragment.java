package com.rey.aplikasikeuangan3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TopUpFragment extends Fragment {

    private EditText editAmountToTopUp;
    private Button buttonTopUp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_up, container, false);

        // Inisialisasi View
        editAmountToTopUp = view.findViewById(R.id.editAmountToTopUp);
        buttonTopUp = view.findViewById(R.id.buttonTopUp);

        buttonTopUp.setOnClickListener(v -> topUp());

        return view;
    }

    private void topUp() {
        String amountString = editAmountToTopUp.getText().toString();

        // Validasi input
        if (amountString.isEmpty()) {
            Toast.makeText(getContext(), "Jumlah top up harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double amount = Double.parseDouble(amountString);

            // Proses top up
            Toast.makeText(getContext(), "Top up berhasil Rp " + amount, Toast.LENGTH_SHORT).show();

            // Reset field setelah top up
            editAmountToTopUp.setText("");

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Jumlah top up tidak valid", Toast.LENGTH_SHORT).show();
        }
    }
}
