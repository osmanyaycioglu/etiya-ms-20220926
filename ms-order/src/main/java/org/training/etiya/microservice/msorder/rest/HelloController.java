package org.training.etiya.microservice.msorder.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.msorder.rest.models.GreetingsInfo;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;

@RestController
@RequestMapping("/greet")
public class HelloController {

    @GetMapping("/hello2/{abc}/{xyz}")
    public String hello2(@PathVariable("abc") String name,
                         @PathVariable("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("abc") String name,
                         @RequestParam("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    @GetMapping("/hello4")
    public String hello4(@RequestHeader("abc") String name,
                         @RequestHeader("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    @PostMapping("/hello5")
    public String hello4(@RequestBody GreetingsInfo greetingsInfo) {
        return "Hello " + greetingsInfo.getName() + " " + greetingsInfo.getSurname() + " " + greetingsInfo.getAge();
    }

    @PostMapping("/hello6")
    public GreetingsInfo hello6(@RequestBody GreetingsInfo greetingsInfo) {
        greetingsInfo.setName("ali");
        return greetingsInfo;
    }

    @PostMapping("/hello7")
    public ResponseEntity<GreetingsInfo> hello7(@RequestBody GreetingsInfo greetingsInfo) {
        greetingsInfo.setName("ali");
        return ResponseEntity.status(202)
                             .header("myheader",
                                     "osmnan")
                             .body(greetingsInfo);
    }

    @PostMapping("/hello8/{komut}")
    public ResponseEntity<?> hello7(@PathVariable("komut") String command,
                                    HttpServletRequest httpServletRequest) {
        switch (command){
            case "add":
                String isim = httpServletRequest.getParameter("isim");
                String soy = httpServletRequest.getParameter("soy");
                System.out.println("Eklendi : " + isim + " " + soy);
                return ResponseEntity.status(200)
                                     .header("myheader",
                                             "osmnan")
                                     .body("Eklendi : " + isim + " " + soy);
            case "remove":
                Long id = Long.parseLong( httpServletRequest.getParameter("id"));
                System.out.println("Çıkarıldı : " + id);
                return ResponseEntity.status(200)
                                     .header("myheader",
                                             "osmnan")
                                     .body("Çıkarıldı : " + id);
            case "update":
                try {
                    ServletInputStream inputStream = httpServletRequest.getInputStream();
                    ObjectMapper objectMapper = new ObjectMapper();
                    GreetingsInfo greetingsInfo = objectMapper.readValue(inputStream,
                                                                         GreetingsInfo.class);
                    return ResponseEntity.status(200)
                                         .header("myheader",
                                                 "osmnan")
                                         .body(greetingsInfo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
        return ResponseEntity.status(202)
                             .header("myheader",
                                     "osmnan")
                             .body("OK");
    }



    @GetMapping("/hello")
    public String hello1() {
        return "Hello world GET";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Hello world POST";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "Hello world PUT";
    }

    @PatchMapping("/hello")
    public String hello4() {
        return "Hello world PATCH";
    }

    @DeleteMapping("/hello")
    public String hello5() {
        return "Hello world DELETE";
    }

}
