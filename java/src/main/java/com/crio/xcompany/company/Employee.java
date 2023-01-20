package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
// import java.util.Map;
public class Employee {
    private String name;
    private Gender gender;

    public Employee(String name, Gender gender) {
        this.name=name;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // 
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // This will ensure that the project can be compiled successfully.
    public void assignManager(Employee employee){

    }    
    public List<Employee> getDirectReports(){
        List<Employee>res=new ArrayList<>();
        return res;
    }
    public List<Employee>getTeamMates(){
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }   
}





// public class Employee {
//     private String name;
//     private Gender gender;
//     // private Map<String,Employee> employeeManager;
//     // private Map<Employee,List<Employee>> managerList;
//     public Employee(String name, Gender gender) {
//         this.name=name;
//         this.gender=gender;
//     }

//     public String getName() {
//         return name;
//     }

//     public Gender getGender() {
//         return gender;
//     }
//     // public void assignManager(Employee employee){
//     //     // employeeManager.put(this.name,employee);
//     //     managerList.get(this).add(employee);
//     //     employeeManager.put(employee.name,this);
//     // }
//     // public List<Employee> getDirectReports(){
//     //     return managerList.get(this);
//     // }
//     // public List<Employee> getTeamMates(){
//     //     String managerName= employeeManager.get(this.name).name;
//     //     List<Employee> teamMates= new ArrayList<>(); 
//     //     teamMates= managerList.get(employeeManager.get(this.name));
//     //     teamMates.add(0,employeeManager.get(this.name));
//     //     return teamMates;

//         // managerList.get(managerName).add(employeeManager.get(this.name));
//         public void assignManager(Employee employee){

//         }    
//         public List<Employee> getDirectReports(){
//             List<Employee>res=new ArrayList<>();
//             return res;
//         }
//         public List<Employee> getTeamMates(){
//             return new ArrayList<>();
//         }



    

//     // TODO: CRIO_TASK_MODULE_XCOMPANY
//     // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
//     // This will ensure that the project can be compiled successfully.


//     @Override
//     public String toString() {
//         return "Employee [name=" + name + ", gender=" + gender + "]";
//     }   
// }
