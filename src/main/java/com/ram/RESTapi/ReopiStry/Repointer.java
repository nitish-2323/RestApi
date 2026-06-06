package com.ram.RESTapi.ReopiStry;

import com.ram.RESTapi.Model.Mydto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface Repointer  extends JpaRepository<Mydto,Integer> {
}
