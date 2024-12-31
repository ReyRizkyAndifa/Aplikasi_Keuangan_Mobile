package com.rey.aplikasikeuangan3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private List<Transaction> transactionList;

    // Constructor
    public TransactionAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout untuk setiap item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        //data transaksi ke tampilan
        Transaction transaction = transactionList.get(position);
        holder.typeTextView.setText(transaction.getType());
        holder.amountTextView.setText(transaction.getAmount());
        holder.dateTextView.setText(transaction.getDate());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    // ViewHolder item transaksi
    public static class TransactionViewHolder extends RecyclerView.ViewHolder {
        TextView typeTextView, amountTextView, dateTextView;

        public TransactionViewHolder(View itemView) {
            super(itemView);
            typeTextView = itemView.findViewById(R.id.textType);
            amountTextView = itemView.findViewById(R.id.textAmount);
            dateTextView = itemView.findViewById(R.id.textDate);
        }
    }
}
