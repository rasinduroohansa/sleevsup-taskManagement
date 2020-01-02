package com.biz.sleevsup.db.repository;

import com.biz.sleevsup.db.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT task FROM Task task WHERE task.id=:taskId")
    Task findTaskById(@Param("taskId") Long taskId);

    @Modifying
    @Transactional
    @Query("UPDATE Task task SET task.taskName=:taskName,task.priorityLevel=:priorityLevel,task.description=:desc,task.taskStatus=:status WHERE task.id=:id")
    int updateTask(@Param("id") Long id, @Param("taskName") String taskName, @Param("desc") String desc, @Param("priorityLevel") Integer priorityLevel, @Param("status") Integer status);

    @Modifying
    @Transactional
    @Query("UPDATE Task task SET task.taskStatus=:status WHERE task.id=:id")
    int updateCompleted(@Param("status") Integer status, @Param("id") Long id);

    @Query("SELECT task FROM Task task WHERE task.taskStatus=:status")
    List<Task> findTaskByTaskStatus(@Param("status") Integer status);

    @Query("SELECT task FROM Task task")
    ArrayList<Task> findAllTasks();
}
