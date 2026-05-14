package exercicio_entities;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    // tem que fazer as assosiações agora
    private Department department;
   // como um trabalhador tem varios contratos eu represento por uma lista
    private List<HourContract> contracts = new ArrayList<>();
    public Worker(){
    }
    public Worker(String name, WorkerLevel level, Department department, Double baseSalary) {
        this.name = name;
        this.level = level;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }
    public double income(int year, int month) {
        double sum = baseSalary;
        for (HourContract c : contracts ){
            int c_year = c.getDate().getYear();
            int c_month = c.getDate().getMonthValue();
            if(year == c_year && month == c_month){
            sum += c.totalValue();
        }
        }
        return sum;
    }
}