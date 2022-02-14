package com.bootcamp4.taskmanagement.repository;


import com.bootcamp4.taskmanagement.dao.TaskRepository;
import com.bootcamp4.taskmanagement.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    UUID id=UUID.randomUUID();
    String userId="auth0|5f040238652e5a0019ce42b3";

    private Task getTask(){

        return new Task(id,userId,"Paying bills",new Date(3-5-2020),new Date(2-5-2020),"WEEKLY",9,
                new Date(2-5-2020),3,new Date(2-5-2020),true,true,true);
    }

    @Test
    public void when_FindAll_is_called_should_return_list_of_tasks(){
        Task expectedTask=getTask();
        taskRepository.save(expectedTask);
        assertNotNull(taskRepository.findAll());
    }

    @Test
    public void when_saveTask_is_called_should_save_task(){

        assertNotNull(taskRepository.save(getTask()));

    }

    @Test
    public void when_find_by_id_is_called_it_should_return_task(){
        Task testTask=taskRepository.save(getTask());
        log.info("{}",testTask);
        Optional<Task> task=taskRepository.findById(testTask.getId());
        log.info("{}",task.isPresent());
        assertTrue(task.isPresent());
    }

    @Test
    public void when_delete_by_Id_is_called_should_delete_task(){

        Task testTask=taskRepository.save(getTask());
        log.info("{}",testTask);
        taskRepository.deleteById(testTask.getId());
        Optional<Task> task=taskRepository.findById(testTask.getId());
        log.info("{}",task.isPresent());
        assertFalse(task.isPresent());


    }

    @Test
    public void when_find_by_user_id_is_called_should_return_list(){

        Task task=getTask();
        taskRepository.save(task);
        Optional<List<Task>> taskList=taskRepository.findTasksByUserId(userId);
        assertNotNull(taskList);

    }

}
