package learn.labs.test;

public class Calculator {

    public Integer devide(Integer fist, Integer second){
        if(second == 0){
            throw new IllegalArgumentException("Cannot divide by zero");
        } else {
            return fist / second;
        }
    }

    public Integer add(Integer first, Integer second) {
        return first + second;
    }
}
