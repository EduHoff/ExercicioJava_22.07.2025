package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
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
		
		for(Employee e : employeeList) {
			System.out.println(e.getName());
		}

	}

}
