package Selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams {
    public void regular(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Adam");
        names.add("Rob");
        names.add("Jack");
        names.add("Aaron");
        names.add("Ana");
        int count = 0;

        for(int i = 0;i < names.size(); i++){
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Adam");
        names.add("Rob");
        names.add("Jack");
        names.add("Aaron");
        names.add("Ana");

        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

    }
    @Test
    public void streamMap(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Adam");
        names.add("Rob");
        names.add("Jack");
        names.add("Aaron");
        names.add("Ana");
        Stream.of("Ana", "Aaron", "Jack", "Rob", "Adam").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                .forEach(s-> System.out.println(s));

        List<String> names1 = Arrays.asList("Ana", "Aaron", "Jack", "Rob", "Adam");
        names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);

    }
    @Test
    public void streamCollect(){
        List<String> ls = Stream.of("Ana", "Aaron", "Jack", "Rob", "Adam").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        //values.stream().distinct().forEach(s-> System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));

    }
}