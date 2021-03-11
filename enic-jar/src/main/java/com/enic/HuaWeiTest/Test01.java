package com.enic.HuaWeiTest;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String opStr="";
        List<String> list=new ArrayList();
        StringTokenizer st=new StringTokenizer(str," ");
        while (st.hasMoreElements()) {
            list.add((String) st.nextElement());
        }
        for(int i=list.size()-1;i>=0;i--){
            opStr+=list.get(i)+" ";
        }
        System.out.println(opStr);
    }
}
