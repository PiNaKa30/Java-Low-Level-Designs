package state;

import entity.AtmMachine;

public class CardReadState implements State{

    private final AtmMachine atmMachine;

    public CardReadState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void showMenu() {
        System.out.println("Enter card number (0 to abort)");
        String cardNumber = AtmMachine.scanner.nextLine();
        if(cardNumber.equals("0")){
            onCancel();
        } else if(isCardValid(cardNumber)){
            onSuccess();
        } else {
            onFailure();
        }
    }

    @Override
    public void onSuccess() {
        System.out.println("[SUCCESS] Card Accepted");
        this.atmMachine.setState(new PinReadState(this.atmMachine));
    }

    @Override
    public void onFailure() {
        System.out.println("[FAILURE] Invalid card number");
        showMenu();
    }

    @Override
    public void onCancel() {
        System.out.println("[ABORT] User cancelled operation");
        this.atmMachine.setState(new ReadyState(this.atmMachine));
    }

    private boolean isCardValid(String cardNumber) {
        // Some validation logic here
        return cardNumber.length() == 8;
    }

}
