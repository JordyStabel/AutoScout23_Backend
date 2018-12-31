package autoscoutbackend.models;

import java.util.ArrayList;
import java.util.List;

public class JSONList<T> {

    private List<Car> cars;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public JSONList(){
        this.list = new ArrayList<>();
    }

    public void addItem(T item){
        this.list.add(item);
    }
}
