package CollectionsTests;

import Classes.CollectionsDemo;
import Classes.Human;
import Classes.Student;
import org.junit.Test;

import java.util.*;

import static Classes.CollectionsDemo.intersection;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class Tests {
    @Test
    public void testLetter() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("asrtg");
        list.add("ahfgf gfdd d");
        list.add("oj aaaaaaa");
        list.add(" ");
        list.add("");
        list.add("aaaaaaaaaa");
        ArrayList<String> expect = new ArrayList<String>();
        expect.add("asrtg");
        expect.add("ahfgf gfdd d");
        expect.add("aaaaaaaaaa");
        CollectionsDemo demo = new CollectionsDemo();
        assertEquals(3, demo.getWithFirstSymbol('a', list));
    }

    @Test
    public void testSurnames() {
        ArrayList<Human> list = new ArrayList<Human>();
        list.add(new Human("Name", "Patronymic", "name", 25));
        list.add(new Human("Fjddv", "Patronymicp", "Surname", 2));
        list.add(new Human("fghfg", "Pat", "Surme", 45));
        list.add(new Human("opoij", "Patronymic", "Surname", 51));
        list.add(new Human("", "Patronymic", "", 19));
        list.add(new Human("Name", "jhgg", "Surname", 25));
        ArrayList<Human> expect = new ArrayList<Human>();
        expect.add(new Human("Fjddv", "Patronymicp", "Surname", 2));
        expect.add(new Human("opoij", "Patronymic", "Surname", 51));
        expect.add(new Human("Name", "jhgg", "Surname", 25));
        CollectionsDemo demo = new CollectionsDemo();
        assertArrayEquals(expect.toArray(), demo.getWithSameSurname(new Human(
                "Name", "jhgg", "Surname", 25), list).toArray());
    }

    @Test
    public void testDelete() {
        ArrayList<Human> list = new ArrayList<Human>();
        list.add(new Human("Name", "Patronymic", "name", 25));//
        list.add(new Human("Fjddv", "Patronymicp", "Surname", 2));
        list.add(new Human("fghfg", "Pat", "Surme", 45));
        list.add(new Human("opoij", "Patronymic", "Surname", 51));
        list.add(new Human("Name", "Patronymic", "name", 25));//
        list.add(new Human("Name", "jhgg", "Surname", 25));
        ArrayList<Human> expect = new ArrayList<Human>();
        expect.add(new Human("Fjddv", "Patronymicp", "Surname", 2));
        expect.add(new Human("fghfg", "Pat", "Surme", 45));
        expect.add(new Human("opoij", "Patronymic", "Surname", 51));
        expect.add(new Human("Name", "jhgg", "Surname", 25));
        CollectionsDemo demo = new CollectionsDemo();
        assertArrayEquals(expect.toArray(), demo.deleteHuman(new Human
                ("Name", "Patronymic", "name", 25), list).toArray());
    }

    @Test
    public void testIntersection() {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        HashSet<Integer> set3 = new HashSet<Integer>();
        HashSet<Integer> set4 = new HashSet<Integer>();
        HashSet<Integer> setThat = new HashSet<Integer>();
        Collections.addAll(set1, -19, 10, 34);
        Collections.addAll(set2, 1, 10, 34);
        Collections.addAll(set3, 10);
//        Collections.addAll(set4,  34);
        Collections.addAll(setThat, 1, 2, 3);

        List<Set<Integer>> a = new ArrayList<Set<Integer>>();
        Collections.addAll(a, set1, set1, set2, set3, set4, setThat);

        List<Set<Integer>> expected = new ArrayList<Set<Integer>>();
        Collections.addAll(expected, set1, set1, set3, set4);
        assertEquals(expected, intersection(a, setThat));
    }

    @Test
    public void testMaxAge() {
        ArrayList<Human> list = new ArrayList<Human>();
        list.add(new Human("Name", "Patronymic", "name", 25));
        list.add(new Human("Fjddv", "Patronymicp", "Surname", 2));
        list.add(new Student("fghfg", "Pat", "Surme", 13, "math"));
        list.add(new Human("opoij", "Patronymic", "Surname", 19));
        list.add(new Human("Name", "Patronymic", "name", 25));
        list.add(new Student("Name", "jhgg", "Surname", 25, "economics"));
        ArrayList<Human> expect = new ArrayList<Human>();
        expect.add(new Human("Name", "Patronymic", "name", 25));
        expect.add(new Human("Name", "Patronymic", "name", 25));
        expect.add(new Student("Name", "jhgg", "Surname", 25, "economics"));
        CollectionsDemo demo = new CollectionsDemo();
        assertArrayEquals(expect.toArray(), demo.getWithMaxAge(list).toArray());
    }

    @Test
    public void testMap() {
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        map.put(1, new Human("Name", "Patronymic", "name", 25));
        map.put(2, new Human("Fjddv", "Patronymicp", "Surname", 2));
        map.put(3, new Student("fghfg", "Pat", "Surme", 13, "math"));
        map.put(4, new Human("opoij", "Patronymic", "Surname", 19));
        map.put(5, new Human("Name", "Patronymic", "name", 25));
        map.put(-1, new Student("Name", "jhgg", "Surname", 25, "economics"));
        HashSet<Human> expect = new HashSet<Human>();
        expect.add(new Human("Name", "Patronymic", "name", 25));
        expect.add(new Student("fghfg", "Pat", "Surme", 13, "math"));
        expect.add(new Student("Name", "jhgg", "Surname", 25, "economics"));
        CollectionsDemo demo = new CollectionsDemo();
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(3);
        set.add(-1);
        assertArrayEquals(expect.toArray(), demo.getById(map, set).toArray());
    }

    @Test
    public void testGetOver18() {
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        map.put(1, new Human("Name", "Patronymic", "name", 25));
        map.put(2, new Human("Fjddv", "Patronymicp", "Surname", 2));
        map.put(3, new Student("fghfg", "Pat", "Surme", 13, "math"));
        map.put(4, new Human("opoij", "Patronymic", "Surname", 19));
        map.put(5, new Human("Name", "Patronymic", "name", 25));
        map.put(-1, new Student("Name", "jhgg", "Surname", 25, "economics"));
        CollectionsDemo demo = new CollectionsDemo();
        ArrayList<Integer> expect = new ArrayList<Integer>();
        expect.add(-1);
        expect.add(1);
        expect.add(4);
        expect.add(5);
        assertArrayEquals(expect.toArray(), demo.getIdOlder18(map).toArray());
    }

    @Test
    public void testMapIDAge() {
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        map.put(1, new Human("Name", "Patronymic", "name", 25));
        map.put(2, new Human("Fjddv", "Patronymicp", "Surname", 2));
        map.put(3, new Student("fghfg", "Pat", "Surme", 13, "math"));
        map.put(4, new Human("opoij", "Patronymic", "Surname", 19));
        CollectionsDemo demo = new CollectionsDemo();
        Map<Integer, Integer> expected = new HashMap<Integer, Integer>();
        expected.put(1, 25);
        expected.put(2, 2);
        expected.put(3, 13);
        expected.put(4, 19);
        assertEquals(expected, demo.getIdAgeMap(map));
    }

    @Test
    public void testMapLists() {
        Set<Human> set = new HashSet<Human>();
        set.add(new Human("Name", "Patronymic", "name", 25));
        set.add(new Human("Fjddv", "Patronymicp", "Surname", 19));
        set.add(new Student("fghfg", "Pat", "Surme", 19, "math"));
        set.add(new Human("opoij", "Patronymic", "Surname", 19));
        set.add(new Human("Name", "Patronymic", "naame", 25));
        set.add(new Student("Name", "jhgg", "Surname", 25, "economics"));
        CollectionsDemo demo = new CollectionsDemo();

        Map<Integer, List<Human>> expected = new HashMap<Integer, List<Human>>();
        ArrayList<Human> temp1 = new ArrayList<Human>();
        temp1.add(new Human("opoij", "Patronymic", "Surname", 19));
        temp1.add(new Student("fghfg", "Pat", "Surme", 19, "math"));
        temp1.add(new Human("Fjddv", "Patronymicp", "Surname", 19));


        ArrayList<Human> temp2 = new ArrayList<Human>();
        expected.put(19, temp1);
        temp2.add(new Human("Name", "Patronymic", "naame", 25));
        temp2.add(new Student("Name", "jhgg", "Surname", 25, "economics"));
        temp2.add(new Human("Name", "Patronymic", "name", 25));

        expected.put(25, temp2);
        demo.getMapAgeListHumans(set);
        assertEquals(expected, demo.getMapAgeListHumans(set));
    }
}
