package com.enic.HuaWeiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test03 {
    public static void main(String[] args) throws Exception {
        test02();
        }

        public static void test02() throws IOException {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            int v = Integer.parseInt(bf.readLine());
            int count=0;
            while (v!=0){
                if(v%2==1){
                    count++;
                }
                v=v/2;
            }
            System.out.println(count);

        }

        public void test01() throws IOException {
            InputStream stream = System.in;
            int l;
            byte[] bytes = new byte[1024];
            while ((l = stream.read(bytes)) > 0) {
                String numStr = new String(bytes, 0, l - 1);
                int num = Integer.parseInt(numStr);
                char[] numChars = Integer.toBinaryString(num).toCharArray();
                int countNum = 0;
                for (int i = 0; i < numChars.length; i++) {
                    if (numChars[i] == '1') {
                        countNum = countNum + 1;
                    }
                }
                System.out.println(countNum);
            }
        }

    }


