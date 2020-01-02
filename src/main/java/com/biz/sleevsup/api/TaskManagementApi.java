package com.biz.sleevsup.api;

import com.biz.sleevsup.api.request.CreateTaskRequest;
import com.biz.sleevsup.api.request.UpdateTaskRequest;
import com.biz.sleevsup.db.entity.Task;
import com.biz.sleevsup.enums.TaskStatus;
import com.biz.sleevsup.response.GenericResponse;
import com.biz.sleevsup.service.TaskManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class TaskManagementApi {
    private static final Logger LOGGER= LoggerFactory.getLogger(TaskManagementApi.class);

    @Autowired
    private TaskManagementService managementService;

    @RequestMapping(value = {"/createTask"},method = RequestMethod.POST)
    public GenericResponse createTask(@RequestBody CreateTaskRequest request){
        long start=System.currentTimeMillis();
        GenericResponse response=managementService.createTask(request);
        Duration duration=Duration.ofMillis(System.currentTimeMillis()-start);
        LOGGER.info("End Create Task | response={} | duration={}:{}:{}",response,duration.toHours(),duration.toMinutes(),duration.toMillis());
        return response;
    }

    @RequestMapping(value = {"/updateTask"},method = RequestMethod.PUT)
    public GenericResponse updateTaskData(@RequestBody UpdateTaskRequest request){
        long start=System.currentTimeMillis();
        GenericResponse response=managementService.updateTaskData(request);
        Duration duration=Duration.ofMillis(System.currentTimeMillis()-start);
        LOGGER.info("End Update Task | response={} | duration={}:{}:{}",response,duration.toHours(),duration.toMinutes(),duration.toMillis());
        return response;
    }

    @RequestMapping(value = {"/completeTask/{id}"},method = RequestMethod.PUT)
    public GenericResponse completeTask(@PathVariable(name ="id" ) Long taskId){
        long start=System.currentTimeMillis();
        GenericResponse response=managementService.completeTask(taskId);
        Duration duration=Duration.ofMillis(System.currentTimeMillis()-start);
        LOGGER.info("End Update Task | response={} | duration={}:{}:{}",response,duration.toHours(),duration.toMinutes(),duration.toMillis());
        return response;
    }

    @RequestMapping(value = {"/deleteTask/{id}"},method = RequestMethod.DELETE)
    public GenericResponse deleteTask(@PathVariable(name = "id") Long taskId){
        long start=System.currentTimeMillis();
        GenericResponse response=managementService.deleteTask(taskId);
        Duration duration=Duration.ofMillis(System.currentTimeMillis()-start);
        LOGGER.info("End Delete Task | response={} | duration={}:{}:{}",response,duration.toHours(),duration.toMinutes(),duration.toMillis());
        return response;
    }

    @RequestMapping(value = {"/getCompletedTasks"},method = RequestMethod.GET)
    public List<Task> getCompletedTaskList(){
        return managementService.getTaskListByStatus(TaskStatus.COMPLETED);
    }

    @RequestMapping(value = {"/getPendingTasks"},method = RequestMethod.GET)
    public List<Task> getPendingTaskList(){
        return managementService.getTaskListByStatus(TaskStatus.PENDING);
    }

    @RequestMapping(value = {"/getAllTasks"},method = RequestMethod.GET)
    public ArrayList<Task> getAllTaskList(){
        return managementService.getAllTaskList();
    }
}
