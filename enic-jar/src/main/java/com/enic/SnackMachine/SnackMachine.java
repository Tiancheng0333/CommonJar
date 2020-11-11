package com.enic.SnackMachine;

import java.util.ArrayList;

public class SnackMachine {
    private ArrayList<PackOfCrisps> crisps;
    private int capacityMax;
    private int cost;
    private int price;
    private ArrayList<Penny> pennies;

    //初始化
    public SnackMachine(int capacityMax,int cost){
        this.crisps=new ArrayList<>();
        this.capacityMax=capacityMax;
        this.cost=cost;
        this.price=0;
        this.pennies=new ArrayList<>();
    }

    //返回成本
    public int getCost() {
        return cost;
    }

    //上货
    public void addPack(PackOfCrisps pack){
        if(crisps.size()>=capacityMax){
            System.out.println("当前零食机内已满啦，无需添加");
            return;
        }
        crisps.add(pack);
    }

    //返回零食机中指定口味的数量
    public int countPacks(String flavour){
        int count=0;
        for (PackOfCrisps crisp : crisps) {
            if(crisp.getFlavour().equals(flavour)){
                count++;
            }
        }
        return count;
    }

    //投币
    public void insertMoney(Penny penny){
        price++;
        System.out.println("投币成功，当前已投入"+price+"枚便士");
    }

    //投币买薯片
    public PackOfCrisps buyPack(String flavour){
        boolean isFlavour=false;
        int index=0;
        PackOfCrisps packOfCrisps=null;
        for (int i = 0; i < crisps.size(); i++) {
            if(crisps.get(i).getFlavour().equals(flavour)){
                isFlavour=true;
                packOfCrisps=crisps.get(i);
                index=i;
            }
        }
        if(!isFlavour){
            System.out.println("当前无此风味薯片，请选择其他口味～");
            return null;
        }
        int isEnough = (price < cost) ? -1 : (price == cost) ? 0 : 1;
        if(isEnough==-1){
            System.out.println("您还需要投入"+(cost-price)+"枚便士～");
            return null;
        }
        crisps.remove(index);
        price=0;
        System.out.println("咚咚咚 你的"+flavour+"薯片在下方请拿取:");
        return packOfCrisps;
    }

    //打印当前状态
    public void describe(){
        System.out.println("当前零食机还有"+crisps.size()+"包薯片,"+"并已付了"+price+"便士");
    }

    public ArrayList<PackOfCrisps> getCrisps() {
        return crisps;
    }

    public void setCrisps(ArrayList<PackOfCrisps> crisps) {
        this.crisps = crisps;
    }

    public int getCapacityMax() {
        return capacityMax;
    }

    public void setCapacityMax(int capacityMax) {
        this.capacityMax = capacityMax;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Penny> getPennies() {
        return pennies;
    }

    public void setPennies(ArrayList<Penny> pennies) {
        this.pennies = pennies;
    }
}
