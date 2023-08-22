package state;

import entity.AtmMachine;

public class AmountReadState implements State{

    private final AtmMachine atmMachine;

    public AmountReadState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void showMenu() {
        System.out.println("Enter Amount (0 to abort)");
        double amount = AtmMachine.scanner.nextDouble();
        if(amount == 0){
            onCancel();
        } else if(isAmountValid(amount)){
            onSuccess();
        } else {
            onFailure();
        }
    }

    @Override
    public void onSuccess() {
        System.out.println("[SUCCESS] Amount withdrawn");
        this.atmMachine.setState(new ReadyState(this.atmMachine));
    }

    @Override
    public void onFailure() {
        System.out.println("[FAILURE] Invalid Amount");
        showMenu();
    }

    @Override
    public void onCancel() {
        System.out.println("[ABORT] User cancelled operation");
        this.atmMachine.setState(new ReadyState(this.atmMachine));
    }

    private boolean isAmountValid(double amount){
        // Some validation logic here
        return amount < 100;
    }

}
