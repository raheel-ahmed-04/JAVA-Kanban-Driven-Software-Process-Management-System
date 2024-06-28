import java.io.*;
import java.util.ArrayList;

public class LoginRegister implements Serializable {

    // Method for registration
    static public boolean registration(ProjectManager p) {
        ArrayList<ProjectManager> projectManagers = new ArrayList<>();

        boolean exists=false;

        // OIS converts an object into a stream of byte
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("B"))) {
            while (true) {
                try {
                    ProjectManager projectManager = (ProjectManager) ois.readObject();    //ClassCastException
                    projectManagers.add(projectManager);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (ProjectManager projectManager : projectManagers) {
            if (p.getName().equalsIgnoreCase(projectManager.getName()) && p.getId().equals(projectManager.getId())) {
                exists=true;
                System.out.println("User Already exists");
            }
        }
        // Now we check if user already exist or not
        if(exists==true){}
        else if (exists==false) {projectManagers.add(p);
            System.out.println("Registered!!!");}

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("B"));
            for (ProjectManager projectManager : projectManagers) {
                oos.writeObject(projectManager);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ProjectManager projectManager : projectManagers) {
            System.out.println(projectManager);
        }
        return exists;
    }


    // Method for Login
    static boolean login(ProjectManager p) {
        ArrayList<ProjectManager> projectManagers = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("B"))) {
            while (true) {
                try {
                    ProjectManager projectManager = (ProjectManager) ois.readObject();
                    projectManagers.add(projectManager);
                } catch (EOFException e) {
                    break; // Break the loop when the end of the file is reached
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (ProjectManager projectManager : projectManagers) {
            if (p.getName().equals(projectManager.getName()) && p.getId().equals(projectManager.getId())) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // Test registration and login
        ProjectManager newUser = new ProjectManager("john", "password123");
        registration(newUser);

        ProjectManager loginAttempt = new ProjectManager("john", "password123");
        login(loginAttempt);
    }
}


