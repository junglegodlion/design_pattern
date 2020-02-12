package com.geely.design.pattern.structural.flyweight;

/**
 * 场景：部门做汇报
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 员工
 */
interface Employee {
    void report();
}

/**
 * 经理
 */
class Manager implements Employee {
    @Override
    public void report() {
        System.out.println(reportContent);
    }

    // 这里的title就是内部状态，不会改变
    // department就是外部状态，需要外部传入，是会改变的
    private String title = "部门经理";
    private String department;
    private String reportContent;

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Manager(String department) {
        this.department = department;
    }


}

/**
 * 员工工厂
 */
class EmployeeFactory {
    private static final Map<String,Employee> EMPLOYEE_MAP = new HashMap<String,Employee>();

    public static Employee getManager(String department){
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);

        if(manager == null){
            manager = new Manager(department);
            System.out.print("创建部门经理:"+department);
            String reportContent = department+"部门汇报:此次报告的主要内容是......";
            manager.setReportContent(reportContent);
            System.out.println(" 创建报告:"+reportContent);
            EMPLOYEE_MAP.put(department,manager);

        }
        return manager;
    }

}

public class AppTest {
    private static final String departments[] = {"RD","QA","PM","BD"};
    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            String department = departments[(int)(Math.random() * departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();

        }

        // 下面就是享元模式的应用
//        Integer a = Integer.valueOf(100);
//        Integer b = 100;
//
//        Integer c = Integer.valueOf(1000);
//        Integer d = 1000;
//
//        System.out.println("a==b:"+(a==b));
//
//        System.out.println("c==d:"+(c==d));

    }
}
