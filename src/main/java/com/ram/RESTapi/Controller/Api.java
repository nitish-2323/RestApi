package com.ram.RESTapi.Controller;


import com.ram.RESTapi.Execption.usernotFoundExecption;
import com.ram.RESTapi.Model.Mydto;
import com.ram.RESTapi.Model.RepoDto;
import com.ram.RESTapi.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
                if(true) {
                    throw  new RuntimeException();
                }
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
           //user not found execption in put
         @PutMapping("/put/{id}")
         public ResponseEntity<String> put(@RequestBody Mydto dto,@PathVariable int id){
              Mydto obj=myService.update(dto,id);
              if(obj==null){
                  throw new usernotFoundExecption("user not found");
              }
          return new ResponseEntity<String>("update Sucessfully:",HttpStatus.OK);
         }
     @Autowired
     private RepoDto repoDto;
     @PostMapping("/postDTO")
     public ResponseEntity<RepoDto> object(@RequestBody Mydto dto){
             Mydto obj = myService.save(dto);
             repoDto.setError(false);
             repoDto.setMsg("ram executed the post method");
             repoDto.setStatusCode(HttpStatus.CREATED.value());
             List<Mydto> mydtoList = new ArrayList<>();
             mydtoList.add(obj);
             repoDto.setMydtos(mydtoList);
             return  new ResponseEntity<RepoDto>(repoDto,HttpStatus.CREATED);
     }
    }

