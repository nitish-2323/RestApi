package com.ram.RESTapi.Execption;

public class usernotFoundExecption extends  RuntimeException{
    public usernotFoundExecption(String msg){
        super(msg);
    }
}
