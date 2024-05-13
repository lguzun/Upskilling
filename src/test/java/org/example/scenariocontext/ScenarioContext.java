package org.example.scenariocontext;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, String> context;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    //TODO String value -> Object value from Study Materails, to read Generics

    public void setContext(String key, String value) {
        context.put(key, value);
       // System.out.println("SetContext  ....... key: "+ key + " and value: " + value);
    }

    public String getContext(String key) {
       // System.out.println("GetContext  ....... key " + key);
        return context.get(key);
    }
}
