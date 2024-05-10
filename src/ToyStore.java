import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
    }

    public Toy drawToy() {
        Random random = new Random();
        int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
        int randomNumber = random.nextInt(totalWeight);
        int weightSum = 0;

        for (Toy toy : toys) {
            weightSum += toy.getWeight();
            if (randomNumber < weightSum) {
                toy.decreaseQuantity();
                return toy;
            }
        }

        return null;
    }
    public void removeToy(Toy toy) {
        toys.remove(toy);
    }


    public void saveToyToFile(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("toys.txt", true))) {
            writer.write("ID: " + toy.getId() + ", Name: " + toy.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
