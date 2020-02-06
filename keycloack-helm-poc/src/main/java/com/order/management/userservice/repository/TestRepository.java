package com.order.management.userservice.repository;

import com.order.management.userservice.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TestRepository {
    private static Map<String, Test> Tests = new ConcurrentHashMap<>();

    static {
        Tests.put("B01", new Test("B01", "Harry Potter and the Deathly Hallows", "J.K. Rowling"));
        Tests.put("B02", new Test("B02", "The Lord of the Rings", "J.R.R. Tolkien"));
        Tests.put("B03", new Test("B03", "War and Peace", "Leo Tolstoy"));
    }

    public List<Test> readAll() {
        List<Test> allTests = new ArrayList<>(Tests.values());
        allTests.sort(Comparator.comparing(Test::getId));
        return allTests;
    }

}
