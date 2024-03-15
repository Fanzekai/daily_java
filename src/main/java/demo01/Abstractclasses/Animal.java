package demo01.Abstractclasses;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  20:20
 */

    public abstract class Animal {

        private String name;

        public Animal(String name){
            this.name = name;
    }

        public String getName(){
            return name;
}

    public abstract void eat();
}
