package com.formulaone.racing;

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
import spark.Spark;

import com.formulaone.racing.objects.FormulaOne;
import com.formulaone.racing.services.FormulaOneService;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class App {

    public static void main(String[] args) throws Exception {
		final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/");
        
        Spark.setPort(8080);
        
        Spark.staticFileLocation("/public");

        final FormulaOneService formulaOneService = new FormulaOneService();

        get(new Route("/") {

            @Override
            public Object handle(Request request, Response response) {
                try {

                    Map<String, Object> input = new HashMap<String, Object>();
                    List<FormulaOne> formulaOne = new ArrayList<FormulaOne>();

                    JSONArray jsonArray = formulaOneService.getFormulaOneRacingData();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        formulaOne.add(new FormulaOne(jsonObject.getInt("position"), jsonObject.getString("name"), jsonObject.getString("race"), jsonObject
                                .getInt("points"), jsonObject.getString("url"), jsonObject.getString("raceUrl"), jsonObject.getString("nationality")));
                    }
                    input.put("formulaones", formulaOne);

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
