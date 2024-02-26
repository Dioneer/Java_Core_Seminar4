package Pegas.task2;

public class SignInService {

    public static boolean checkCredentials(Authentifier authentifier) throws WrongLoginException, WrongPasswordException {
        boolean conf = authentifier.password().equals(authentifier.confirmPassword());
        int loginLength = authentifier.login().length();
        int password = authentifier.password().length();
        if(loginLength>=20){
            throw new WrongLoginException(loginLength);
        } else if(password<20 || !conf){
            throw new WrongPasswordException(password, conf);
        } else  return false;
    }

}
