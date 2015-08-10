package com.motor.racing;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.motor.racing.services.ErgastService;

import spark.Request;
import spark.Response;
import spark.Route;
import freemarker.template.Configuration;
import freemarker.template.Template;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App
{
	
	public static void main( String[] args ) throws Exception
    {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/");
        
        ErgastService ergastService = new ErgastService();
        
        final String result = ergastService.getDriverChampionship();
        
        get(new Route("/") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
				try {
					Template indexTemplate = configuration.getTemplate("index.ftl");
					Map<String, Object> indexMap = new HashMap<String, Object>();
					indexMap.put("result", result);
					StringWriter writer  = new StringWriter();
					
					indexTemplate.process(indexMap, writer);
					
					return writer;
					
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
    }
}
