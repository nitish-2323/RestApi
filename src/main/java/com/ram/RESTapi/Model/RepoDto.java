package com.ram.RESTapi.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
public class RepoDto {
    private int statusCode;
    private boolean error;
    private String msg;
    private List<Mydto> mydtos;
}
