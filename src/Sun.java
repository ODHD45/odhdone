
import java.util.ArrayList;
import java.util.List;

/**
 * 太阳实体类
 * 太阳系中心天体，一对多关联行星
 * @author xxx
 */
public class Sun {
    /**太阳名称*/
    private String sunName;
    /**太阳表面温度*/
    private double temperature;
    /**太阳拥有的行星集合：一对多*/
    private List<Planet> planetList;

    /**
     * 太阳构造方法
     * @param sunName 太阳名称
     * @param temperature 温度
     */
    public Sun(String sunName, double temperature) {
        this.sunName = sunName;
        this.temperature = temperature;
        planetList = new ArrayList<>();
    }

    /**
     * 向太阳添加一颗行星
     * @param p 行星对象
     */
    public void addPlanet(Planet p){
        planetList.add(p);
    }

    /**
     * 展示所有围绕太阳运转行星信息
     */
    public void showAllPlanetInfo(){
        System.out.println("=====中心天体："+sunName+"，温度："+temperature+" K =====");
        for (Planet planet : planetList) {
            planet.showPlanetInfo();
        }
    }

    //getter setter
    public String getSunName() {
        return sunName;
    }
    public void setSunName(String sunName) {
        this.sunName = sunName;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}