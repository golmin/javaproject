package com.test.team.domain;

import com.test.team.service.Status;

public class Programmer extends Employee {
    private int memberId;//开发团队中的ID
    private Status status;//成员的状态
    private Equipment equipment;//成员的设备

    public Programmer() {
        super();
    }

    public Programmer(int id, int age, String name, Status status,double salary,Equipment equipment) {
        super(id, age, name, salary);
        this.status=status;
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString()+"\t\t程序员\t"+status.getNAME()+"\t\t\t\t\t"+equipment.getDescription();
    }
    public String toStringForTeam(){
        return super.toString()+"\t\t程序员";
    }
}
