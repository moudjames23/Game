[33mcommit ea8c516e5e2fa3f4daeb5794e2089a119744aa50[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m, [m[1;31morigin/master[m[33m)[m
Author: Taran Diallo <taranjalloh@gmail.com>
Date:   Mon Sep 3 11:42:15 2018 +0000

    Ajout des tableaux dans QuestionActivity

[1mdiff --git a/app/src/main/java/com/tarandigitalempire/bankigame/QuestionActivity.java b/app/src/main/java/com/tarandigitalempire/bankigame/QuestionActivity.java[m
[1mindex 3f1338f..50754a1 100644[m
[1m--- a/app/src/main/java/com/tarandigitalempire/bankigame/QuestionActivity.java[m
[1m+++ b/app/src/main/java/com/tarandigitalempire/bankigame/QuestionActivity.java[m
[36m@@ -34,30 +34,42 @@[m [mpublic class QuestionActivity extends AppCompatActivity {[m
     private int id_soustheme;[m
     private String nameSoustheme;[m
     private TextView inputQuestion, inputScore, countQuestion, timer;[m
[31m-    private RadioGroup rgOption;[m
[31m-    private RadioButton optionOne, optionTwo, optionThree;[m
[31m-    private Button btnNext;[m
[32m+[m[32m    private Button optionOne, optionTwo, optionThree;[m
 [m
     @Override[m
     protected void onCreate(Bundle savedInstanceState) {[m
         super.onCreate(savedInstanceState);[m
         setContentView(R.layout.activity_question);[m
 [m
[31m-        rgOption = findViewById(R.id.radioGroupOption);[m
         optionOne = findViewById(R.id.rb_option1);[m
         optionTwo = findViewById(R.id.rb_option2);[m
         optionThree = findViewById(R.id.rb_option3);[m
         inputQuestion = findViewById(R.id.inputQuestion);[m
[31m-        btnNext = findViewById(R.id.btn_next);[m
 [m
         Intent intent = getIntent();[m
         id_soustheme = intent.getExtras().getInt("ID_SOUSTHEME");[m
         nameSoustheme = intent.getExtras().getString("NAME_SOUSTHEME");[m
 [m
         questionsList = new ArrayList<>();[m
[31m-        Toast.makeText(getApplicationContext(), Constant.QUESTIONS_URL+id_soustheme, Toast.LENGTH_SHORT).show();[m
[31m-[m
         loadQuestionsHttp();[m
[32m+[m[32m        Log.e("LISTE: ", ""+questionsList.size());[m
[32m+[m
[32m+[m[32m        String tabQuestion[] = new String[questionsList.size()];[m
[32m+[m[32m        String tabOption[][] = new String[questionsList.size()][3];[m
[32m+[m[32m        String tabReponse[] = new String[questionsList.size()];[m
[32m+[m
[32m+[m[32m        Questions quest;[m
[32m+[m[32m        for (int i = 0; i < questionsList.size(); i++) {[m
[32m+[m
[32m+[m[32m            quest = questionsList.get(i);[m
[32m+[m
[32m+[m[32m            tabQuestion[i] = quest.getQuestion();[m
[32m+[m[32m            tabOption[i][0] = quest.getOption1();[m
[32m+[m[32m            tabOption[i][1] = quest.getOption2();[m
[32m+[m[32m            tabOption[i][2] = quest.getOption2();[m
[32m+[m[32m            tabReponse[i] = quest.getReponse();[m
[32m+[m
[32m+[m[32m        }[m
     }[m
 [m
     public void loadQuestionsHttp(){[m
[36m@@ -97,5 +109,6 @@[m [mpublic class QuestionActivity extends AppCompatActivity {[m
 [m
         Volley.newRequestQueue(this).add(stringRequest);[m
     }[m
[32m+[m[41m    [m
 }[m
 [m
