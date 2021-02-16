package com.test.team.domain;

import com.test.team.service.Status;

public class Designer extends Programmer {
    private double bonus;//奖金

    public Designer() {
        super();
    }

    public Designer(int id, int age, String name, double salary, Equipment equipment, double bonus) {
        super(id, age, name, Status.FREE, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.getId()+"\t"+super.getName()+"\t"+super.getAge()+"\t"+super.getSalary()+"\t\t设计师\t"
                +super.getStatus().getNAME()+"\t"+bonus+"\t\t\t"+getEquipment().getDescription();
    }
    public String toStringForTeam(){
        return super.getId()+"\t"+super.getName()+"\t"+super.getAge()+"\t"+super.getSalary()+"\t\t设计师\t"+"\t"+bonus+"\t\t\t";
    }

}
