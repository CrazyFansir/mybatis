package com.cskaoyan.bean;

public class ClassTeacher {
    String id;
    String teacherName;
    int age;
    int teachTime;
    Clazz clazzz;

    @Override
    public String toString() {
        return "ClassTeacher{" +
                "id='" + id + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", age=" + age +
                ", teachTime=" + teachTime +
                ", clazz=" + clazzz +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeachTime() {
        return teachTime;
    }

    public void setTeachTime(int teachTime) {
        this.teachTime = teachTime;
    }

    public Clazz getClazzz() {
        return clazzz;
    }

    public void setClazzz(Clazz clazz) {
        this.clazzz = clazz;
    }
}
