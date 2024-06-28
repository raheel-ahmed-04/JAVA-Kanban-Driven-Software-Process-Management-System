public class Task extends Columns implements DisplayToString{

    private Dev dev;
    private ProjectManager p;
    private String task_name;
    private String priority;
    private String task_description;
    private Date date;
    //another attribute of project name to be added


    Task(){};
    Task(String a,ProjectManager b,Dev c,String d,String e,String f,Date g){
        this.setColumn_e(a);
        this.p=b;
        this.dev=c;
        this.task_name=d;
        this.priority=e;
        this.task_description=f;
        this.date=g;
    }

    void update_dev_name(String a){dev.setName(a);}
    void updateDevID(String n){dev.setId(n);}

    void updateProjectManagerName(String a){p.setName(a);}
    void updateProjectManagerID(String a){p.setId(a);}
    void updateProjectName(String a){p.setProjectName(a);}

    void update_task_name(String b){
        task_name=b;
    }
    void update_priority(String c){
        priority=c;
    }
    void update_task_description(String d){
        task_description=d;
    }
    void update_date(Date d) {
        date=d;
    }

    Date getDate(){return date;}

    String getDev_name(){return dev.getName();}
    String getDevID(){return dev.getId();}

    String getProjectManagerName(){return p.getName();}
    String getProjectManagerID(){return p.getId();}
    String getProjectName(){return p.getProjectName();}

    String getTask_name(){return task_name;}
    String getPriority(){return priority;}
    String getTask_description(){return task_description;}
    String getColumn_name(){return getColumn();}
    int getyears(){
        return date.getYear();
    }
    int getmonths(){
        return date.getMonth();
    }
    int getday(){
        return date.getDay();
    }
    String getDateInString(){return date.toString();}
    @Override
    public String toString() {
        return  "Column Name         :" + getColumn_name() + "\n" +
                "Developer Name      :" + getDev_name() + "\n" +
                "Developer ID        :" + getDevID() + "\n" +
                "Project Manager     :" + getProjectManagerName()+"\n"+
                "Project Manager ID  :" + getProjectManagerID()+"\n"+
                "Project Name        :" + getProjectName()+"\n"+
                "Task Name           :" + task_name + "\n" +
                "Priority            :" + priority + "\n" +
                "Task Description    :" + task_description + "\n" +
                "Deadline            :" + date.toString()+"\n\n";
    }


}