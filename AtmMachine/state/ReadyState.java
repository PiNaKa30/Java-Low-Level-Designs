package state;

import entity.AtmMachine;

public class ReadyState implements State{

    private final AtmMachine atmMachine;

    public ReadyState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void showMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("Press Enter to continue");
        AtmMachine.scanner.nextLine();
        onSuccess();
    }

    @Override
    public void onSuccess() {
        this.atmMachine.setState(new CardReadState(this.atmMachine));
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onCancel() {

    }
}
