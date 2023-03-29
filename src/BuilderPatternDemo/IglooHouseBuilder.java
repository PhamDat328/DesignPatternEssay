package BuilderPatternDemo;

public class IglooHouseBuilder implements HouseBuilder {
    private House house;

    public IglooHouseBuilder() {
        this.house = new House();
    }
    public void buildBasement() {
        System.out.println("Ice Bars");
        house.setBasement("Ice Bars");
    }
    public void buildStructure() {
        System.out.println("Ice Blocks");
        house.setStructure("Ice Blocks");
    }
    public void buildInterior() {
        System.out.println("Ice Carvings");
        house.setInterior("Ice Carvings");
    }
    public void buildRoof() {
        System.out.println("Ice Dome");
        house.setRoof("Ice Dome");
    }
    public House getHouse() {
        return this.house;
    }
}
