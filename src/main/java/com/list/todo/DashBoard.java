package com.list.todo;

public class DashBoard {
    private int id;
    private String name;
    private Long countTask;

    public DashBoard(int id, String name, Long countTask) {
        this.id = id;
        this.name = name;
        this.countTask = countTask;
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

    public Long getCountTask() {
        return countTask;
    }

    public void setCountTask(Long countTask) {
        this.countTask = countTask;
    }
}

