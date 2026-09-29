
/**
 * 测试主类，实例化太阳、行星对象，验证面向对象设计
 * @author xxx
 */
public class SolarTest {
    public static void main(String[] args) {
        //1.实例化太阳对象
        Sun sun = new Sun("太阳",5778);

        //2.实例化普通行星、地球子类
        Planet mars = new Planet("火星",1.52,687,1.03);
        Earth earth = new Earth("地球",1.0,365,1.0,1);

        //3.行星添加到太阳
        sun.addPlanet(earth);
        sun.addPlanet(mars);

        //4.调用方法输出信息
        sun.showAllPlanetInfo();
        System.out.println("----------------");
        System.out.println(earth.getRevolutionInfo());
        earth.showEarthInfo();
    }
}
