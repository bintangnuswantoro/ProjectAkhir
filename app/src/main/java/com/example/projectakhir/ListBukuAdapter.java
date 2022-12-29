package com.example.projectakhir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListBukuAdapter extends RecyclerView.Adapter<ListBukuAdapter.ListViewHolder> {
    private ArrayList<Buku> listBuku;
    private OnBukuListener mOnBukuListener;

    public ListBukuAdapter(ArrayList<Buku> list, OnBukuListener onBukuListener) {
        this.listBuku = list;
        this.mOnBukuListener = onBukuListener;
    }
    
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(view, mOnBukuListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Buku buku = listBuku.get(position);
        holder.tvName.setText(buku.getName());
    }

    @Override
    public int getItemCount() {
        return listBuku.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvName;
        OnBukuListener onBukuListener;

        ListViewHolder(View itemview, OnBukuListener onBukuListener) {
            super(itemview);
            tvName = itemview.findViewById(R.id.item_name);
            this.onBukuListener = onBukuListener;

            itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onBukuListener.onBukuClick(getAdapterPosition());
        }
    }

    public interface OnBukuListener {
        void onBukuClick(int position);
    }
}
