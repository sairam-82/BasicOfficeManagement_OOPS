package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.*;

public class Company {
    private String companyName;
    private Employee founder;
    private Map<String, Employee> employeeBook;
    private Map<Employee, List<Employee>> orgStructure;


    private Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String, Employee>();
        employeeBook.put(founder.getName(), founder);
        orgStructure = new HashMap<Employee, List<Employee>>();
        orgStructure.put(founder, new ArrayList<>());
    }


    public static Company create(String companyName, Employee founder) {
        return new Company(companyName, founder);
    }


    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone
    // for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.
    public void registerEmployee(String employeeName, Gender gender) {
        Employee emp = new Employee(employeeName, gender);
        employeeBook.put(employeeName, emp);
        orgStructure.put(emp, new ArrayList<>());

    }

    public Employee getEmployee(String employeeName) {
        return employeeBook.get(employeeName);
    }

    public void deleteEmployee(String employeeName) {
        if (employeeBook.containsKey(employeeName)) {
            Employee emp = employeeBook.get(employeeName);
            employeeBook.remove(employeeName);
            orgStructure.remove(emp);
        }
    }

    public void assignManager(String employeeName, String managerName) {
        Employee manager = employeeBook.get(managerName);
        Employee reportee = employeeBook.get(employeeName);
        orgStructure.get(manager).add(reportee);
    }

    public List<Employee> getDirectReports(String managerName) {

        return orgStructure.get(employeeBook.get(managerName));
    }

    private Employee findManager(String employeeName) {
        Employee emp = employeeBook.get(employeeName);
        for (Employee man : orgStructure.keySet()) {
            List<Employee> directReports = orgStructure.get(man);
            if (directReports.contains(emp))
                return man;
        }
        return emp;
    }

    public List<Employee> getTeamMates(String employeeName) {
        Employee emp = employeeBook.get(employeeName);
        List<Employee> teamMateList=new ArrayList<>();
        Employee man = findManager(employeeName);
        // teamMateList.add(0,findManager(employeeName));
        if (man != emp) {
            teamMateList.add(man);
            for(Employee directReEmployee:orgStructure.get(man)){
                    teamMateList.add(directReEmployee);
            }
        }
        for(Employee empREmployee:orgStructure.get(emp)){
            teamMateList.add(empREmployee);
        }
        
         
       
        return teamMateList;
    }

    public List<List<Employee>> getEmployeeHierarchy(String managerName) {

        List<List<Employee>> hierarchyList = new ArrayList<>();
        Employee man = employeeBook.get(managerName);
        Queue<Employee> qu = new LinkedList<>();
        qu.add(man);
        while (qu.size() > 0) {
            int sz = qu.size();
            List<Employee> eList = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                Employee rem = qu.remove();
                eList.add(rem);
                List<Employee> rEmployees = orgStructure.get(rem);
                if (rEmployees.size() > 0) {
                    for (Employee rEmployee:rEmployees) {
                        qu.add(rEmployee);
                    }
                }
            }
            hierarchyList.add(eList);
        }
        return hierarchyList;
    }

}
// public class Company{
//     private String companyName;
//     private Employee founder;
//     private Map<String,Employee> employeeBook;
//     private Map<Employee, List<Employee>> orgStructure;
//     // private Map<Employee,Employee> empManager;
//     private Employee emp;
//     // private Map<Employee, Employee> employeeManager;
//     // private 
//     private Company(String companyName, Employee founder) {
//         this.companyName = companyName;
//         this.founder = founder;
//         employeeBook = new HashMap<String,Employee>();
//         employeeBook.put(founder.getName(), founder);
//     }
    

//     public static Company create(String companyName, Employee founder){
//         return new Company(companyName,founder);
//     } 


//     public String getCompanyName() {
//         return companyName;
//     }

//     // public void registerEmployee(String employeeName, Gender gender){
//     //     this.emp= new Employee(employeeName,gender);
//     //     employeeBook.put(employeeName,emp);
//     // }

//     // public Employee getEmployee(String employeeName){
//     //     if (employeeBook.containsKey(employeeName))
//     //         return employeeBook.get(employeeName);
//     //     return new Employee("EMPLOYEE_NOT_FOUND",Gender.MALE);
//     // }
//     // public void deleteEmployee(String employeeName){
//     //     employeeBook.remove(employeeName);
//     // }
//     // public void assignManager(String employeeName, String managerName){
//     //         employeeManager.put(employeeBook.get(employeeName),employeeBook.get(managerName));
//     //         employeeBook.get(managerName).assignManager(employeeBook.get(employeeName));
//     // }
//     // public List<Employee> getDirectReports(String managerName){
//     //     return employeeBook.get(managerName).getDirectReports();
//     // }

