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

public class SendMoneyFragment extends Fragment {

    private EditText editAmountToSend, editRecipient;
    private Button buttonSendMoney;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_money, container, false);

        // Inisialisasi View
        editAmountToSend = view.findViewById(R.id.editAmountToSend);
        editRecipient = view.findViewById(R.id.editRecipient);
        buttonSendMoney = view.findViewById(R.id.buttonSendMoney);

        buttonSendMoney.setOnClickListener(v -> sendMoney());

        return view;
    }

    private void sendMoney() {
        String amountString = editAmountToSend.getText().toString();
        String recipient = editRecipient.getText().toString();

        // Validasi input
        if (amountString.isEmpty()) {
            Toast.makeText(getContext(), "Jumlah uang harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        if (recipient.isEmpty()) {
            Toast.makeText(getContext(), "Penerima harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double amount = Double.parseDouble(amountString);

            // Proses kirim uang (ini hanya contoh, implementasi nyata akan melibatkan backend)
            Toast.makeText(getContext(), "Kirim uang Rp " + amount + " ke " + recipient, Toast.LENGTH_SHORT).show();

            // Reset field setelah kirim uang
            editAmountToSend.setText("");
            editRecipient.setText("");

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Jumlah uang tidak valid", Toast.LENGTH_SHORT).show();
        }
    }
}
