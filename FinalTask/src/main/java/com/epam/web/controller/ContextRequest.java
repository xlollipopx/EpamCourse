package com.epam.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

 class SessionRequestContent {

    private Map<String, Object> reqAttributes;
    private Map<String, String[]> reqParameters;
    private Map<String, Object> sessionAttributes;

    public SessionRequestContent(HttpServletRequest req) {
        sessionAttributes = new HashMap<>();
        reqAttributes = new HashMap<>();
        try {
            reqParameters = req.getParameterMap();
            Enumeration<String> reqAttributeNames = req.getAttributeNames();
            while (reqAttributeNames.hasMoreElements()) {
                String attributeName = reqAttributeNames.nextElement();
                reqAttributes.put(attributeName, req.getAttribute(attributeName));
            }
            HttpSession currentSession = req.getSession(false);
            if (currentSession != null) {
                Enumeration<String> sessionAttributeNames = currentSession.getAttributeNames();
                while (sessionAttributeNames.hasMoreElements()) {
                    String attributeName = sessionAttributeNames.nextElement();
                    sessionAttributes.put(attributeName, currentSession.getAttribute(attributeName));
                }
            }
        } catch (NullPointerException ignored) {
        }
    }

    public boolean checkRequestAttribute(String attrName) {
        return reqAttributes.containsKey(attrName);
    }

    public boolean checkRequestParameter(String attrName) {
        return reqParameters.containsKey(attrName);
    }

    public boolean checkSessionAttribute(String attrName) {
        return sessionAttributes.containsKey(attrName);
    }

    public Object getRequestAttribute(String key) {
        return reqAttributes.get(key);
    }

    public Map<String, Object> getRequestAttributes() {
        return reqAttributes;
    }

    public String[] getRequestParameter(String key) {
        return reqParameters.get(key);
    }

    public Map<String, String[]> getRequestParameters() {
        return reqParameters;
    }

    public Object getSessionAttribute(String key) {
        return sessionAttributes.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = reqAttributes.keySet();
        for (String key : keys) {
            sb.append("\nRequest attribute: key = ").append(key).append(" value = ").append(getRequestAttribute(key));
        }
        keys = reqParameters.keySet();
        for (String key : keys) {
            sb.append("\nRequest parameter: key = ").append(key).append(" value = ").append(getRequestParameter(key)[0]);
        }
        keys = sessionAttributes.keySet();
        for (String key : keys) {
            sb.append("\nSession attribute: key = ").append(key).append(" value = ").append(getSessionAttribute(key));
        }
        return sb.toString();
    }
}