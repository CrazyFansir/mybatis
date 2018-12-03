package com.cskaoyan.bean;

import java.util.List;

public class Cource {
    String id;
    String courceName;
    List<Student> students;

    @Override
    public String toString() {
        return "Cource{" +
                "id='" + id + '\'' +
                ", courceName='" + courceName + '\'' +
                ", students=" + students +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourceName() {
        return courceName;
    }

    public void setCourceName(String courceName) {
        this.courceName = courceName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
