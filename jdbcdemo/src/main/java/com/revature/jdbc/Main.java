package com.revature.jdbc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. View All Employees");
            System.out.println("2. View Employee by ID");
            System.out.println("3. Insert Employee");
            System.out.println("4. Update Designation");
            System.out.println("5. Delete Employee");
            System.out.println("6. Total Employee Count");
            System.out.println("7. Employee Count by Department");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        Display.display();
                        break;

                    case 2:{
                        System.out.print("Enter emp_id: ");
                        int id = sc.nextInt();
                        Based_on_id.id(id);
                    }
                    break;
                    case 3:{
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Dept: ");
                        String dept = sc.nextLine();
                        System.out.print("Designation: ");
                        String desig = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        Insert.insert(name, dept, desig, email, salary);
                    }
                    break;
                    case 4:{
                        System.out.print("Enter emp_id: ");
                        int eid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new designation: ");
                        String newDesig = sc.nextLine();
                        Update.update(eid, newDesig);
                    }
                    break;
                    case 5:{
                        System.out.print("Enter emp_id to delete: ");
                        int did = sc.nextInt();
                        delete.Delete(did);
                    }
                    case 6:
                        displaytotal.count();
                        break;
                    case 7:{
                        System.out.print("Enter dept name: ");
                        String deptName = sc.nextLine();
                        displaydept.countByDept(deptName);
                    }
                    break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }
}
