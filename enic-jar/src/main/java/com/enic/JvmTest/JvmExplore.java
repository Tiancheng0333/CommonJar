package com.enic.JvmTest;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class JvmExplore {


    public static void main(String[] args) {
        method1();
    }

    public static int method1() {

        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(Arrays.toString(twoSum1(new int[]{2, 7, 11, 15}, 13)));
        String s="<h4>机票张数可能不对！请核对是否选错了？</h4></br><divstyle='text-align:left;'>2021-03-26出发的航班一共占了4张机票，2021-03-30出发的航班一共占了4张机票，与出游需求不符，请确认是客人特殊需求，而非操作失误！</div>";
        StringTokenizer st=new StringTokenizer(s,"<h4></h4></br><divstyle='textalign:left;'></div>");
        String opStr="";
        String isBool="";
        while (st.hasMoreElements()) {
           opStr += st.nextElement(); // 取出分割符号之间的数据
      }
        opStr= opStr.substring(0, 18) + opStr.substring(19);
        System.out.println(opStr);
        System.out.println(opStr);
        String json="{\n" +
                "    \"flightIndiCheckFlag\": true,\n" +
                "    \"sameDepartDiffFlightFlag\": false,\n" +
                "    \"sameDepartDiffFlightChecks\": null,\n" +
                "    \"sameDepartDiffFlightMsg\": null,\n" +
                "    \"sameDepartOccuyFlag\": true,\n" +
                "    \"sameDepartOccupyChecks\": null,\n" +
                "    \"sameDepartOccupyMsg\": \"产品配置机票必选，尚未选择机票，是否要继续完成需求确认\",\n" +
                "    \"touristNum\": null\n" +
                "  }";
        JSONObject parse = (JSONObject)JSONObject.parse(json);
        String msg = (String)parse.get("sameDepartOccupyMsg");
        if(msg.startsWith("<")){
            System.out.println(1);
        }else {
            System.out.println(2);
        }
        return c;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] index = {1, 2};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (j > i) {
                    int value = nums[i] + nums[j];
                    if (value == target) {
                        index[0] = i;
                        index[1] = j;
                        return index;
                    }
                }
            }
        }
        return index;
    }
    public static int[] twoSum1(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }
}
