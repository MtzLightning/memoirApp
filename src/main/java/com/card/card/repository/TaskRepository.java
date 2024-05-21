//package com.card.card.repository;
//
//import com.card.card.DTO.CountType;
//import com.card.card.entity.Task;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import java.util.List;
//
//public interface TaskRepository extends JpaRepository<Task, Long> {
//
//    @Query(value = "select * from task", nativeQuery = true)
//    public List<Task> getAllTaskByDueDate();
//
//
//
//
//}
//
//


package com.card.card.repository;

import com.card.card.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT 1 FROM pg_database WHERE datname = ?1", nativeQuery = true)
    Integer checkIfDatabaseExists(String dbName);
}
