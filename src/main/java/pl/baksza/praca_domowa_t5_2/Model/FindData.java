package pl.baksza.praca_domowa_t5_2.Model;

public class FindData {
    private int id;
    private String name;
    private String findname;

    public FindData(int id, String name, String findname) {
        this.id = id;
        this.name = name;
        this.findname = findname;
    }

    public FindData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFindname() {
        return findname;
    }

    public void setFindname(String findname) {
        this.findname = findname;
    }

    @Override
    public String toString() {
        return "FindData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", findname='" + findname + '\'' +
                '}';
    }
}
