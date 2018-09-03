package com.tarandigitalempire.bankigame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tarandigitalempire.bankigame.QuestionActivity;
import com.tarandigitalempire.bankigame.R;
import com.tarandigitalempire.bankigame.model.SousThemes;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SousThemeAdapter extends RecyclerView.Adapter<SousThemeAdapter.SousThemeViewHolder>{

    private List<SousThemes> sousThemesList;
    private Context context;

    public SousThemeAdapter(List<SousThemes> sousThemesList, Context context) {
        this.sousThemesList = sousThemesList;
        this.context = context;
    }

    @Override
    public SousThemeViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sousthemes, parent, false);
        return (new SousThemeViewHolder(view));
    }

    @Override
    public void onBindViewHolder(SousThemeViewHolder holder, int i) {
        final SousThemes sousThemes = sousThemesList.get(i);
        holder.name.setText(sousThemes.getName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = sousThemes.getId();
                String name = sousThemes.getName();
                Toast.makeText(context, "Le Sous Theme "+ name +" a ete selectionner", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, QuestionActivity.class);
                intent.putExtra("ID_SOUSTHEME", id);
                intent.putExtra("NAME_SOUSTHEME", name);
                context.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

            }
        });
    }

    @Override
    public int getItemCount() {
        return sousThemesList.size();
    }

    public class SousThemeViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private CircleImageView image;
        private CardView parentLayout;

        public SousThemeViewHolder( View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameInput);
            image = itemView.findViewById(R.id.imageInput);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
