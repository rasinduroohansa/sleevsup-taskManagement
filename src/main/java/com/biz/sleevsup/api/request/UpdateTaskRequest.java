package com.biz.sleevsup.api.request;

import com.biz.sleevsup.enums.TaskStatus;

public class UpdateTaskRequest {
    private Long taskId;
    private String taskName;
    private Integer taskPriority;
    private String description;
    private TaskStatus taskStatus;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Integer taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "UpdateTaskRequest{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskPriority=" + taskPriority +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
