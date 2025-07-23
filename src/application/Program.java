package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		String path = "./External/in.txt";
		Scanner sc = new Scanner(System.in);
		List<Employee> employeeList = new ArrayList<Employee>();
		
		System.out.print("Enter salary: ");
		double salaryLimit = sc.nextDouble();
		sc.nextLine();
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				String[] vector = line.split(",");
				
				Employee obj = new Employee(vector[0], vector[1], Double.parseDouble(vector[2]));
				employeeList.add(obj);
				
				//System.out.println(line);
				line = br.readLine();
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}
		

				
				
		System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryLimit) + ":");
		

		employeeList.stream()
		    .filter(x -> x.getSalary() > salaryLimit)
		    .map(Employee::getEmail)
		    .sorted()
		    .forEach(System.out::println);
		/*
		for(Employee e : employeeList) {
			if(e.getSalary() > salaryLimit) {
				System.out.println(e.getEmail());		
			}
		}
		*/
		
		double sum = employeeList.stream()
			    .filter(x -> x.getName().startsWith("M"))
			    .mapToDouble(Employee::getSalary)
			    .sum();
		
		System.out.println("Sum of salary of people whose name start with 'M': " + String.format("%.2f", sum));
		

		



		

	}

}
