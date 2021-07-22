package com.example.covicare;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<RumahSakit> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<RumahSakit> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_contact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dNamaRS = (TextView) myDialog.findViewById(R.id.dialog_namars);
                TextView dAlamatRS = (TextView) myDialog.findViewById(R.id.dialog_alamatrs);
                TextView dNoTelpRS = (TextView) myDialog.findViewById(R.id.dialog_notelprs);
                LinearLayout dCall = (LinearLayout) myDialog.findViewById(R.id.call);
                LinearLayout dLocation = (LinearLayout) myDialog.findViewById(R.id.location);

                dNamaRS.setText(mData.get(vHolder.getAdapterPosition()).getNamars());
                dAlamatRS.setText(mData.get(vHolder.getAdapterPosition()).getAlamatrs());
                dNoTelpRS.setText(mData.get(vHolder.getAdapterPosition()).getNotelprs());

                dCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:"+mData.get(vHolder.getAdapterPosition()).getNotelprs()));
                        mContext.startActivity(i);
                    }
                });

                dLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("geo:0, 0?q="+mData.get(vHolder.getAdapterPosition()).getNamars());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        intent.setPackage("com.google.android.apps.maps");
                        mContext.startActivity(intent);
                    }
                });

                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.namars.setText(mData.get(position).getNamars());
        holder.lokasirs.setText(mData.get(position).getLokasirs());
        holder.statusrs.setText(mData.get(position).getStatusrs());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout item_contact;
        private TextView namars;
        private TextView lokasirs;
        private TextView statusrs;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_contact = (RelativeLayout) itemView.findViewById(R.id.contact_item_id);
            namars = (TextView) itemView.findViewById(R.id.namars);
            lokasirs = (TextView) itemView.findViewById(R.id.namaloc);
            statusrs = (TextView) itemView.findViewById(R.id.statusrs);
        }
    }
}
