package com.wl.union;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class Student {
    String name;
    int age;
    String className;

    public Student(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }

        Student student = (Student) o;

        if (getAge() != student.getAge()) {
            return false;
        }
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) {
            return false;
        }
        return getClassName() != null ? getClassName().equals(student.getClassName()) : student.getClassName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (getClassName() != null ? getClassName().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
