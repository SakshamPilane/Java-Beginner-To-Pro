package coding_10;

class GenericConstructor {

    <T> GenericConstructor (T value){
        System.out.println(value.getClass().getSimpleName() + " " + value);
    }
}
