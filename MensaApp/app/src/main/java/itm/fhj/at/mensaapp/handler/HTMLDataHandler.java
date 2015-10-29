package itm.fhj.at.mensaapp.handler;


import java.net.URL;

import itm.fhj.at.mensaapp.interfaces.ICallback;

/**
 * Created by rwachtler on 29.10.15.
 */
public class HTMLDataHandler implements ICallback{

    public void loadHTMLStringFromURL(String URLString){
        AsyncLoader asyncLoader = new AsyncLoader();
        asyncLoader.setCallback(this);
        asyncLoader.execute(URLString);
    }

    @Override
    public void handleHTMLString(String htmlString) {
        // Parse HTML Here
    }
}

