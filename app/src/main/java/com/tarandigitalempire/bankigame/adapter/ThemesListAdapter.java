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

import com.tarandigitalempire.bankigame.R;
import com.tarandigitalempire.bankigame.SousThemesActivity;
import com.tarandigitalempire.bankigame.model.Themes;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThemesListAdapter extends RecyclerView.Adapter<ThemesListAdapter.ThemeViewHolder>{

    private List<Themes> themesList;
    private Context context;

    public ThemesListAdapter(Context context, List<Themes> themes) {
        this.themesList = themes;
        this.context =context;
    }

    @Override
    public ThemeViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_theme, parent, false);

        return (new ThemeViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final ThemeViewHolder holder, int postion) {

        final Themes theme = themesList.get(postion);
        holder.name.setText(theme.getName());

        switch (theme.getName()){
            case "Geographie":
                holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.geographie));
                break;
            case "Histoire":
                holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.histoire));
                break;
            default:
                holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.quizz));
                break;
        }


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Get clicked theme id and name
            int id = theme.getId();
            String name = theme.getName();

            Toast.makeText(context, "Le theme "+ name +" a ete selectionner", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, SousThemesActivity.class);
            intent.putExtra("ID_THEME", id);
            intent.putExtra("NAME_THEME", name);
            context.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

            }
        });
    }

    @Override
    public int getItemCount() {
        return themesList.size();
    }


    class ThemeViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private CircleImageView image;
        private CardView parentLayout;

        public ThemeViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameInput);
            image = itemView.findViewById(R.id.imageInput);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
