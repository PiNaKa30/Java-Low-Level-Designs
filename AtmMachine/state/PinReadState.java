package state;

import entity.AtmMachine;

public class PinReadState implements State{

    private final AtmMachine atmMachine;

    public PinReadState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void showMenu() {
        System.out.println("Enter PIN (0 to abort)");
        int pin = AtmMachine.scanner.nextInt();
        if(pin == 0){
            onCancel();
        } else if(isPinValid(pin)){
            onSuccess();
        } else {
            onFailure();
        }
    }

    @Override
    public void onSuccess() {
        System.out.println("[SUCCESS] PIN Accepted");
        this.atmMachine.setState(new AmountReadState(this.atmMachine));
    }

    @Override
    public void onFailure() {
        System.out.println("[FAILURE] Invalid PIN");
        showMenu();
    }

    @Override
    public void onCancel() {
        System.out.println("[ABORT] User cancelled operation");
        this.atmMachine.setState(new ReadyState(this.atmMachine));
    }

    private boolean isPinValid(int pin) {
        // Some validation logic here
        return pin > 999 && pin < 10000;
    }

}
