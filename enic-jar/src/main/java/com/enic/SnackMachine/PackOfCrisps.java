package com.enic.SnackMachine;

public class PackOfCrisps {
    private boolean open;
    private int numOfCrisps;
    private String flavour;

    //判断是否还有薯片
    public boolean isEmpty(){
        if(numOfCrisps==0){
            return true;
        }
        return false;
    }

    //判断是否打开 未打开返回false
    public boolean isClosed(){
        if(!open){
            return true;
        }
        return false;
    }
    public void open(){
        this.open=true;
    }

    //返回味道
    public String getFlavour() {
        return flavour;
    }

    //吃薯片
    public void eatCrisp(){
        if(!open||numOfCrisps==0){
            System.out.println("请打开数据包或已无薯片");
        }
        if(numOfCrisps>0){
            numOfCrisps--;
        }
    }

    public PackOfCrisps(String taste){
        this.flavour=taste;
        this.open=false;
        this.numOfCrisps=10;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getNumOfCrisps() {
        return numOfCrisps;
    }

    public void setNumOfCrisps(int numOfCrisps) {
        this.numOfCrisps = numOfCrisps;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "一包"+flavour+"有"+numOfCrisps+"片的薯片";
    }
}