//     // public List<Employee> getTeamMates(String employeeName){
//     //     return employeeBook.get(employeeName).getTeamMates();
//     // }

//     // public List<List<Employee>> getEmployeeHierarchy(String managerName){
//     //     List<List<Employee>> hierarchyList= new ArrayList<>();
//     //     List<Employee> individualList = new ArrayList<>();
//     //     Queue<Employee> q= new LinkedList<>();
//     //     q.add(employeeBook.get(managerName));
//     //     while (!q.isEmpty()){
//     //         // Employee dummy= q.poll();
//     //         // hierarchyList.add(dummy);
//     //         // List directPoints= getDirectReports(dummy.getName());
//     //         // int l= directPoints.size();
//     //         int l=q.size();
//     //         while (l>0){
//     //             Employee e= q.poll();
//     //             individualList.add(e);
//     //             List<Employee> directPoints= getDirectReports(e.getName());
//     //             q.addAll(directPoints);
//     //         }
//     //         hierarchyList.add(individualList);
//     //         individualList.clear();
            
//     //     }
//     //     return hierarchyList;
//     public void registerEmployee(String employeeName, Gender gender) {
//         Employee emp = new Employee(employeeName, gender);
//         employeeBook.put(employeeName, emp);
//         orgStructure.put(emp, new ArrayList<>());

//     }

//     public Employee getEmployee(String employeeName) {
//         return employeeBook.get(employeeName);
//     }

//     public void deleteEmployee(String employeeName) {
//         if (employeeBook.containsKey(employeeName)) {
//             Employee emp = employeeBook.get(employeeName);
//             employeeBook.remove(employeeName);
//             orgStructure.remove(emp);
//         }
//     }

//     public void assignManager(String employeeName, String managerName) {
//         Employee manager = employeeBook.get(managerName);
//         Employee reportee = employeeBook.get(employeeName);
//         orgStructure.get(manager).add(reportee);
//     }

//     public List<Employee> getDirectReports(String managerName) {

//         return orgStructure.get(employeeBook.get(managerName));
//     }

//     private Employee findManager(String employeeName) {
//         Employee emp = employeeBook.get(employeeName);
//         for (Employee man : orgStructure.keySet()) {
//             List<Employee> directReports = orgStructure.get(man);
//             if (directReports.contains(emp))
//                 return man;
//         }
//         return emp;
//     }

//     public List<Employee> getTeamMates(String employeeName) {
//         Employee emp = employeeBook.get(employeeName);
//         List<Employee> teamMateList=new ArrayList<>();
//         Employee man = findManager(employeeName);
//         // teamMateList.add(0,findManager(employeeName));
//         if (man != emp) {
//             teamMateList.add(man);
//             for(Employee directReEmployee:orgStructure.get(man)){
//                     teamMateList.add(directReEmployee);
//             }
//         }
//         for(Employee empREmployee:orgStructure.get(emp)){
//             teamMateList.add(empREmployee);
//         }
        
         
       
//         return teamMateList;
//     }

//     public List<List<Employee>> getEmployeeHierarchy(String managerName) {

//         List<List<Employee>> hierarchyList = new ArrayList<>();
//         Employee man = employeeBook.get(managerName);
//         Queue<Employee> qu = new LinkedList<>();
//         qu.add(man);
//         while (qu.size() > 0) {
//             int sz = qu.size();
//             List<Employee> eList = new ArrayList<>();
//             for (int i = 0; i < sz; i++) {
//                 Employee rem = qu.remove();
//                 eList.add(rem);
//                 List<Employee> rEmployees = orgStructure.get(rem);
//                 if (rEmployees.size() > 0) {
//                     for (Employee rEmployee:rEmployees) {
//                         qu.add(rEmployee);
//                     }
//                 }
//             }
//             hierarchyList.add(eList);
//         }
//         return hierarchyList;
//     }

//     // }



//     // TODO: CRIO_TASK_MODULE_XCOMPANY
//     // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone for each functionality before implementing the logic.
//     // This will ensure that the project can be compiled successfully.

// }
