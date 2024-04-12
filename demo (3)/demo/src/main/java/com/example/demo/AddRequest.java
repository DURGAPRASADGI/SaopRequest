package com.example.demo;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "AddRequest", namespace = "http://example.com/calculator")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddRequest {

    @XmlElement(name = "number1", namespace = "http://example.com/calculator")
    private int number1;

    @XmlElement(name = "number2", namespace = "http://example.com/calculator")
    private int number2;

    // Getter and setter methods
    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }
}


