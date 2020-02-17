import java.util.LinkedList;
import java.util.Queue;

/*
    实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的 实例放入队列中；
     用户可以调用pollAll方法，将队列中所有的实例按照进队列 的先后顺序依次弹出；
     用户可以调用pollDog方法，将队列中dog类的实例按照 进队列的先后顺序依次弹出；
     用户可以调用pollCat方法，将队列中cat类的实 例按照进队列的先后顺序依次弹出；
     用户可以调用isEmpty方法，检查队列中是 否还有dog或cat的实例；
     用户可以调用isDogEmpty方法，检查队列中是否有dog 类的实例；
     用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 */
public class DogCatQueue {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }


    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getPetType() {
            return this.pet.getPetType();
        }
    }


    public static class DogCat {
        private Queue<PetEnter> dogQueue;
        private Queue<PetEnter> catQueue;
        private long count;

        public DogCat() {
            this.dogQueue = new LinkedList<PetEnter>();
            this.catQueue = new LinkedList<PetEnter>();
            this.count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                this.dogQueue.add(new PetEnter(pet,this.count++));
            } else if (pet.getPetType().equals("cat")) {
                this.catQueue.add(new PetEnter(pet,this.count++));
            } else {
                throw new RuntimeException("type error");
            }
        }

        public Pet pollAll() {
            if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
                if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
                    return this.dogQueue.poll().getPet();
                } else {
                    return this.catQueue.poll().getPet();
                }
            } else if (!this.isCatEmpty()) {
                return  this.catQueue.poll().getPet();
            } else if (!this.isDogEmpty()) {
                return this.dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("out");
            }
        }

        public Cat pollCat() {
            if (!this.isCatEmpty()) {
                return  (Cat)this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("out");
            }
        }

        public Dog pollDog() {
            if (!this.isCatEmpty()) {
                return  (Dog) this.dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("out");
            }
        }


        public boolean isEmpty() {
            return this.catQueue.isEmpty() && this.dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return this.catQueue.isEmpty();
        }

        public boolean isDogEmpty() {
            return this.dogQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCat test = new DogCat();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);


        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }

}
