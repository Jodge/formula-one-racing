package com.formulaone.racing.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author George Otieno
 *
 */
public class FormulaOneService {
	
	private static final String ERGAST_URL = "http://ergast.com/api/f1/2015/driverStandings.json";

    /**
     * @param rd
     * @return
     * @throws IOException
     */
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }

    /**
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    /**
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public JSONObject getMainJson() throws IOException, JSONException {

        JSONObject response = readJsonFromUrl(ERGAST_URL);
        return response;
    }

    /**
     * @return
     */
    public JSONArray getStandingsLists() {
        JSONArray standingsList;
        try {
            standingsList = getMainJson().getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists");
            return standingsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return
     */
    public JSONArray getFormulaOneRacingData() {

        JSONArray rootArray = new JSONArray();
        JSONObject object = getStandingsLists().getJSONObject(0);
        JSONArray driverStandings = object.getJSONArray("DriverStandings");
        try {
            for (int n = 0; n < driverStandings.length(); n++) {
                JSONObject jsonOject = driverStandings.getJSONObject(n);
                JSONArray constructor = jsonOject.getJSONArray("Constructors");
                JSONObject constructorJsonObject = constructor.getJSONObject(0);
                String position = jsonOject.getString("position");
                String points = jsonOject.getString("points");
                String givenName = jsonOject.getJSONObject("Driver").getString("givenName");
                String familyName = jsonOject.getJSONObject("Driver").getString("familyName");
                String url = jsonOject.getJSONObject("Driver").getString("url");
                String nationality = jsonOject.getJSONObject("Driver").getString("nationality");
                String raceUrl = constructorJsonObject.getString("url");
                String race = constructorJsonObject.getString("name");

                JSONObject jsonObj = new JSONObject();
                jsonObj.put("position", position);
                jsonObj.put("name", givenName + " " + familyName);
                jsonObj.put("race", race);
                jsonObj.put("points", points);
                jsonObj.put("url", url);
                jsonObj.put("nationality", nationality);
                jsonObj.put("raceUrl", raceUrl);

                rootArray.put(jsonObj);
            }
            return rootArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
