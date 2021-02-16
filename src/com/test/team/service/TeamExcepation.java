package com.test.team.service;

public class TeamExcepation extends Exception {
    static final long serialVersionUID = -3387516993123423248L;

    public TeamExcepation() {
        super();
    }

    public TeamExcepation(String message) {
        super(message);
    }
}
