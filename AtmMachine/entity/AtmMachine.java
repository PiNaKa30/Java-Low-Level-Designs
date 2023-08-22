package entity;

import state.ReadyState;
import state.State;

import java.util.Scanner;

public class AtmMachine {

    private State state;
    public static final Scanner scanner = new Scanner(System.in);

    public AtmMachine() {
        this.state = new ReadyState(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        this.state.showMenu();
    }

    public void start(){
        this.state.showMenu();
    }
}
