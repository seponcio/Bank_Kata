public class BankAccount {
    private MovementController accountController;
    private MyConsole console;
    public BankAccount(MovementController accountController) {
        this.accountController = accountController;
        this.console = new MyConsole();
    }

    public void deposit(int amount) {
        this.accountController.addMovement(amount);

    }
    public void withdraw(int amount){
        this.accountController.addMovement(-amount);
    }
    public void printStatement(){
        accountController.printStatement();
        console.printLine("DATE       | AMOUNT  | BALANCE");

        console.printLine();
    }
}
