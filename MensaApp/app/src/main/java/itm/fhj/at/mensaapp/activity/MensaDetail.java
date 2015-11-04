package itm.fhj.at.mensaapp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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
        String demoMealString = "{'id': 50, 'timestamp': 12345678, 'datetime': '26.10.2015T08:00:00', 'name': 'FH JOANNEUM Kapfenberg', 'mealSchedule': [{'date': '26.10.2015', 'info': 'Feiertag heute geschlossen'}, {'date': '27.10.2015', 'meals': [{'price': 4.30, 'description': 'Gemüsesupppe, Marillenknödel', 'type': 'Vegetarian'}, {'price': 4.90, 'description': 'Gemüsesuppe, Wiener Schnitzel', 'type': 'Classic'}, {'price': 4.90, 'description': 'Paprikaschnitzel mit Salzkartoffeln und Salat vom Buffet', 'type': 'Brainfood'}]}]}";

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(String.valueOf(mensaId), demoMealString.replace('\'', '"'));

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
