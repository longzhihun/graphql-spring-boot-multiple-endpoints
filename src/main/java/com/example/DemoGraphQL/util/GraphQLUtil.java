package com.example.DemoGraphQL.util;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static graphql.GraphQL.newGraphQL;

@Component
public class GraphQLUtil {

    private static volatile GraphQL graphQL;

    @Autowired
    private GraphQLSchema schema;

    public GraphQL getGraphQL() {
        if (graphQL == null) {
            graphQL = newGraphQL(schema).build();
        }
        return graphQL;
    }

    public static String getQueryString(String input) {
        JSONObject requestQuery = null;
        try {
            requestQuery = new JSONObject(input);
            return requestQuery.getString("query");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
