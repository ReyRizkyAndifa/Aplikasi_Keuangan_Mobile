package com.rey.aplikasikeuangan3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private TransactionAdapter transactionAdapter;

    public HistoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        transactionAdapter = new TransactionAdapter(getSampleTransactionData());
        recyclerView.setAdapter(transactionAdapter);

        return view;
    }

    //sample data
    private List<Transaction> getSampleTransactionData() {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction("Top-up", "Rp 100.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 50.000", "2024-11-21"));
        transactionList.add(new Transaction("Top-up", "Rp 10.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 30.000", "2024-11-21"));
        transactionList.add(new Transaction("Top-up", "Rp 100.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 50.000", "2024-11-21"));
        transactionList.add(new Transaction("Top-up", "Rp 100.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 50.000", "2024-11-21"));
        transactionList.add(new Transaction("Top-up", "Rp 100.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 50.000", "2024-11-21"));
        transactionList.add(new Transaction("Top-up", "Rp 100.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 50.000", "2024-11-21"));
        transactionList.add(new Transaction("Top-up", "Rp 100.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 50.000", "2024-11-21"));
        transactionList.add(new Transaction("Top-up", "Rp 100.000", "2024-11-20"));
        transactionList.add(new Transaction("Kirim uang", "Rp 50.000", "2024-11-21"));

        return transactionList;
    }
}
