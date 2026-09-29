
public class Earth extends Planet{
    /**地球卫星数量：月球1颗*/
    private int satelliteCount;

    /**
     * 地球构造方法
     * @param planetName 名称
     * @param orbitRadius 轨道半径
     * @param revolutionPeriod 公转周期
     * @param rotationPeriod 自转周期
     * @param satelliteCount 卫星数目
     */
    public Earth(String planetName, double orbitRadius, int revolutionPeriod, double rotationPeriod, int satelliteCount) {
        super(planetName, orbitRadius, revolutionPeriod, rotationPeriod);
        this.satelliteCount = satelliteCount;
    }

    /**
     * 展示地球特有信息
     */
    public void showEarthInfo(){
        super.showPlanetInfo();
        System.out.println("\t卫星数量："+satelliteCount+" 颗(月球)");
    }

    public int getSatelliteCount() {
        return satelliteCount;
    }
    public void setSatelliteCount(int satelliteCount) {
        this.satelliteCount = satelliteCount;
    }
}