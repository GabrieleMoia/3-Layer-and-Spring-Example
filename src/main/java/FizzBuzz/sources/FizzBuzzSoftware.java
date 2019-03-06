package FizzBuzz.sources;

public class FizzBuzzSoftware {

    public String contains (int i){
        String parsedI = String.valueOf(i);
        String result = "";
        if(parsedI.contains("5")){
            result = "Buzz";
        }
        if(parsedI.contains("3")){
            result = "Fizz";
        }
        if(parsedI.contains("5") && parsedI.contains("3")){
            result = "FizzBuzz";
        }
        return result;
    }

    public String run(int i) {
        String result = "";
        if (i % 3 == 0) {
            result = "Fizz";
        }
        if (i % 5 == 0) {
            result = "Buzz";
        }
        if (i % 3 == 0 && i % 5 == 0) {
            result = "FizzBuzz";
        }
        return result;
    }
}
