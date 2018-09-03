package com.tarandigitalempire.bankigame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tarandigitalempire.bankigame.adapter.SousThemeAdapter;
import com.tarandigitalempire.bankigame.data.*;
import com.tarandigitalempire.bankigame.data.DataBaseHelper;
import com.tarandigitalempire.bankigame.model.SousThemes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SousThemesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SousThemeAdapter adapter;
    List<SousThemes> sousThemesList;
    private  DataBaseHelper dataBaseHelper;

    public static final String DATA_SAVED_BRODCAST = "";
    RecyclerView.LayoutManager layoutManager;
    private RelativeLayout loading, data, refresh;
    private Button btn_refresh;
    private TextView message;
    private int id_th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sous_themes);

        recyclerView = findViewById(R.id.recyclerView);
        loading = findViewById(R.id.loadingArea);
        data = findViewById(R.id.dataArea);
        refresh = findViewById(R.id.refreshArea);
        btn_refresh = findViewById(R.id.refreshButton);
        message = findViewById(R.id.messageThemes);

        sousThemesList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        id_th = intent.getExtras().getInt("ID_THEME");

        loadSousThemesHttp();

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                refresh.setVisibility(View.INVISIBLE);
                message.setText("Chargement en cours....");
                Toast.makeText(getApplicationContext(), "Chargement des sous themes en cours", Toast.LENGTH_SHORT).show();
                loadSousThemesHttp();
            }
        });
    }

    public void loadSousThemesHttp(){

        loading.setVisibility(View.VISIBLE);
        message.setText("Chargement en cours....");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constant.SOUS_THEME_URL+id_th,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray sousthemes = new JSONArray(response);

                            for (int i = 0; i < sousthemes.length(); i++){

                                JSONObject sousthemeObject = sousthemes.getJSONObject(i);

                                int id = sousthemeObject.getInt("id");
                                int id_theme = sousthemeObject.getInt("id_theme");
                                String name = sousthemeObject.getString("name");
                                String created_at = sousthemeObject.getString("created_at");

                                SousThemes sousTheme = new SousThemes(id, id_theme, name, created_at);
                                sousThemesList.add(sousTheme);
                            }

                            adapter = new SousThemeAdapter(sousThemesList, SousThemesActivity.this);
                            recyclerView.setAdapter(adapter);

                            loading.setVisibility(View.INVISIBLE);
                            message.setText("Selectionner un theme");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

                refresh.setVisibility(View.VISIBLE);
                data.setVisibility(View.INVISIBLE);
            }
        });

        Volley .newRequestQueue(this).add(stringRequest);
    }
}
