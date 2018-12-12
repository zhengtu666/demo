package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class DemoTests {

    @Test
    public void test1() {
        Integer current = 0;

        System.out.println(getP(5, current));
    }
    public Integer getP(int i,int current){

        current=current/4*5+1;
        if(i>=0){
            i--;
            getP(i,current);
        }
        return current;
    }
}
