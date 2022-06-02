package com.example.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {

    @Test
    void contextLoads() {
        Solution solution = new Solution();
        ;
        System.out.println(solution.isMatch("aa","a*"));
    }
    class Solution {
        public boolean isMatch(String s, String p) {
            int right = 0;

            for(int i = 0; i < s.length(); i++){
                if(p.length() - 1  < i)
                    return false;
                if(s.charAt(i) == p.charAt(right)){
                    right++;
                    continue;
                }
                else if(String.valueOf(p.charAt(right)).equals("."))
                {
                    if(p.length() > right+1){
                        if(String.valueOf(p.charAt(right+1)).equals("*"))
                            return true;
                    }
                }
                else if (String.valueOf(p.charAt(right)).equals("*")){
                    right++;
                    continue;
                }
                else{
                    return false;
                }
            }
            return true;
        }
    }

}
