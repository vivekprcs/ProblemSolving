package com.vivek.problemsolving.javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParser {


    public static List<String> getResponses(List<String> valid_auth_tokens, List<List<String>> requests) {
        List<String> validResponses = new ArrayList<>();

        for (List<String> request : requests) {
            String method = request.get(0);
            String url = request.get(1);
            Map<String, String> params = parseParams(url);

            String token = params.getOrDefault("token", "");
            String csrf = params.get("csrf");

            if (!valid_auth_tokens.contains(token)) {
                validResponses.add("INVALID");
                continue;
            }

            if (method.equals("POST")) {
                if (csrf == null || !csrf.matches("^[a-z0-9]{8,}$")) {
                    validResponses.add("INVALID");
                    continue;
                }
            }

            StringBuilder response = new StringBuilder("VALID");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (!entry.getKey().equals("token") && !entry.getKey().equals("csrf")) {
                    response.append(",").append(entry.getKey()).append(",").append(entry.getValue());
                }
            }
            validResponses.add(response.toString());
        }

        return validResponses;
    }

    private static Map<String, String> parseParams(String url) {
        String query = url.substring(url.indexOf("?") + 1);
        String[] pairs = query.split("&");
        Map<String, String> params = new HashMap<>();

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length > 1) {
                params.put(keyValue[0], keyValue[1]);
            }
        }
        return params;
    }


    public static void main(String[] args) {
        List<String> validAuthTokens = Arrays.asList("et51u8i9p1q7", "b8nn5j4om76v", "r5b0191m1p09");
        List<List<String>> requests = Arrays.asList(
                Arrays.asList("GET", "https://example.com/?token=et51u8i9p1q7&id=2e3rt&name=alex"),
                Arrays.asList("POST", "https://example.com/?token=r5b0191m1p09&csrf=ia+09&id=u78we&name=evan")
        );
        List<String> responses = getResponses(validAuthTokens, requests);
        for (String response : responses) {
            System.out.println(response);
        }
    }

}
