
public class Planet {
    /**行星名称*/
    private String planetName;
    /**轨道半径，天文单位AU*/
    private double orbitRadius;
    /**公转周期，单位地球日*/
    private int revolutionPeriod;
    /**自转周期*/
    private double rotationPeriod;

    /**
     * 行星构造器
     * @param planetName 行星名
     * @param orbitRadius 轨道半径
     * @param revolutionPeriod 公转周期
     * @param rotationPeriod 自转周期
     */
    public Planet(String planetName, double orbitRadius, int revolutionPeriod, double rotationPeriod) {
        this.planetName = planetName;
        this.orbitRadius = orbitRadius;
        this.revolutionPeriod = revolutionPeriod;
        this.rotationPeriod = rotationPeriod;
    }

    /**
     * 获取行星公转信息字符串
     * @return 公转描述信息
     */
    public String getRevolutionInfo(){
        return planetName + " 公转周期："+revolutionPeriod + "地球日，轨道半径："+orbitRadius +"AU";
    }

    /**
     * 打印行星全部基础信息
     */
    public void showPlanetInfo(){
        System.out.println("【行星】"+planetName);
        System.out.println("\t轨道半径(AU):"+orbitRadius);
        System.out.println("\t公转周期(地球日):"+revolutionPeriod);
        System.out.println("\t自转周期:"+rotationPeriod);
    }

    //getter setter
    public String getPlanetName() {
        return planetName;
    }
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
    public double getOrbitRadius() {
        return orbitRadius;
    }
    public void setOrbitRadius(double orbitRadius) {
        this.orbitRadius = orbitRadius;
    }
    public int getRevolutionPeriod() {
        return revolutionPeriod;
    }
    public void setRevolutionPeriod(int revolutionPeriod) {
        this.revolutionPeriod = revolutionPeriod;
    }
    public double getRotationPeriod() {
        return rotationPeriod;
    }
    public void setRotationPeriod(double rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }
}