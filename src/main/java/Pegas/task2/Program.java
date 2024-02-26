package Pegas.task2;

public class Program {
    public static void main(String[] args) {
        Authentifier[] credentials = {new Authentifier("Ivan","1231da32d1asdafqwldka;lsdcms;lkfj;ksdnal","1231da32d1asdafqwldka;lsdcms;lkfj;ksdnal"),
                new Authentifier("Pavel","1231da32d1asdafqwldka;lsdcms;lkfj;ksdnal","1231da32d1asdafqwldka;lsdcms;lkfj;ksdna"),
                new Authentifier("Pavellllllllllllllllllllllllllllllllllllllllllllllllllll","1231da32d1asdafqwldka;lsdcms;lkfj;ksdnal","1231da32d1asdafqwldka;lsdcms;lkfj;ksdnal")};
        for(Authentifier i:credentials){
            try {
                SignInService.checkCredentials(i);
                System.out.println(i.login());
            } catch (WrongLoginException e) {
                System.out.println(e.getMessage()+" "+i.login());
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage()+" "+i.login());
            }
        }
    }
}
