package itm.fhj.at.mensaapp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import itm.fhj.at.mensaapp.R;

public class MensaDetail extends Activity {

    // mensa id
    private int mensaId;

    private TextView txtMensaId;
    private TextView txtMensaName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mensa_detail);

        // references to view elements
        txtMensaId = (TextView) findViewById(R.id.mensaId);
        txtMensaName = (TextView) findViewById(R.id.mensaName);

        // get mensa id from intent extra
        //mensaId = (int)getIntent().getSerializableExtra("MENSA_ID");

        // TODO remove hard-coded mensa id
        mensaId = 50;

        // check shared preferences for a valid meal schedule
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

        // TODO remove fake JSON and implement real parsing

        JSONObject demoMealSchedule = new JSONObject();

        try {
            demoMealSchedule.put("id", mensaId);
            demoMealSchedule.put("timestamp", 12345678);
            demoMealSchedule.put("datetime", "26.10.2015T08:00:00");
            demoMealSchedule.put("name", "FH JOANNEUM Kapfenberg");

            JSONArray mealSchedule = new JSONArray();

            JSONObject day1 = new JSONObject();
            day1.put("date", "26.10.2015");
            day1.put("info", "Feiertag, heute geschlossen");

            JSONObject day2 = new JSONObject();
            day2.put("date", "27.10.2015");

            JSONArray meals = new JSONArray();

            JSONObject meal1 = new JSONObject();
            meal1.put("price", 4.30);
            meal1.put("description", "Gemüsesupppe, Marillenknödel");
            meal1.put("type", "Vegetarian");

            JSONObject meal2 = new JSONObject();
            meal2.put("price", 4.90);
            meal2.put("description", "Gemüsesuppe, Wiener Schnitzel");
            meal2.put("type", "Classic");

            JSONObject meal3 = new JSONObject();
            meal3.put("price", 5.90);
            meal3.put("description", "Paprikaschnitzel mit Salzkartoffeln und Salat vom Buffet");
            meal3.put("type", "Brainfood");

            meals.put(meal1);
            meals.put(meal2);
            meals.put(meal3);

            day2.put("meals", meals);

            mealSchedule.put(day1);
            mealSchedule.put(day2);

            demoMealSchedule.put("mealSchedule", mealSchedule);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(String.valueOf(mensaId), demoMealSchedule.toString());
        editor.commit();

        String defaultString = "";
        String mealJson = preferences.getString(String.valueOf(mensaId), defaultString);

        // TODO add check if timestamp is valid

        // display meal schedule
        try {
            JSONObject mealSchedule = new JSONObject(mealJson);

            String name = mealSchedule.getString("name");

            txtMensaId.setText(String.valueOf(mensaId));
            txtMensaName.setText(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mensa_detail, menu);
        return true;
    }
}
