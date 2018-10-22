package pl.mateusz.engine;

import java.util.Date;

public class Calculator {
    private String name;
    private Integer age;
    private Float bodyWeight;
    private Float bodyGrowth;
    private Date stateByDay;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Float getBodyWeight() {
        return bodyWeight;
    }

    public Float getBodyGrowth() {
        return bodyGrowth;
    }

    public Date getStateByDay() {
        return stateByDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBodyWeight(Float bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public void setBodyGrowth(Float bodyGrowth) {
        this.bodyGrowth = bodyGrowth;
    }

    public void setStateByDay(Date stateByDay) {
        this.stateByDay = stateByDay;
    }

    public Double calculateBMI() {
        int x = 2;
        return getBodyWeight() / Math.pow(getBodyGrowth(), x);
    }
}
