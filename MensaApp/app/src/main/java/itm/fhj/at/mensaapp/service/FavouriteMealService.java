package itm.fhj.at.mensaapp.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FavouriteMealService extends IntentService {

    public FavouriteMealService() {
        super("FavouriteMealService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
