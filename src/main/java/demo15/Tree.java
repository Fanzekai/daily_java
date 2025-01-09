package demo15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/1  21:16
 */
class Tree<T> {
    private T id;
    private T parentId;
    private String name;
    private int weight;
    private List<Tree<T>> children = new ArrayList<>();
    private Map<String, Object> extra = new HashMap<>();

    // Getters and setters

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getParentId() {
        return parentId;
    }

    public void setParentId(T parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }

    public void putExtra(String key, Object value) {
        extra.put(key, value);
    }

    public Map<String, Object> getExtra() {
        return extra;
    }
}
