public class ToyRaffle {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy(1, "Doll", 10, 30));
        toyStore.addToy(new Toy(2, "Car", 8, 20));
        toyStore.addToy(new Toy(3, "Teddy Bear", 5, 10));
        toyStore.addToy(new Toy(4, "Ball", 5, 15));
        toyStore.addToy(new Toy(5, "Cubes", 5, 12));
        toyStore.addToy(new Toy(6, "Constructor", 5, 18));
        toyStore.addToy(new Toy(7, "Puzzle", 5, 14));
        toyStore.addToy(new Toy(8, "Carousel", 5, 25));
        toyStore.addToy(new Toy(9, "Jump rope", 5, 30));
        toyStore.addToy(new Toy(10, "Soldier", 8, 30));


        Toy drawnToy = toyStore.drawToy();
        if (drawnToy != null) {
            System.out.println("The winner is: " + drawnToy.getName());
            toyStore.saveToyToFile(drawnToy);
        } else {
            System.out.println("No toys available for raffle.");
        }
    }
}