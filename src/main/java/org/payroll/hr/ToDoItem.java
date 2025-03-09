package org.payroll.hr;

public class ToDoItem {
    private String description;
    private Boolean isDone;

    public ToDoItem(String desc){
        this.description = desc;
        this.isDone = false;
    }

    public Boolean isDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
