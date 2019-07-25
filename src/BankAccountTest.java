import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class BankAccountTest {
    final int REGULARDEPOSITAMOUNT = 100;
    /*given a addMovement is performed, the amount is added to the account*/
    MovementController accountController;
    BankAccount ba;

    @Before
    public void init(){
        accountController  = new MovementController();
        ba = new BankAccount(accountController);
        ba.deposit(REGULARDEPOSITAMOUNT);
    }

    @Test
    public void depositShouldAddAmountToAccount(){

        assertTrue(accountController.getLastMovement().getAmount() == REGULARDEPOSITAMOUNT);
    }
    @Test
    public void withdrawShouldSubtractFromAccount(){
        ba.withdraw(REGULARDEPOSITAMOUNT);
        assertTrue(accountController.getLastMovement().getAmount() == -REGULARDEPOSITAMOUNT);
    }

    @Test
    public void printStatementShouldDisplayAllMovements(){
        MyConsole myConsole = Mockito.mock(MyConsole.class);
        ba.withdraw(REGULARDEPOSITAMOUNT);
        ba.printStatement();
        verify(myConsole).printLine("DATE       | AMOUNT  | BALANCE");
        verify(myConsole).printLine(LocalDate.now() +  "     | " + REGULARDEPOSITAMOUNT +"  | " + REGULARDEPOSITAMOUNT);
        verify(myConsole).printLine(LocalDate.now() + " DATE       | " + (-REGULARDEPOSITAMOUNT) + "  | 0");
    }
}