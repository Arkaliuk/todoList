package com.list.todo;

import java.util.List;

public class DashBoardInfo {
    private int countTaskToday;
    private List<DashBoard> dashBoardLists;

    public DashBoardInfo(int countTaskToday, List<DashBoard> dashBoardLists) {
        this.countTaskToday = countTaskToday;
        this.dashBoardLists = dashBoardLists;
    }

    public int getCountTaskToday() {
        return countTaskToday;
    }

    public void setCountTaskToday(int countTaskToday) {
        this.countTaskToday = countTaskToday;
    }

    public List<DashBoard> getDashBoardLists() {
        return dashBoardLists;
    }

    public void setDashBoardLists(List<DashBoard> dashBoardLists) {
        this.dashBoardLists = dashBoardLists;
    }
}
