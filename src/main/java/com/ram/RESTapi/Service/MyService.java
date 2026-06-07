package com.ram.RESTapi.Service;

import com.ram.RESTapi.Model.Mydto;
import com.ram.RESTapi.ReopiStry.Repointer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    private Repointer repo;


    public Mydto add(Mydto dto) {
         return repo.save(dto);

    }

    public void delete(int id) {
        repo.deleteById(id);
    }


    public Mydto update(Mydto dto, int id) {
       Mydto obj = repo.findById(id).orElse(null);
       if(obj!=null){
           obj.setName(dto.getName());
           return  repo.save(obj);
       }
       return  null;
    }

    public Mydto save(Mydto dto) {
        Mydto obj  =repo.save(dto);
        return obj;
    }
}
