package Pegas.homework;

import Pegas.homework.exception.ExecutedException;
import Pegas.homework.exception.IllegalArgumentException;
import Pegas.homework.exception.InsufficientFundsException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreditAccount creditAccount = new CreditAccount();
        DebitAccount debitAccount = new DebitAccount();
        boolean flag = true;
        while (flag){
            System.out.println("Выберите один из следующих пунктов(укажите цифру): \n1.Пополнить баланс через кредитный счет;\n" +
                    "2.Пополнить депозит через кредитный счет;\n" +
                    "3.Снять деньги через кредитный счет;\n4.ополнить баланс через дебетовый счет;\n5.Пополнить депозит через дебетовый счет;\n" +
                    "6.Снять деньги через дебетовый счет;\n7.Перевести деньги с дебетового счет на кредитный;\n8.Первести деньги с кредитного счета на дебетовый;" +
                    "\n9.Выйти из меню");
            try {
                if (scanner.hasNext()) {
                    int key = Integer.parseInt(scanner.nextLine());
                    switch (key) {
                        case 1:
                            System.out.println("Введите сумму: ");
                            double summ = Double.parseDouble(scanner.nextLine());
                            creditAccount.createAmount(summ);
                            break;
                        case 2:
                            System.out.println("Введите сумму: ");
                            summ = Double.parseDouble(scanner.nextLine());
                            creditAccount.createDeposit(summ);
                            break;
                        case 3:
                            System.out.println("Введите сумму: ");
                            summ = Double.parseDouble(scanner.nextLine());
                            double count = creditAccount.withdrawal(summ);
                            System.out.println("You have " + count + " on your credit account");
                            break;
                        case 4:
                            System.out.println("Введите сумму: ");
                            summ = Double.parseDouble(scanner.nextLine());
                            debitAccount.createAmount(summ);
                            break;
                        case 5:
                            System.out.println("Введите сумму: ");
                            summ = Double.parseDouble(scanner.nextLine());
                            debitAccount.createDeposit(summ);
                            break;
                        case 6:
                            System.out.println("Введите сумму: ");
                            summ = Double.parseDouble(scanner.nextLine());
                            count = debitAccount.withdrawal(summ);
                            System.out.println("You have " + count+ " on your debit account");
                            break;
                        case 7:
                            System.out.println("Введите сумму: ");
                            summ = Double.parseDouble(scanner.nextLine());
                            Transaction<CreditAccount, DebitAccount> transaction1 = new Transaction<>(creditAccount,debitAccount, summ);
                            count = transaction1.executedDToC();
                            System.out.println("You have " + count + " on your credit account");
                            break;
                        case 8:
                            System.out.println("Введите сумму: ");
                            summ = Double.parseDouble(scanner.nextLine());
                            Transaction<CreditAccount, DebitAccount> transaction2 = new Transaction<>(creditAccount,debitAccount, summ);
                            count = transaction2.executedCToD();
                            System.out.println("You have " + count+ " on your debit account");
                            break;
                        case 9:
                            System.out.println("Пока!");
                            flag = false;
                            scanner.close();
                            break;
                        default:
                            System.out.println("Мимо!");
                    }
                }

                    } catch (NumberFormatException e) {
                        System.out.println("Not a number");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                } catch (ExecutedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
