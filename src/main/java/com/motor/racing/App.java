package com.motor.racing;

import static spark.Spark.get;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

import com.motor.racing.objects.MotoRacing;
import com.motor.racing.services.ErgastService;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class App {

    public static void main(String[] args) throws Exception {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/");

        final ErgastService ergastService = new ErgastService();

        get(new Route("/") {

            @Override
            public Object handle(Request arg0, Response arg1) {
                try {

                    Map<String, Object> input = new HashMap<String, Object>();
                    List<MotoRacing> motoRacing = new ArrayList<MotoRacing>();

                    JSONArray jsonArray = ergastService.getErgastMotoRacingData();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        motoRacing.add(new MotoRacing(jsonObject.getInt("position"), jsonObject.getString("name"), jsonObject.getString("array"), jsonObject
                                .getInt("points"), jsonObject.getString("url"), jsonObject.getString("raceUrl"), jsonObject.getString("nationality")));
                    }
                    input.put("motors", motoRacing);

                    Template indexTemplate = configuration.getTemplate("index.ftl");
                    StringWriter writer = new StringWriter();
                    indexTemplate.process(input, writer);

                    return writer;

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }
}
