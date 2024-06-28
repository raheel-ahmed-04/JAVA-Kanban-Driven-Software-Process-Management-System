abstract public class Columns {
    private String column_a;
    private String column_b;
    private String column_c;
    private String column_d;
    private String column_e;


    Columns(){
        column_a="Todo";
        column_b="In Progress";
        column_c="Done";
        column_d="Stuck";
        column_e="Todo";
    }

    public void setColumn_e(String column_e) {
        this.column_e = column_e;
    }
    public String getColumn() {
        return column_e;
    }
    void display(){
        System.out.println("column : "+column_e);
    }
    abstract Date getDate();

    abstract String getDev_name();
    abstract String getDevID();

    abstract String getProjectManagerName();
    abstract String getProjectManagerID();
    abstract String getProjectName();

    abstract String getTask_name();
    abstract String getPriority();
    abstract String getTask_description();
    abstract String getColumn_name();

}
