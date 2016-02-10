/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.utils;

import java.io.Serializable;

/**
 *
 * @author gaetan
 * @param <T>
 */
public class Message<T> implements Serializable{
    
    private String message;
    private boolean success;
    private T t;

    public Message() {
    }

    public Message(String message, boolean success, T t) {
        this.message = message;
        this.success = success;
        this.t = t;
    }

    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
    
    
}
