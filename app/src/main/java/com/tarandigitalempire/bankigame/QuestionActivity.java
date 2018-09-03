package com.tarandigitalempire.bankigame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.tarandigitalempire.bankigame.data.Constant;
import com.tarandigitalempire.bankigame.model.Questions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private List<Questions> questionsList;
    private int id_soustheme;
    private String nameSoustheme;
    private TextView inputQuestion, inputScore, countQuestion, timer;
    private RadioGroup rgOption;
    private RadioButton optionOne, optionTwo, optionThree;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        rgOption = findViewById(R.id.radioGroupOption);
        optionOne = findViewById(R.id.rb_option1);
        optionTwo = findViewById(R.id.rb_option2);
        optionThree = findViewById(R.id.rb_option3);
        inputQuestion = findViewById(R.id.inputQuestion);
        btnNext = findViewById(R.id.btn_next);

        Intent intent = getIntent();
        id_soustheme = intent.getExtras().getInt("ID_SOUSTHEME");
        nameSoustheme = intent.getExtras().getString("NAME_SOUSTHEME");

        questionsList = new ArrayList<>();
        Toast.makeText(getApplicationContext(), Constant.QUESTIONS_URL+id_soustheme, Toast.LENGTH_SHORT).show();

        loadQuestionsHttp();
    }

    public void loadQuestionsHttp(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constant.QUESTIONS_URL + id_soustheme, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int id = jsonObject.getInt("id");
                        int id_sousth = jsonObject.getInt("id_soustheme");
                        String question = jsonObject.getString("question");
                        final String answer = jsonObject.getString("reponse");
                        String option1 = jsonObject.getString("option1");
                        String option2 = jsonObject.getString("option2");
                        String option3 = jsonObject.getString("option3");
                        String created_at = jsonObject.getString("created_at");

                        Questions questions = new Questions(id, id_sousth, question, answer, option1, option2, option3, created_at);
                        questionsList.add(questions);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Hello OnError", Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}

