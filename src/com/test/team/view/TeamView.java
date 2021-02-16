package com.test.team.view;

import com.test.team.domain.Employee;
import com.test.team.domain.Programmer;
import com.test.team.service.NameListService;
import com.test.team.service.TeamExcepation;
import com.test.team.service.TeamService;
import com.test.team.unitly.Utility;

public class TeamView {
    private NameListService listSvc=new NameListService();
    private TeamService teamSvc=new TeamService();
    public void enterMainMenu(){
        boolean isFlag=true;
        char menu='0';
        while (isFlag){

            if (menu!='1'){
                listAllEmployee();
            }
            System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            menu=Utility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char yon=Utility.readConfirmSelection();
                    if (yon=='Y'){
                        isFlag=false;
                        break;
                    }
                    break;

            }
        }
    }

    /**
     * 显示所有员工信息
     */
    public void listAllEmployee(){
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees=listSvc.getAllEmployees();
        if (employees.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("ID\t姓名\t年龄 工资    \t职位\t状态\t奖金\t股票\t领用设备");
        }
        for (int i=0;i<employees.length;i++){
           System.out.println(employees[i]);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
    public void getTeam(){
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] teams=teamSvc.getTeam();
        if (teams.length==0){
            System.out.println("开发团队目前没有成员！");
        }else {
            System.out.println("TID/ID姓名\t年龄 工资\t\t职位\t\t奖金\t股票");
        }
        for (int i=0;i<teams.length;i++){
            System.out.print(teams[i].getMemberId()+"/");
            System.out.println(teams[i].toStringForTeam());
        }
        System.out.println("----------------------------------------------------");
    }
    public void addMember() {
        System.out.print("请输入想要添加的成员的id");
        int ID=Utility.readNumber();
        Employee e= null;
        try {
            e = listSvc.getEmployee(ID);
            teamSvc.addMember(e);
            System.out.println("添加成功");

        } catch (TeamExcepation teamExcepation) {
            System.out.println("添加失败，原因："+teamExcepation.getMessage());
        }
        //按回车键继续
        Utility.readReturn();

    }
    public void deleteMember(){
        System.out.println("\n--------------------删除团队成员---------------------\n");
        System.out.print("请输入要删除的团队成员的TID：");
        int ID=Utility.readNumber();
        System.out.print("确认是否删除(Y/N)：");
        char yon=Utility.readConfirmSelection();
        if (yon=='Y'){
            try {
                teamSvc.removeMember(ID);
                System.out.println("删除成功");
                return;
            } catch (TeamExcepation teamExcepation) {
                System.out.println("删除失败，原因： "+teamExcepation.getMessage());
            }
        }else return;
    }

    public static void main(String[] args) {
        TeamView view=new TeamView();
        view.enterMainMenu();
    }
}
