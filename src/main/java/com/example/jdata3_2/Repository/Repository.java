package com.example.jdata3_2.Repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String scriptName = "myScript.sql";

    public Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public String fetchByName(String name) {
        String sqlQuery = read(scriptName);
        SqlRowSet sqlRowSet = namedParameterJdbcTemplate.queryForRowSet(sqlQuery, Map.of("name", name));
        StringBuilder sb = new StringBuilder();

        while (sqlRowSet.next()) {
            sb.append(sqlRowSet.getString("product_name") + "\n");
        }

        return sb.toString();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
