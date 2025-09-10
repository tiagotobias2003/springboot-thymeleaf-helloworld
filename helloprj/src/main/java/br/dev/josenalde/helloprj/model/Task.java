package br.dev.josenalde.helloprj.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
    private Long Id;
    private String name;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date date;

    public Task() {

    }

    public Task(Long id, String name, Date date) {
        this.Id = id;
        this.name = name;
        this.date = date;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        this.Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task [Id=" + Id + ", name=" + name + ", date=" + date + "]";
    }

    

    

}
