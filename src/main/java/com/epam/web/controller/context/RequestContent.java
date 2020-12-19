package com.epam.web.controller.context;

import java.util.Map;

public class RequestContent {

    private Map<String, Object> requestAttribute;
    private Map<String, String> requestParameters;
    private Map<String, Object> sessionAttributes;

    public RequestContent(Map<String, Object> requestAttribute, Map<String, String> requestParameters, Map<String, Object> sessionAttributes) {
        this.requestAttribute = requestAttribute;
        this.requestParameters = requestParameters;
        this.sessionAttributes = sessionAttributes;
    }

    public Map<String, Object> getRequestAttribute() {
        return requestAttribute;
    }

    public Map<String, String> getRequestParameters() {
        return requestParameters;
    }

    public Map<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }


    public Object getRequestAttribute(String key) {
        return requestAttribute.get(key);
    }

    public String getRequestParameters(String key) {
        return requestParameters.get(key);
    }

    public Object getSessionAttributes(String key) {
        return sessionAttributes.get(key);
    }

    public void setRequestAttribute(String key, Object value) {
        requestAttribute.put(key, value);
    }

    public void setRequestParameters(String key, String value) {
        requestParameters.put(key, value);
    }

    public void setSessionAttributes(String key, Object value) {
        sessionAttributes.put(key, value);
    }
}
