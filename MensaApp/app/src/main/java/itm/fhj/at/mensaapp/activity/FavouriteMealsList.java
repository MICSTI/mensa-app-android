package itm.fhj.at.mensaapp.activity;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import itm.fhj.at.mensaapp.R;

public class FavouriteMealsList extends ListActivity {

    // list containing the user's favourite meals
    private ArrayList<String> favouriteMeals = new ArrayList<String>();

    // reference to SharedPreferences
    private SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

    // SharedPreferences key for favourite meals string
    private static String KEY_FAVOURITE_MEALS = "favourite_meals";

    // Delimiter character for saving the favourite meals string in SharedPreferences
    private static String DELIMITER = ";";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_meals_list);

        // load favourite meals from SharedPreferences
        getFavouriteMealsFromPreferences();

        // populate list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.favouriteMeals);

        setListAdapter(adapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favourite_meals, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Loads the favourite meals from SharedPreferences.
     */
    private void getFavouriteMealsFromPreferences() {
        String defaultValue = "";

        String mealString = preferences.getString(KEY_FAVOURITE_MEALS, defaultValue);

        String[] meals = mealString.split(DELIMITER);

        for (String meal : meals)
            this.favouriteMeals.add(meal);
    }

    /**
     * Saves the favourite meals to SharedPreferences.
     */
    private boolean saveFavouriteMealsToPreferences() {
        // build meal string from favourite meals list
        String mealString = android.text.TextUtils.join(DELIMITER, this.favouriteMeals);

        // save string to SharedPreferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_FAVOURITE_MEALS, mealString);

        return editor.commit();
    }
}
