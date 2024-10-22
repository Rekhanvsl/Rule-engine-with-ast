package ast;

import java.util.Map;

public class UserData {
    private Map<String, Integer> data;

    public UserData(Map<String, Integer> data) {
        this.data = data;
    }

    public int getFieldValue(String field) {
        return data.getOrDefault(field, 0);
    }
}
