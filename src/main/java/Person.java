public class Person {
    private String id;
    private String name;

    public Person(String name, String id){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Id: " + this.id;
    }
}
