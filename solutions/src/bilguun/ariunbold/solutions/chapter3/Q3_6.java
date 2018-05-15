package bilguun.ariunbold.solutions.chapter3;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author bilguuna
 */

public class Q3_6 {
    public static void main(String... args) {
        AnimalShelter shelter = new AnimalShelter();
        Animal dog1 = new Dog("dog1");
        shelter.enqueue(dog1);
        Animal dog2 = new Dog("dog2");
        shelter.enqueue(dog2);
        Animal cat1 = new Cat("cat1");
        shelter.enqueue(cat1);
        Animal dog3 = new Dog("dog3");
        shelter.enqueue(dog3);
        Animal cat2 = new Cat("cat2");
        shelter.enqueue(cat2);

        shelter.dequeueCat();
        shelter.dequeueCat();
        shelter.enqueue(cat1);
        shelter.dequeueDog();
        print(shelter);

    }

    static void print(AnimalShelter shelter) {
        while (shelter.peek() != null) {
            System.out.println(shelter.dequeueAny().getName());
        }
    }


}


class AnimalShelter {
    LinkedList<Animal> dogs = new LinkedList<>();
    LinkedList<Animal> cats = new LinkedList<>();
    int order = 0;

    public Animal peek() {
        Animal oldestDog = dogs.peek();
        Animal oldestCat = cats.peek();

        if (oldestDog == null) {
            return oldestCat;
        } else if (oldestCat == null) {
            return oldestDog;
        }

        if (oldestDog.getOrder() < oldestCat.getOrder()) {
            return oldestDog;
        } else {
            return oldestCat;
        }
    }

    public Animal dequeueAny() {
        Animal oldestDog = dogs.peek();
        Animal oldestCat = cats.peek();

        if (oldestDog == null) {
            return cats.pop();
        } else if (oldestCat == null) {
            return dogs.pop();
        }

        if (oldestDog.getOrder() < oldestCat.getOrder()) {
            return dogs.pop();
        } else {
            return cats.pop();
        }
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            dogs.addLast(animal);
        } else if (animal instanceof Cat) {
            cats.addLast(animal);
        }
    }

    public Animal dequeueDog() {
        if (dogs.isEmpty()) {
            return null;
        }
        return dogs.pop();
    }

    public Animal dequeueCat() {
        if (cats.isEmpty()) {
            return null;
        }
        return cats.pop();
    }
}

class Animal {
    private String name;
    private int order = 0;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public Dog(String name, int order) {
        super(name, order);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int order) {
        super(name, order);
    }
}
