package BuilderPatternDemo;

public class TipiHouseBuilder implements HouseBuilder{
    private House house;
    public TipiHouseBuilder() {
        this.house = new House();
    }
    public void buildBasement() {
        System.out.println("Wooden Poles");

        house.setBasement("Wooden Poles");
    }
    public void buildStructure() {
        System.out.println("Wood and Ice");

        house.setStructure("Wood and Ice");
    }
    public void buildInterior() {
        System.out.println("Fire Wood");

        house.setInterior("Fire Wood");
    }
    public void buildRoof() {
        System.out.println("Wood, caribou and seal skins");

        house.setRoof("Wood, caribou and seal skins");
    }
    public House getHouse() {
        return this.house;
    }
}

