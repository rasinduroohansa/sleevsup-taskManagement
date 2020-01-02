package com.biz.sleevsup.service;

import com.biz.sleevsup.api.request.CreateTaskRequest;
import com.biz.sleevsup.api.request.UpdateTaskRequest;
import com.biz.sleevsup.db.entity.Task;
import com.biz.sleevsup.db.repository.TaskRepository;
import com.biz.sleevsup.enums.TaskStatus;
import com.biz.sleevsup.response.GenericResponse;
import com.biz.sleevsup.utilites.ResponseCodes;
import com.biz.sleevsup.utilites.Constant;
import com.biz.sleevsup.utilites.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
public class TaskManagementService {
    private Logger logger = LoggerFactory.getLogger(TaskManagementService.class);


    @Autowired
    private TaskRepository taskRepository;

    /**
     * Create a task and return generic response weather request is successful or not
     * @param request
     * @return GenericResponse
     */
    public GenericResponse createTask(CreateTaskRequest request) {
        if (request != null && Validation.validateTaskName(request.getTaskName())) {
            Task task = new Task();
            task.setTaskName(request.getTaskName());
            task.setPriorityLevel(request.getTaskPriority());
            task.setDescription(request.getDescription());
            if (request.getTaskStatus() != null)
                task.setTaskStatus(request.getTaskStatus().status);
            if (!validateDuplicateTask(task)) {
                Task savedTask = taskRepository.save(task);
                if (savedTask != null)
                    return new GenericResponse(Constant.MSG_NEW_TASK_ID + savedTask.getId(), ResponseCodes.SUCCESSFUL.code);
                else
                    return new GenericResponse(Constant.MSG_TASK_CREATION_FAILED, ResponseCodes.FAIL.code);
            } else {
                return new GenericResponse(Constant.MSG_DUPLICATED_TASK, ResponseCodes.FAIL.code);
            }
        } else {
            return new GenericResponse(Constant.MSG_TASK_NAME_INVALID, ResponseCodes.FAIL.code);
        }
    }

    @Transactional
    public GenericResponse updateTaskData(UpdateTaskRequest request) {
        final int updateStatus = taskRepository.updateTask(request.getTaskId(), request.getTaskName(), request.getDescription(), request.getTaskPriority(), request.getTaskStatus().status);
        if (Constant.DB_OPERATION_SUCCESSFUL == updateStatus) {
            return new GenericResponse(ResponseCodes.SUCCESSFUL.name(), ResponseCodes.SUCCESSFUL.code);
        } else {
            return new GenericResponse(ResponseCodes.FAIL.name(), ResponseCodes.FAIL.code);
        }
    }

    @Transactional
    public GenericResponse completeTask(Long taskId) {
        final int updateStatus = taskRepository.updateCompleted(TaskStatus.COMPLETED.status, taskId);
        if (Constant.DB_OPERATION_SUCCESSFUL == updateStatus) {
            return new GenericResponse(ResponseCodes.SUCCESSFUL.name(), ResponseCodes.SUCCESSFUL.code);
        } else {
            return new GenericResponse(ResponseCodes.FAIL.name(), ResponseCodes.FAIL.code);
        }

    }

    public GenericResponse deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            return new GenericResponse(Constant.MSG_INCORRECT_TASK_ID, ResponseCodes.FAIL.code);
        }
        taskRepository.deleteById(taskId);
        if (taskRepository.existsById(taskId)) {
            return new GenericResponse(ResponseCodes.FAIL.name(), ResponseCodes.FAIL.code);
        } else {
            return new GenericResponse(ResponseCodes.SUCCESSFUL.name(), ResponseCodes.SUCCESSFUL.code);
        }
    }

    public List<Task> getTaskListByStatus(TaskStatus taskStatus) {
        return taskRepository.findTaskByTaskStatus(taskStatus.status);
    }

    public ArrayList<Task> getAllTaskList() {
        return taskRepository.findAllTasks();
    }

    private Boolean validateDuplicateTask(Task task) {
        ArrayList<Task> allTasks = taskRepository.findAllTasks();
        boolean contains = allTasks.contains(task);
        return contains;
    }
}
