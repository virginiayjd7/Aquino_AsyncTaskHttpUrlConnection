package com.desarrollo.aquino_asynctaskhttpurlconnection.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desarrollo.aquino_asynctaskhttpurlconnection.Entity.TitleVO;
import com.desarrollo.aquino_asynctaskhttpurlconnection.R;

import java.util.ArrayList;

public class AdapterTitle extends RecyclerView.Adapter<AdapterTitle.TitleViewHolder> implements View.OnClickListener {
    ArrayList<TitleVO> ListaTitulos;
    Context context;
    View view;
    private View.OnClickListener listener;

    public AdapterTitle(ArrayList<TitleVO> listatitulos, Context context) {
        this.ListaTitulos = listatitulos;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_layout, parent, false);
        view.setOnClickListener(this);
        return new TitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTitle.TitleViewHolder holder, int position) {
        holder.txtTitulolibro.setText(ListaTitulos.get(position).getTitle());
        holder.txtDescripcionlibro.setText(ListaTitulos.get(position).getDescripcion());
        holder.txtDescripcionlibrolarga.setText(ListaTitulos.get(position).getDescripciondet());
        holder.fotolibro.setImageResource(ListaTitulos.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return ListaTitulos.size();
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitulolibro, txtDescripcionlibro, txtDescripcionlibrolarga;
        ImageView fotolibro;

        public TitleViewHolder(View itemView) {
            super(itemView);
            txtTitulolibro = (TextView) itemView.findViewById(R.id.TituloBook);
            txtDescripcionlibro = (TextView) itemView.findViewById(R.id.DescripcionBook);
            txtDescripcionlibrolarga = (TextView) itemView.findViewById(R.id.DescripcionBookDet);
            fotolibro = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}

