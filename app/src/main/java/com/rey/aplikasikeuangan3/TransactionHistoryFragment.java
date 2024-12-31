package com.rey.aplikasikeuangan3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    private List<Transaction> transactionList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_history, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTransactionHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // data transaksi
        transactionList = new ArrayList<>();
        transactionList.add(new Transaction("Pengiriman Uang", "Rp 200.000", "12 Okt 2024"));
        transactionList.add(new Transaction("Top Up", "Rp 100.000", "15 Okt 2024"));

        adapter = new TransactionAdapter(transactionList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
