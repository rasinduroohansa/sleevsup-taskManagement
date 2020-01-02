package com.biz.sleevsup.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Task {
    @Id
    @GeneratedValue(generator = "Task.id")
    @SequenceGenerator(name = "Task.id",sequenceName = "task_id_seq")
    private Long id;
    private String taskName;
    private Integer priorityLevel;
    private String description;
    private Integer taskStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public int hashCode() {
        int hashcode=0;
        hashcode=priorityLevel;
        hashcode+=taskName.hashCode();
        hashcode+=taskStatus;
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj instanceof Task){
           Task task=(Task) obj;
           return task.taskName.equals(this.taskName) &&
                   task.priorityLevel.equals(this.priorityLevel) &&
                   task.taskStatus.equals(this.taskStatus);
       }else{
           return false;
       }
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
