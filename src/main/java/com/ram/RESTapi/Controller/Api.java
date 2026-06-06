package com.ram.RESTapi.Controller;


import com.ram.RESTapi.Model.Mydto;
import com.ram.RESTapi.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Api {


        @GetMapping("/hi")
        public ResponseEntity<String> hi(){

            System.out.println("hi() executed...");

            return new ResponseEntity<String>(
                    "Hello Guys Response from Controller",
                    HttpStatus.OK
            );
        }
            @GetMapping("/ram")
          public ResponseEntity<String>get(){
            return new ResponseEntity<String>("Ram executed the get method",HttpStatus.OK);
          }
          @Autowired
          private MyService myService;
          @PostMapping("/insert")
       public ResponseEntity<String>post(@RequestBody Mydto dto){
                myService.add(dto);
                return new ResponseEntity<String>("ram executed the post method",HttpStatus.CREATED);

          }
           @DeleteMapping("/delete/{id}")
           public ResponseEntity<String> delete(@PathVariable int id){
              myService.delete(id);
              return new ResponseEntity<String>("Using path variable Delete Sucessfully:",HttpStatus.OK);
           }
           @DeleteMapping("/delete2")
         public ResponseEntity<String> deleteReParam(@RequestParam int id){
              myService.delete(id);
              return new ResponseEntity<String>("Using Requestparam  Delete Sucessfully:",HttpStatus.OK);
           }
         @PutMapping("/put/{id}")
         public ResponseEntity<String> put(@RequestBody Mydto dto,@PathVariable int id){
              Mydto obj=myService.update(dto,id);
          return new ResponseEntity<String>("update Sucessfully:",HttpStatus.OK);
         }
    }

