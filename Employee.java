package org.example;



public class Employee extends Person {
    private String jobTitle;
    private int yearsOfExperience;

    public Employee() {
    }

    public Employee(String name, int age, String gender, String jobTitle, int yearsOfExperience) {
        super(name, age, gender);
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
