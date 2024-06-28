
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter name");
        String name = in.next();
        System.out.println("enter id");
        String id = in.next();
        ProjectManager p = new ProjectManager(name,id);
        LoginRegister.registration(p);
//        System.out.println(LoginRegister.login(p));


    }
}

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        LoginRegister start = new LoginRegister();
//        ArrayList<Task> tasks = new ArrayList<Task>();
//
//        //here sql extraction
//        DataBase.loadTasksFromDatabase(tasks);
//
//        Scanner in = new Scanner(System.in);
//        System.out.println("Press 1 to Sign Up\nPress 2 to Log In");
//        int n = in.nextInt();
//
//        if (n == 1) {
//            System.out.println("===============================REGISTRATION=================================");
//
//            System.out.print("Enter Name                    : ");
//            String name = in.next();
//            System.out.print("Enter Id                      : ");
//            String id = in.next();
//            ProjectManager p = new ProjectManager(name,id);
//            start.registration(p);
//            start.login(p);
//            menu(start, tasks,name,id);
//
//        } else if (n == 2) {
//            Scanner input = new Scanner(System.in);
//            System.out.println("===================================LOGIN====================================");
//
//            System.out.print("Please enter the user name: ");
//            String name = input.next();
//
//            System.out.print("Please enter the password: ");
//            String id = input.next();
//            ProjectManager p = new ProjectManager(name,id);
//            start.login(p);
//            menu(start, tasks,name,id);
//        }
//    }
////    static void menu(LoginRegister start,  ArrayList<Task> tasks ,String PMName,String PMId){
////        Scanner in = new Scanner(System.in);
////        if (start.validLogin == true) {
////            while (true) {
////
////                System.out.println(
////                        "Welcome To Software Project Management System (Powered By Kanban Functionality)\n" +
////                                "-------Press 1 if you are Project Manager-------" + "\n" +
////                                "---------Press 2 if you are a developer---------" + "\n" +
////                                "-----------------Press 3 to exit-----------------"
////                );
////
////                int option = in.nextInt();
////                if (option == 1) {
////
////                    System.out.println(
////                            "Welcome To Software Project Management System (Powered By Kanban Functionality)\n" +
////                                    "-------Press 1 add project-------" + "\n" +
////                                    "-------Press 2 to display--------" + "\n" +
////                                    "----Press 3 to remove a task-----" + "\n" +
////                                    "----Press 4 to update a task-----" + "\n" +
////                                    "------Press 5 to add a task------" + "\n" +
////                                    "---Press 6 to remove a project---"
////                    );
////                    int P_option = in.nextInt();
////                    if (P_option == 1) {
////                        ProjectManager.ProjectManagerFunctionality(tasks,PMName,PMId);
////                    } else if (P_option == 2) {
////                        ProjectManager.ProjectManagerFunctionality02(tasks);
////                    } else if (P_option == 3) {
////                        ProjectManager.ProjectManagerFunctionality03(tasks);
////                    } else if (P_option == 4) {
////                        ProjectManager.ProjectManagerFunctionality04(tasks,PMName,PMId);
////                    } else if (P_option == 5) {
////                        ProjectManager.ProjectManagerFunctionality05(tasks,PMName,PMId);
////                    } else if (P_option == 6) {
////                        ProjectManager.ProjectManagerFunctionality06(tasks);
////                    }
////                } else if (option == 2) {
////                    Dev.DevelopersFunctionality(tasks);
////                } else if (option == 3) {
////
////                    //here sql insertion
////                    DataBase.saveTasksToDatabase(tasks);
////                    break;
////                }
////            }
////        } else {
////            System.out.println("User does not exist");
////        }
////    }
//static void menu(LoginRegister start,  ArrayList<Task> tasks ,String PMName,String PMId){
//    Scanner in = new Scanner(System.in);
//    if (start.validLogin == true) {
//        while (true) {
//
//            System.out.println(
//                    "Welcome To Software Project Management System (Powered By Kanban Functionality)\n" +
//                            "-------Press 1 if you are Project Manager-------" + "\n" +
//                            "---------Press 2 if you are a developer---------" + "\n" +
//                            "-----------------Press 3 to exit-----------------"
//            );
//
//            int option = in.nextInt();
//            if (option == 1) {
//
//                System.out.println(
//                        "Welcome To Software Project Management System (Powered By Kanban Functionality)\n" +
//                                "-------Press 2 to display--------" + "\n" +
//                                "----Press 3 to remove a task-----" + "\n" +
//                                "----Press 4 to update a task-----" + "\n" +
//                                "------Press 5 to add a task------" + "\n" +
//                                "---Press 6 to remove a project---"
//                );
//                int P_option = in.nextInt();
//
//                if (P_option == 1) {
////                    ProjectManager.ProjectManagerFunctionality(tasks,PMName,PMId);
//                } else if (P_option == 2) {
//                    ProjectManager.ProjectManagerFunctionality02(tasks);
//                } else if (P_option == 3) {
//                    ProjectManager.ProjectManagerFunctionality03(tasks);
//                } else if (P_option == 4) {
//                    System.out.print("Enter Project Name: ");
//                    String projectName=in.next();
//                    System.out.print("Enter column name for the task (Todo, Done, Stuck, InProgress): ");
//                    String column_name = in.next();     // Read the whole line
//                    System.out.print("Developer name: ");
//                    String dev_name = in.next();
//                    System.out.print("Developer ID  : ");
//                    String dev_id = in.next();
//                    System.out.print("Task name: ");
//                    String task_name = in.next();
//                    System.out.print("Priority: ");
//                    String priority = in.next();
//                    System.out.print("Task Description: ");
//                    String task_description = in.next();
//                    System.out.print("Dead Line\nYear: ");
//                    int year = in.nextInt();
//                    System.out.print("Month: ");
//                    int month = in.nextInt();
//                    System.out.print("Day: ");
//                    int day = in.nextInt();
//                    in.nextLine(); // Consume the newline character after reading day
//                    ProjectManager.ProjectManagerFunctionality04(projectName,column_name,dev_name,dev_id,task_name,priority,task_description,year,month,day,tasks,PMName,PMId);
//                } else if (P_option == 5) {
//                    System.out.print("Enter Project Name: ");
//                    String projectName=in.next();
//                    System.out.print("Enter column name for the task (Todo, Done, Stuck, InProgress): ");
//                    String column_name = in.next();     // Read the whole line
//                    System.out.print("Developer name: ");
//                    String dev_name = in.next();
//                    System.out.print("Developer ID  : ");
//                    String dev_id = in.next();
//                    System.out.print("Task name: ");
//                    String task_name = in.next();
//                    System.out.print("Priority: ");
//                    String priority = in.next();
//                    System.out.print("Task Description: ");
//                    String task_description = in.next();
//                    System.out.print("Dead Line\nYear: ");
//                    int year = in.nextInt();
//                    System.out.print("Month: ");
//                    int month = in.nextInt();
//                    System.out.print("Day: ");
//                    int day = in.nextInt();
//                    in.nextLine(); // Consume the newline character after reading day
//                    ProjectManager.ProjectManagerFunctionality05(projectName,column_name,dev_name,dev_id,task_name,priority,task_description,year,month,day,tasks,PMName,PMId);
//                } else if (P_option == 6) {
//                    ProjectManager.ProjectManagerFunctionality06(tasks);
//                }
//            } else if (option == 2) {
//                Dev.DevelopersFunctionality(tasks);
//            } else if (option == 3) {
//
//                //here sql insertion
//                DataBase.saveTasksToDatabase(tasks);
//                break;
//            }
//        }
//    } else {
//        System.out.println("User does not exist");
//    }
//}
//}

