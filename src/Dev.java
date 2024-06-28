import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Dev extends User {
    Dev() {
        super();
    }



    Dev(String a, String b) {
        super(a, b);
    }

    public static Task DevelopersFunctionality_getTaskofDev(ArrayList<Task> tasks, String Dev_name, String Dev_ID) {

        Task TaskToKeep = null;

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getDev_name().equalsIgnoreCase(Dev_name) && task.getDevID().equalsIgnoreCase(Dev_ID)) {

                    Date.DeadlineReached(task);
                    TaskToKeep = task;
                }
            }
        }
        return TaskToKeep;
    }
    public static boolean DevelopersFunctionality_checkTaskofDev(ArrayList<Task> tasks, String Dev_name, String Dev_ID) {

        boolean TaskFound = false;

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getDev_name().equalsIgnoreCase(Dev_name) && task.getDevID().equalsIgnoreCase(Dev_ID)) {
                    TaskFound = true;
                    Date.DeadlineReached(task);
                }
            }
        }
        return TaskFound;
    }


    public static void DevelopersFunctionality_updateStatusofDev(ArrayList<Task> tasks, Task updatedTask) {

        //doing with iterator because of ConcurrentModificationException (you cannot not delete an elements from the array while iterating over it)

        if (!tasks.isEmpty()) {
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getDev_name().equalsIgnoreCase(updatedTask.getDev_name()) && task.getDevID().equalsIgnoreCase(updatedTask.getDevID())) {
                    iterator.remove(); // Use iterator's remove method to avoid concurrent modification
                    tasks.add(updatedTask);
                    break; // Assuming you want to stop after updating the first matching task
                }
            }
        }

    }


//    public static void main(String[] args) {
//        ArrayList<Task> tasks = new ArrayList<Task>();
//        DataBase.loadTasksFromDatabase(tasks);
//        System.out.println(DevelopersFunctionality_getTaskofDev(tasks, "Raheel", "1"));
//    }
}


