package com.ram.RESTapi.ReopiStry;

import com.ram.RESTapi.Model.Mydto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<Mydto,Integer> {
     Mydto findByUsername(String username);
}
