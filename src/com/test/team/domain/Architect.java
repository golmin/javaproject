package com.test.team.domain;

public class Architect extends Designer {
    private int stock;//股份

    public Architect() {
        super();
    }
    public Architect(int id, int age, String name, double salary, Equipment equipment, double bonus, int stock) {
        super(id, age, name, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.getId()+"\t"+super.getName()+"\t"+super.getAge()+"\t"+super.getSalary()+"\t\t架构师\t"
                +super.getStatus().getNAME()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();

    }
    public String toStringForTeam(){
        return super.getId()+"\t"+super.getName()+"\t"+super.getAge()+"\t"+super.getSalary()+"\t\t架构师\t"+"\t"+getBonus()+"\t"+stock+"\t";
    }
}
