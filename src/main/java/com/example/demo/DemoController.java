package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.maximeroussy.invitrode.WordGenerator;

@RestController
@RequestMapping(value="/test")
public class DemoController {
    int words = 2000;
    WordGenerator generator = new WordGenerator();
    Random random = new Random();
    List<String> output = new ArrayList<>();

    @RequestMapping(method=RequestMethod.GET)
    public List<String> randomStrings() {
        if(output.size() == 0) {
            for(int i =0; i <= words; i++) {
                output.add(generator.newWord(random.nextInt(100) + 1000));
            }
        }

        return output;
    }
}