package pl.mateusz.engine;

import java.util.ArrayList;
import java.util.List;

public class Users {
    List <Calculator> users = new ArrayList<Calculator>();

    public void addUser(Calculator cal){
        users.add(cal);
    }
    public List<Calculator> getUsers(){
        return users;
    }
}
