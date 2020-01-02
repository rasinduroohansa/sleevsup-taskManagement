package com.biz.sleevsup.service;

import com.biz.sleevsup.api.request.CreateTaskRequest;
import com.biz.sleevsup.db.entity.Task;
import com.biz.sleevsup.enums.TaskStatus;
import com.biz.sleevsup.response.GenericResponse;
import com.biz.sleevsup.utilites.Constant;
import org.aspectj.lang.annotation.Before;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskManagementServiceTest {

    @Autowired
    private TaskManagementService taskManagementService;

    @Test
    public void createTaskEmptyTaskNameEmpty() {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("");
        createTaskRequest.setTaskPriority(0);
        createTaskRequest.setTaskStatus(TaskStatus.PENDING);
        GenericResponse response = taskManagementService.createTask(createTaskRequest);
        Assert.assertEquals(response.getResponse(),Constant.MSG_TASK_NAME_INVALID);
    }

    @Test
    public void createTaskNullTaskName() {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName(null);
        createTaskRequest.setTaskPriority(0);
        createTaskRequest.setTaskStatus(TaskStatus.PENDING);
        GenericResponse response = taskManagementService.createTask(createTaskRequest);
        Assert.assertEquals(response.getResponse(),Constant.MSG_TASK_NAME_INVALID);
    }

    @Test
    public void createTaskMaxCharactorExceedTaskName() {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" +
                "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" +
                "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        createTaskRequest.setTaskPriority(0);
        createTaskRequest.setTaskStatus(TaskStatus.PENDING);
        GenericResponse response = taskManagementService.createTask(createTaskRequest);
        Assert.assertEquals(response.getResponse(),Constant.MSG_TASK_NAME_INVALID);
    }

    @Test
    public void createTaskDuplicatedTask() {
    }

    @Test
    public void createTaskCreationFail() {
    }

    @Test
    public void createTaskSuccessful() {
    }

    @Test
    public void createTaskNullInput() {
    }
}
