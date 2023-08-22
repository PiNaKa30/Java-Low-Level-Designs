package state;

public interface State {

    void showMenu();
    void onSuccess();
    void onFailure();
    void onCancel();

}
