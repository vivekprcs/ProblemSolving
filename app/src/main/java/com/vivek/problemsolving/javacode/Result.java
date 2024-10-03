package com.vivek.problemsolving.javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class Result {

    public static List<String> getResponses(List<String> valid_auth_tokens,
                                            List<List<String>>requests){
        List<String> responses = new ArrayList<>();
        for (List<String> request : requests) {
            String requestType = request.get(0);
            String url = request.get(1);

            // Extract token and parameters from URL
            String token = extractToken(url);
            HashMap<String, String> params = parseParameters(url);

            String response = validateRequest(valid_auth_tokens, requestType, token, params);
            responses.add(response);
        }

        return responses;
    }

    private static String extractToken(String url) {
        int tokenStartIndex = url.indexOf("token=") + 6; // Skip "token="
        int tokenEndIndex = url.indexOf("&", tokenStartIndex); // Find next "&"
        if (tokenEndIndex == -1) {
            tokenEndIndex = url.length(); // If no "&" found, use entire remaining string
        }
        return url.substring(tokenStartIndex, tokenEndIndex);
    }

    private static HashMap<String, String> parseParameters(String url) {
        HashMap<String, String> params = new HashMap<>();
        int paramsStartIndex = url.indexOf("?") + 1; // Skip "?"
        String[] paramPairs = url.substring(paramsStartIndex).split("&");
        for (String paramPair : paramPairs) {
            String[] keyValue = paramPair.split("=");
            if (keyValue.length == 2) {
                params.put(keyValue[0], keyValue[1]);
            }
        }
        return params;

    }


    private static String validateRequest(List<String> validAuthTokens, String requestType, String token, HashMap<String, String> params) {
        if (!validAuthTokens.contains(token)) {
            return "INVALID";
        }

        if (requestType.equals("POST")) {
            String csrfToken = params.get("csrf");
            if (csrfToken == null || !isAlphanumeric(csrfToken) || csrfToken.length() < 8) {
                return "INVALID";
            }
        }

        StringBuilder response = new StringBuilder("VALID");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!entry.getKey().equals("token")) { // Exclude token
                response.append(",").append(entry.getKey()).append(",").append(entry.getValue());
            }
        }
        return response.toString();
    }

    private static boolean isAlphanumeric(String csrfToken) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        return pattern.matcher(csrfToken).matches();
    }

    public static void main(String[] args){
        List<String> validAuthTokens = Arrays.asList("et51u8i9p1q7", "b8nn5j4om76v", "r5b0191m1p09");
        List<List<String>> requests = Arrays.asList(
                Arrays.asList("GET", "https://example.com/?token=et51u8i9p1q7&id=2e3rt&name=alex"),
                Arrays.asList("POST", "https://example.com/?token=r5b0191mlp09&csrf=ia+09&id=u78we&name=evan")
        );

        List<String> responses = getResponses(validAuthTokens, requests);

        for (String response : responses) {
            System.out.println(response);
        }
    }
}
