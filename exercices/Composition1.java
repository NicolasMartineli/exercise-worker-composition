package exercices;

import exercicio_entities.Department;
import exercicio_entities.HourContract;
import exercicio_entities.Worker;
import exercicio_entities.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Composition1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MM/yyyy");
        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter the worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel.toUpperCase()), new Department(departmentName), baseSalary);
        System.out.print("How many contracts to this worker ?");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
        System.out.println("Enter contract " + "#" + i + " data: ");
        System.out.print("Date (DD/MM/YYYY): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), fmt); //.parse é para converter, ele pega oq foi escrito e converte para o molde fmt igual informado
        System.out.print("Value per hour: ");
        double valuePerHour = sc.nextDouble();
        System.out.print("Duration (hours): ");
        int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        YearMonth monthAndYear = YearMonth.parse(sc.next(), fmt1);
        int month = monthAndYear.getMonthValue();
        int year = monthAndYear.getYear();
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + fmt1.format(monthAndYear) + ": " + String.format("%.2f", worker.income(year, month)));
    }
}