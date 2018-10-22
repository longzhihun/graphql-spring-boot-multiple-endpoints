package com.example.DemoGraphQL.controller;

import com.example.DemoGraphQL.util.GraphQLUtil;
import graphql.ExecutionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookController {

    @Autowired
    private GraphQLUtil graphQLUtil;

    @PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String query){
        ExecutionResult result = graphQLUtil.getGraphQL().execute(GraphQLUtil.getQueryString(query));
        return ResponseEntity.ok(result.getData());
    }

}
