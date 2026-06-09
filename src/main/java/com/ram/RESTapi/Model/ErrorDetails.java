package com.ram.RESTapi.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
        private int status;
        private String msg;
        private LocalDateTime dateTime;
        private String path;

}
