package com.kevin.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q690 {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    static class Solution {
        Map<Integer, Employee> employeeMap;
        int sum = 0;

        public int getImportance(List<Employee> employees, int id) {
            employeeMap = new HashMap<>(employees.size());
            for (Employee employee : employees) {
                employeeMap.put(employee.id, employee);
            }
            find(employeeMap.get(id));
            return sum;
        }

        private void find(Employee employee) {
            sum += employee.importance;
            for (int i : employee.subordinates) {
                find(employeeMap.get(i));
            }
        }
    }
}
