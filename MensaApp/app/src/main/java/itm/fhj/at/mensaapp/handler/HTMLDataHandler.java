package itm.fhj.at.mensaapp.handler;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

import itm.fhj.at.mensaapp.interfaces.ICallback;
import itm.fhj.at.mensaapp.interfaces.IParseCallback;
import itm.fhj.at.mensaapp.model.Location;

/**
 * Created by rwachtler on 29.10.15.
 */
public class HTMLDataHandler implements ICallback{

    private IParseCallback parseCallback;

    /**
     * Starts an asynchronous request for given URL (String)
     * @param URLString - URLString which has to be requested
     */
    public void loadHTMLStringFromURL(String URLString){
        AsyncLoader asyncLoader = new AsyncLoader();
        asyncLoader.setCallback(this);
        asyncLoader.execute(URLString);
    }


    @Override
    public void parseHTMLString(String htmlString) {
        Document doc = Jsoup.parse(htmlString);
        parseCallback.processLocationData(doc);
    }

    public void setCallback(IParseCallback callback){
        this.parseCallback = callback;
    }
}

