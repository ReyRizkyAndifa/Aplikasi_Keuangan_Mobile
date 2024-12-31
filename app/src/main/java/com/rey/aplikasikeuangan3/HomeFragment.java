package com.rey.aplikasikeuangan3;

import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.TimeZone;

public class HomeFragment extends Fragment {

    private TextView textTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        textTime = rootView.findViewById(R.id.textTime);

        // Menambahkan handler untuk update waktu setiap detik
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Mendapatkan waktu saat ini dan format menjadi jam digital
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
                String currentTime = DateFormat.format("HH:mm:ss", calendar).toString();
                textTime.setText(currentTime);

                // Update setiap detik
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);

        return rootView;
    }
}
