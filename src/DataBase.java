import java.sql.*;
import java.util.ArrayList;
public class DataBase {
    private static final String DATABASE_URL = "jdbc:sqlite:tasks1.db";

    public static void loadTasksFromDatabase(ArrayList<Task> tasks) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            // Creating the Students table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Tasks ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ColumnName TEXT,"
                    + "DeveloperName TEXT,"
                    + "DeveloperID TEXT,"
                    + "ProjectManager TEXT,"
                    + "ProjectManagerID TEXT,"
                    + "ProjectName TEXT,"
                    + "TaskName TEXT,"
                    + "Priority TEXT,"
                    + "TaskDescription TEXT,"
                    + "Deadline TEXT)";
            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery)) {
                createTableStatement.executeUpdate();
            }

            // Loading data from the database
            String loadDataQuery = "SELECT * FROM Tasks";
            try (PreparedStatement ps = connection.prepareStatement(loadDataQuery)) {
                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String column_name = resultSet.getString("ColumnName");
                    String developer_name = resultSet.getString("DeveloperName");
                    String developer_ID = resultSet.getString("DeveloperID");
                    String projectManager = resultSet.getString("ProjectManager");
                    String projectManagerID = resultSet.getString("ProjectManagerID");
                    String projectName = resultSet.getString("ProjectName");
                    String task_name = resultSet.getString("TaskName");
                    String priority = resultSet.getString("Priority");
                    String task_description = resultSet.getString("TaskDescription");
                    String deadline = resultSet.getString("Deadline");

                    //for date
                    String[] parts = deadline.split("-");
                    int year = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[2]);

                    //adding the data
                    Date d = new Date(year, month, day);
                    Dev dev=new Dev(developer_name, developer_ID);
                    ProjectManager p =new ProjectManager(projectManager, projectManagerID, projectName);

                    //adding to arrayList
                    tasks.add(new Task(column_name,p, dev, task_name, priority, task_description, d));

                }
                System.out.println("Successfully Loaded from Database!");
                String deleteOldDataQuery = "DELETE FROM Tasks";
                try (PreparedStatement ps2 = connection.prepareStatement(deleteOldDataQuery)) {
                    ps2.executeUpdate();
                }
                // Resetting auto-increment counter
                String resetAutoIncrementQuery = "DELETE FROM sqlite_sequence WHERE name='Tasks'";
                try (PreparedStatement ps2 = connection.prepareStatement(resetAutoIncrementQuery)) {
                    ps2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveTasksToDatabase(ArrayList<Task> tasks) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {


            // Inserting data into the Tasks table
            String insertDataQuery = "INSERT INTO Tasks (ColumnName, DeveloperName, DeveloperID, " +
                    "ProjectManager, ProjectManagerID, ProjectName, TaskName, Priority, TaskDescription, Deadline) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(insertDataQuery)) {
                for (Task task : tasks) {
                    ps.setString(1, task.getColumn_name());
                    ps.setString(2, task.getDev_name());
                    ps.setString(3, task.getDevID());
                    ps.setString(4, task.getProjectManagerName());
                    ps.setString(5, task.getProjectManagerID());
                    ps.setString(6, task.getProjectName());
                    ps.setString(7, task.getTask_name());
                    ps.setString(8, task.getPriority());
                    ps.setString(9, task.getTask_description());

                    // Convert the Date to a String in the format "yyyy-MM-dd"
                    ps.setString(10, task.getDateInString());

                    ps.executeUpdate();
                }
                System.out.println("DataBase Updated!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void loadTasksforaProjectMgr(ArrayList<Task> tasks, String ProjManName) {

        //this will be taken from parameter

        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            // Loading data from the database
            String loadPMDataQuery = "SELECT * FROM Tasks WHERE ProjectManager = '" + ProjManName +"';";
            try (PreparedStatement ps = connection.prepareStatement(loadPMDataQuery)) {
                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String column_name = resultSet.getString("ColumnName");
                    String developer_name = resultSet.getString("DeveloperName");
                    String developer_ID = resultSet.getString("DeveloperID");
                    String projectManager = resultSet.getString("ProjectManager");
                    String projectManagerID = resultSet.getString("ProjectManagerID");
                    String projectName = resultSet.getString("ProjectName");
                    String task_name = resultSet.getString("TaskName");
                    String priority = resultSet.getString("Priority");
                    String task_description = resultSet.getString("TaskDescription");
                    String deadline = resultSet.getString("Deadline");

                    //for date
                    String[] parts = deadline.split("-");
                    int year = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[2]);

                    //adding the data
                    Date d = new Date(year, month, day);
                    Dev dev = new Dev(developer_name, developer_ID);
                    ProjectManager p = new ProjectManager(projectManager, projectManagerID, projectName);

                    //adding to arrayList
                    tasks.add(new Task(column_name, p, dev, task_name, priority, task_description, d));

                }
                System.out.println("Successfully Loaded from Database!");

            }
            String deleteTasksQuery = "DELETE FROM Tasks WHERE ProjectManager = ?";
            try (PreparedStatement ps = connection.prepareStatement(deleteTasksQuery)) {
                ps.setString(1, ProjManName);
                ps.executeUpdate();
            }

        }catch (SQLException e) {
                System.out.println(e.getMessage());
        }
    }
    public static void saveTasksforaProjectMgr(ArrayList<Task> tasks, String ProjManName){

        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {


            // Insert new tasks into the database
            String insertTaskQuery = "INSERT INTO Tasks (ColumnName, DeveloperName, DeveloperID, ProjectManager," +
                    " ProjectManagerID, ProjectName, TaskName, Priority, TaskDescription, Deadline) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(insertTaskQuery)) {
                for (Task task : tasks) {

                    ps.setString(1, task.getColumn_name());
                    ps.setString(2, task.getDev_name());
                    ps.setString(3, task.getDevID());
                    ps.setString(4, task.getProjectManagerName());
                    ps.setString(5, task.getProjectManagerID());
                    ps.setString(6, task.getProjectName());
                    ps.setString(7, task.getTask_name());
                    ps.setString(8, task.getPriority());
                    ps.setString(9, task.getTask_description());

                    // Convert the Date to a String in the format "yyyy-MM-dd"
                    ps.setString(10, task.getDateInString());

                    ps.executeUpdate();
                }
                System.out.println("\nSuccessfully Saved to Database!");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        resetAutoIncrement();

    }
    public static void resetAutoIncrement(){
        // Resetting auto-increment counter
        ArrayList<Task> updatedTasks = new ArrayList<>();
        loadTasksFromDatabase(updatedTasks);
        saveTasksToDatabase(updatedTasks);
    }
    public static void loadTasksFromDatabaseDEVELOPER(ArrayList<Task> tasks) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            // Creating the Students table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Tasks ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ColumnName TEXT,"
                    + "DeveloperName TEXT,"
                    + "DeveloperID TEXT,"
                    + "ProjectManager TEXT,"
                    + "ProjectManagerID TEXT,"
                    + "ProjectName TEXT,"
                    + "TaskName TEXT,"
                    + "Priority TEXT,"
                    + "TaskDescription TEXT,"
                    + "Deadline TEXT)";
            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery)) {
                createTableStatement.executeUpdate();
            }

            // Loading data from the database
            String loadDataQuery = "SELECT * FROM Tasks";
            try (PreparedStatement ps = connection.prepareStatement(loadDataQuery)) {
                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String column_name = resultSet.getString("ColumnName");
                    String developer_name = resultSet.getString("DeveloperName");
                    String developer_ID = resultSet.getString("DeveloperID");
                    String projectManager = resultSet.getString("ProjectManager");
                    String projectManagerID = resultSet.getString("ProjectManagerID");
                    String projectName = resultSet.getString("ProjectName");
                    String task_name = resultSet.getString("TaskName");
                    String priority = resultSet.getString("Priority");
                    String task_description = resultSet.getString("TaskDescription");
                    String deadline = resultSet.getString("Deadline");

                    //for date
                    String[] parts = deadline.split("-");
                    int year = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[2]);

                    //adding the data
                    Date d = new Date(year, month, day);
                    Dev dev=new Dev(developer_name, developer_ID);
                    ProjectManager p =new ProjectManager(projectManager, projectManagerID, projectName);

                    //adding to arrayList
                    tasks.add(new Task(column_name,p, dev, task_name, priority, task_description, d));

                }
                System.out.println("Successfully Loaded from Database!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
//---------------------------------------------------------------------------------------------
