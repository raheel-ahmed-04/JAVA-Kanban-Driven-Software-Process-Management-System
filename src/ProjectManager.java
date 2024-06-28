import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class ProjectManager extends User implements Serializable {
    String projectName;
    ProjectManager() {
        super();
    }
    ProjectManager(String a, String b,String c) {
        super(a, b);
        this.projectName=c;
    }
    ProjectManager(String a, String b) {
        super(a, b);
    }
    @Override
    public String toString(){
        return super.toString();
    }
    void setProjectName(String n){projectName=n;}
    String getProjectName(){return projectName;}


    public static void ProjectManagerFunctionality02(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (Task task : tasks) {
                Date.DeadlineReached(task);
                System.out.println(task);
            }
        }
    }
    public static boolean ProjectManagerFunctionality03(ArrayList<Task> tasks, String task_to_delete, String ProjName ) {
        // for removing task
        boolean TaskFound = false;

        if (!tasks.isEmpty()) {

            for (Task task : tasks) {
                if (task.getTask_name().equalsIgnoreCase(task_to_delete) && task.getProjectName().equalsIgnoreCase(ProjName)) {
                    tasks.remove(task);
                    TaskFound = true;
                    System.out.println("Task named '" + task_to_delete + "' has been deleted.");
                    break;  // Exit the loop once a matching student is found and removed.
                }
            }

        }
        return TaskFound;
    }
    public static void ProjectManagerFunctionality05(String projectName,String column_name,String dev_name,String dev_id,String task_name,String priority,String task_description,int year,int month,int day,ArrayList<Task> tasks,String PMName, String PMId) {
        // adding
        Date d = new Date(year, month, day);
        Dev dev=new Dev(dev_name,dev_id);
        ProjectManager p =new ProjectManager(PMName,PMId,projectName);
        if(Date.hasDatePassed(d)){
            column_name="Stuck";
            tasks.add(new Task(column_name,p, dev, task_name, priority, task_description, d));
        }else{tasks.add(new Task(column_name,p, dev, task_name, priority, task_description, d));}
    }
    public static boolean ProjectManagerFunctionality06(ArrayList<Task> tasks, String project_to_delete) {
        //remove project
        boolean isDeleted = false;

        if (!tasks.isEmpty()) {

            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getProjectName().equalsIgnoreCase(project_to_delete)) {
                    iterator.remove(); // Use iterator's remove method to avoid concurrent modification
                    isDeleted = true;
                }
            }

            System.out.println("Project named '" + project_to_delete + "' has been deleted.");

        } else {
            System.out.println("No Project to delete.");
        }
        return isDeleted;
    }

}