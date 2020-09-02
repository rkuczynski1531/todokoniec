package com.example.demo.repositories;

import com.example.demo.domain.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {


    //    @Query("FROM Task ORDER BY date ASC")
    List<Task> findAllByOrderByDateAsc();

}
