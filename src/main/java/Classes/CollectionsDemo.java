package Classes;

import java.util.*;

public class CollectionsDemo {
    public static int getWithFirstSymbol(char symbol, List<String> stringList) {
        List<String> ans = new ArrayList<String>();
        for (String s : stringList) {
            if (!"".equals(s) && symbol == s.charAt(0))
                ans.add(s);
        }
        return ans.size();
    }

    public static List<Human> getWithSameSurname(Human person, List<Human> humanList) {
        List<Human> ans = new ArrayList<Human>();
        for (int i = 0; i < humanList.size(); ++i) {
            if (person.getSurname().equals(humanList.get(i).getSurname()))
                ans.add(humanList.get(i));
        }
        return ans;
    }

    public static List<Human> deleteHuman(Human person, List<Human> humanList) {
        List<Human> ans = new ArrayList<Human>();
        for (int i = 0; i < humanList.size(); ++i) {
            if (!(person.equals(humanList.get(i))))
                ans.add(humanList.get(i));
        }
        return ans;
    }

    public static List<Set<Integer>> intersection(List<Set<Integer>> a, Set<Integer> b) {
        List<Set<Integer>> ans = new ArrayList<Set<Integer>>();
       // Set<Integer> bcopy = new HashSet<Integer>(b);
        for (Set<Integer> integers : a) {
            if (Collections.disjoint(b,integers)) {
                ans.add(integers);
               // bcopy.remove(integers);
            }
        }
        return ans;
    }



    public static List<Human> getWithMaxAge(List<Human> people) {
        int m = -1;
        for (Human person : people) {
            if (person.getAge() > m) {
                m = person.getAge();
            }
        }
        List<Human> ans = new ArrayList<Human>();
        for (Human person : people) {
            if (person.getAge() == m)
                ans.add(person);
        }
        return ans;
    }

    public static Set<Human> getById(Map<Integer, Human> map, Set<Integer> set) {
        Set<Human> ans = new HashSet<Human>();
        for (Integer i : set) {
            if (map.containsKey(i)) {
                ans.add(map.get(i));
            }
        }
        return ans;
    }

    public static List<Integer> getIdOlder18(Map<Integer, Human> map) {
        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Human> person : map.entrySet()) {
            if (person.getValue().getAge() > 17) {
                ans.add(person.getKey());
            }
        }

        return ans;
    }

    public static Map<Integer, Integer> getIdAgeMap(Map<Integer, Human> map) {
        Map<Integer, Integer> ans = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Human> person : map.entrySet()) {
            ans.put(person.getKey(), person.getValue().getAge());
        }
        return ans;
    }

    public static Map<Integer, List<Human>> getMapAgeListHumans(Set<Human> set) {
       // Set<Human> set = new HashSet<Human>(humanSet);
        Map<Integer, List<Human>> ans = new HashMap<Integer, List<Human>>();

        for (Human human : set) {
            if(!ans.containsKey(human.getAge())) {
                ans.put(human.getAge(), new ArrayList<Human>());
            }

                ans.get(human.getAge()).add(human);
        }
        return ans;
    }
}
