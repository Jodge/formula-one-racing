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

/**
 * @author George Otieno
 *
 */
public class App {
	
	private static final int SERVER_PORT = 8080;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/");
        
        Spark.setPort(SERVER_PORT);
        
        Spark.staticFileLocation("/public");
        
        get(new Route("/") {

            @Override
            public Object handle(Request request, Response response) {
                try {      

                    Template indexTemplate = configuration.getTemplate("index.ftl");
                    StringWriter writer = new StringWriter();
                    indexTemplate.process(null, writer);

                    return writer;

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
        
        get(new Route("/:year") {

            @Override
            public Object handle(Request request, Response response) {
                try {

                    Map<String, Object> input = new HashMap<String, Object>();
                    List<FormulaOne> formulaOne = new ArrayList<FormulaOne>();                    
                    
                    
                    String year = request.params(":year");
                    final FormulaOneService formulaOneService = new FormulaOneService(year);

                    JSONArray jsonArray = formulaOneService.getFormulaOneRacingData();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        formulaOne.add(new FormulaOne(jsonObject.getInt("position"), jsonObject.getString("name"), jsonObject.getString("race"), jsonObject
                                .getInt("points"), jsonObject.getString("url"), jsonObject.getString("raceUrl"), jsonObject.getString("nationality")));
                    }
                    input.put("formulaones", formulaOne);
                    input.put("year", year);

                    Template yearTemplate = configuration.getTemplate("year.ftl");
                    StringWriter writer = new StringWriter();
                    yearTemplate.process(input, writer);

                    return writer;

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }
}
