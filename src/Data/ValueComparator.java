/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author curtyl
 */
        class ValueComparator implements Comparator<String> {
    
            Map<String, Integer> map;
            
            public ValueComparator(Map<String,Integer> base) {
                this.map = base;
            }

            public int compare(String a, String b) {
               if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } 
    }
}

