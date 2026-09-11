package com.devops.taskmanager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {
    private final JdbcTemplate jdbc;

    public TaskRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Task> findAll() {
        return jdbc.query(
            "SELECT id, title, description, status FROM tasks ORDER BY id DESC",
            (rs, rowNum) -> new Task(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("status")
            )
        );
    }

    public Task save(Task task) {
        jdbc.update(
            "INSERT INTO tasks(title, description, status) VALUES (?, ?, ?)",
            task.title(), task.description(), task.status()
        );
        return jdbc.queryForObject(
            "SELECT id, title, description, status FROM tasks ORDER BY id DESC LIMIT 1",
            (rs, rowNum) -> new Task(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("status")
            )
        );
    }
}
