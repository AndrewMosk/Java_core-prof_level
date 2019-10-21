package Lesson_1.Task_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class TestList {
    private List<Test> testList;

    TestList(Test... arguments) {
        testList = Arrays.asList(arguments);
    }

    HashMap convertToHashMap() {
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        testList.forEach(testItem->{
            if (hashMap.containsKey(testItem.getName())){
                hashMap.get(testItem.getName()).add(testItem.getId());
            }else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(testItem.getId());
                hashMap.put(testItem.getName(),arrayList);
            }
        });

        return hashMap;
    }
}
