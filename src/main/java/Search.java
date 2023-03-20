import java.util.HashMap;
import java.util.HashSet;

public class Search {

    private final static String[] delimiter = {",", " ; "};
    static HashMap<String, HashSet<Person>> cityHashMap = new HashMap<>();
    static HashMap<String, HashSet<String>> idHashMap = new HashMap<>();

    public static void search(String line, String searchCriteria, String searchValue, char formatType){
        if(line.contains(searchValue)){
            int index = Character.getNumericValue(formatType) - 1;
            String splitter = delimiter[index];

            String[] data = line.split(splitter);
            String name = data[0].substring(2);
            String city = data[1];
            String id = data[2];

            switch (searchCriteria){
                case "CITY":
                    if(cityHashMap.containsKey(searchValue)){
                        cityHashMap.get(searchValue).add(new Person(name, id));
                    } else {
                        HashSet<Person> personHashSet = new HashSet<>();
                        personHashSet.add(new Person(name, id));
                        cityHashMap.put(searchCriteria, personHashSet);
                    }

                    for (Person _person : cityHashMap.get((searchCriteria))) {
                        System.out.println(_person);
                    }
                    break;

                case "ID":
                    if(idHashMap.containsKey(searchCriteria)){
                        idHashMap.get(searchCriteria).add(city);
                    } else {
                        HashSet<String> stringHashSet = new HashSet<>();
                        stringHashSet.add(city.toUpperCase());
                        idHashMap.put(searchCriteria, stringHashSet);
                    }

                    for (String _city : idHashMap.get(searchCriteria)) {
                        System.out.println("CITY: " + _city);
                    }
                    break;
            }
        }
    }
}
