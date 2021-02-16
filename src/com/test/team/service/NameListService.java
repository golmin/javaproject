package com.test.team.service;

import com.test.team.domain.*;

import static com.test.team.service.Data.*;//导入这句后所有需要使用Data.的属性都可以省略Data.使代码更加简洁

/**
 * 功能：将Data中的数据封装到Employee[]数组中，同时提供操作Employee[]的方法
 */
public class NameListService {
    private Employee[] employees;
    private Equipment[] equipment;

    public NameListService(){
        /**
         * 根据项目提供的Data类来构建相应大小的employee数组
         * 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、。。。将对象存入数组中
         */
        //初始化employee数组
        employees=new Employee[EMPLOYEES.length];
        //由于Data数组中的employee元素各不相同因此需要判断该数组的第一个用来表示类型的元素是用来表示什么的
        for(int i=0;i<employees.length;i++){
            //由于存在数组中的元素是String类型因此要用包装类转换为int型进行判断
            //获取员工类型
            int type=Integer.parseInt(EMPLOYEES[i][0]);
            //获取员工id等信息将id等转为int型再传入构造器的形参
            int id=Integer.parseInt(EMPLOYEES[i][1]);
            String name=EMPLOYEES[i][2];
            int age=Integer.parseInt(EMPLOYEES[i][3]);
            double salary=Integer.parseInt(EMPLOYEES[i][4]);
            Equipment equipmen;//由于有人没有设备所以不能在此处处理，应只声明在每个类型的员工下方再处理
            double bons;

            switch (type){
                case EMPLOYEE:
                    employees[i]=new Employee(id,age, name,salary);
                break;
                case PROGRAMMER:
                    equipmen=creatEquipment(i);
                    employees[i]=new Programmer(id,age,name,Status.FREE, salary,equipmen);
                break;
                case DESIGNER:
                    equipmen=creatEquipment(i);
                    bons=Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i]=new Designer(id,age,name,salary,equipmen,bons);
                break;
                case ARCHITECT:
                    equipmen=creatEquipment(i);
                    bons=Double.parseDouble(EMPLOYEES[i][5]);
                    int stock=Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i]=new Architect(id,age,name,salary,equipmen,bons,stock);
                break;
            }
        }
    }

    /**
     * 构建每个员工所对应的具体设备
     * @return
     */
    private Equipment creatEquipment(int index) {
        int type=Integer.parseInt(EQIPMENTS[index][0]);
        String model;
        switch (type){
            case PC:
                String display=EQIPMENTS[index][2];
                model=EQIPMENTS[index][1];
                return new PC(model,display);

            case NOTEBOOK:
                int price=Integer.parseInt(EQIPMENTS[index][2]);
              model=EQIPMENTS[index][1];
                return new NoteBook(model, price);

            case PRINTER:
                String name=EQIPMENTS[index][2];
                String typereal=EQIPMENTS[index][1];
                return new Print(name, typereal);

        }
        return null;
    }

    /**
     * 获取当前所有的员工，返回包含所有员工的数组
     * @return
     */
    public Employee[] getAllEmployees(){
        return employees;
    }

    /**
     * 获取指定ID的员工对象
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamExcepation {
            for (int i=0;i<employees.length;i++){
                if (employees[i].getId() == (id)){
                    return employees[i];
                }
            }
        throw new TeamExcepation("未找到指定对象");
       // return null;

    }
}
