package com.test.team.service;

import com.test.team.domain.Architect;
import com.test.team.domain.Designer;
import com.test.team.domain.Employee;
import com.test.team.domain.Programmer;

/**
 *关于开发团队的成员的管理添加、删除等
 */
public class  TeamService {
    private static int counter=1;//为每个进入开发团队的人赋予一个唯一的递增的id即使有人退出其id也不会变
    private final int MAX_COUNTER=5;//限定开发团队人数最多为5
    private Programmer[] team=new Programmer[MAX_COUNTER];//保存开发团队成员的数组
    private int total;//保存开发团队中实际的人数

    public TeamService() {

    }

    /**
     * 获取开发团队中的所有成员
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] team=new Programmer[total];
        for (int i=0;i<team.length;i++){
            team[i]=this.team[i];
        }
        return team;
    }

    /**
     * 将指定的员工添加到开发团队中
     * @param e
     */
    public void addMember(Employee e) throws TeamExcepation {
        //成员已满无法添加
        if (total>=MAX_COUNTER){
            throw new TeamExcepation("成员已满无法添加");
        }
        //该成员不是开发成员无法添加
        if (!(e instanceof Programmer)){
            throw new TeamExcepation("该成员不是开发成员无法添加");
        }
        //该成员已在团队之中
        if (isExit(e)){
            throw new TeamExcepation("该成员已在团队之中");
        }
        //该员工已是某团队成员
       // if(((Programmer) e).getStatus().getNAME().equals("BUZY"))前面的变量可能出现空指针异常所以不如改用确定的变量在前面较好
        if ("BUZY".equals(((Programmer) e).getStatus().getNAME())){
            throw new TeamExcepation("该员工已是某团队成员");
        }
        //该员工正在休假
        if ("VOCATION".equals(((Programmer) e).getStatus().getNAME())){
            throw new TeamExcepation("该员工正在休假");
        }
        //团队中最多只能有一名架构师
        //团队中最多只能有两名设计师
        //团队中最多只能由三名程序员
        isfull(e);
        team[total++]= (Programmer) e;
        ((Programmer) e).setStatus(Status.BUZY);
        ((Programmer) e).setMemberId(counter++);



    }

    /**
     * 判断团队数组中是否已存在成员的id
     * @param e
     * @return
     */
    private boolean isExit(Employee e) {
        for (int i=0;i<total;i++){
            if (team[i].getId()==e.getId()){
                return true;
            }
        }
        return false;
    }
    private void isfull(Employee e) throws TeamExcepation {
        int Dtype=0;
        int Atype=0;
        int Ptype=0;


            for (int i=0;i<total;i++){
                if (team[i] instanceof Architect)
                    Atype++;
                else if (team[i] instanceof Designer)
                    Dtype++;
                else if (team[i] instanceof Programmer)
                    Ptype++;
            }
        if (e instanceof Architect) {
            if (Atype >= 1) throw new TeamExcepation("团队中最多只能有一名架构师");
        }else if (e instanceof Designer){
            if (Dtype>=2) throw new TeamExcepation("团队中最多只能有两名设计师");
        }else if (e instanceof Programmer) {
            if (Ptype >= 3) throw new TeamExcepation("团队中最多只能有三名程序员");
        }

    }

    /**
     * 删除团队成员
     * @param memberid
     */
    public void removeMember(int memberid) throws TeamExcepation {
        int i=0;
        for (i=0;i<total;i++){
            if (team[i].getMemberId()==memberid){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i==total){
            throw new TeamExcepation("未找到相应memberid成员，删除失败");
        }
        for (int j=memberid;j<team.length;j++){
            team[j-1]=team[j];
        }
        team[total-1]=null;
        total--;
    }

}
