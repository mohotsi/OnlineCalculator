package ae.proctected.covenant.Seleniumautomation.config;

import lombok.val;

import java.util.Arrays;
import java.util.stream.Collectors;

public class text {
    public static void main(String[] args) {
     new text().click("+");
     new text().click("12");
     new text().click("4");
    }
    public void click(String operation){
        if(operation.matches("[0-9]+")){
          val time=  operation.chars().mapToObj(Character::toString).collect(Collectors.toList());
          time.forEach(System.out::println);
        }
        else
         System.out.println(operation);

    }
}
