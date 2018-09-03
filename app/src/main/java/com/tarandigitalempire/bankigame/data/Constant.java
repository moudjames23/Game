package com.tarandigitalempire.bankigame.data;

public class Constant {

    //database info
    public static final String DATABASE_NAME = "bankigame";
    public static final int DATABASE_VERSION = 1;

    //url
    public static final String BASE_URL = "http://192.168.43.131/games/";
    public static final String THEME_URL = BASE_URL+"gethemes.php";
    public static final String SOUS_THEME_URL = BASE_URL+"getSousthemeByThemeId.php?id_theme=";
    public static final String QUESTIONS_URL = BASE_URL+"getQuestionBySousThemeId.php?id_soustheme=";

    //Table themes
    public static final String THEME_TABLE = "themes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_THEME_NAME = "name";
    public static final String COLUMN_THEME_DATE = "created_at";

    //Table Sousthemes
    public static final String SOUSTHEME_TABLE = "themes";
    public static final String COLUMN_SOUSTHEME_ID = "id";
    public static final String COLUMN_THEME_ID = "id_theme";
    public static final String COLUMN_SOUSTHEME_NAME = "name";
    public static final String COLUMN_SOUSTHEME_DATE = "created_at";
}
