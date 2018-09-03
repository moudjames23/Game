package com.tarandigitalempire.bankigame;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tarandigitalempire.bankigame.adapter.ThemesListAdapter;
import com.tarandigitalempire.bankigame.data.Constant;
import com.tarandigitalempire.bankigame.data.DataBaseHelper;
import com.tarandigitalempire.bankigame.model.Themes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ThemesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ThemesListAdapter adapter;
    List<Themes> themeList;
    private  DataBaseHelper dataBaseHelper;

    public static final String DATA_SAVED_BRODCAST = "";
    RecyclerView.LayoutManager layoutManager;
    private RelativeLayout loading, data, refresh;
    private Button btn_refresh;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        recyclerView = findViewById(R.id.recyclerView);
        loading = findViewById(R.id.loadingArea);
        data = findViewById(R.id.dataArea);
        refresh = findViewById(R.id.refreshArea);
        btn_refresh = findViewById(R.id.refreshButton);
        message = findViewById(R.id.messageThemes);

        themeList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadThemesHttp();

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                refresh.setVisibility(View.INVISIBLE);
                message.setText("Chargement en cours....");
                Toast.makeText(getApplicationContext(), "Chargement des themes en cours", Toast.LENGTH_SHORT).show();
                loadThemesHttp();
            }
        });
    }


    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo !=null && networkInfo.isConnected());
    }

    public void loadThemesHttp(){

        loading.setVisibility(View.VISIBLE);
        message.setText("Chargement en cours....");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constant.THEME_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray themes = new JSONArray(response);

                            for (int i = 0; i < themes.length(); i++){

                                JSONObject themeObject = themes.getJSONObject(i);

                                int id = themeObject.getInt("id");
                                String name = themeObject.getString("name");
                                String created_at = themeObject.getString("created_at");

                                Themes theme = new Themes(id, name, created_at);
                                themeList.add(theme);
                            }

                            adapter = new ThemesListAdapter(ThemesActivity.this, themeList);
                            recyclerView.setAdapter(adapter);

                            loading.setVisibility(View.INVISIBLE);
                            message.setText("Selectionner un theme");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                refresh.setVisibility(View.VISIBLE);
                data.setVisibility(View.INVISIBLE);
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
