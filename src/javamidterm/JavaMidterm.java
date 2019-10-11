/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamidterm;

/**
 *
 * @author gravadorre_sd2023
 */
public class JavaMidterm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean main = true;
        String second;

        while (main) {
            String start = Menu.first();
            switch (start) {
                case "1":
                    Account.registrer();
                    break;
                case "2":
                    boolean loginmain =  true;
                    boolean login = Account.login();
                    while (loginmain) {
                        String user = Account.user;
                        if (login) {
                            System.out.println("Hi " +user);
                            String oper = Menu.main();
                            switch (oper) {
                                case "1":
                                    Operation.post(user);
                                case "2":
                                    System.out.println("=========================\n");
                                    Operation.retreive();
                                    System.out.println("=========================\n");
                                    break;
                                case "3":
                                    Operation.update();
                                    break;
                                case "4":
                                    Operation.delete();
                                    break;
                                case "5":
                                    System.out.println("Logout");
                                    loginmain = false;
                                    break;
                                default:
                                    System.out.println("Invalid");
                                    break;
                            }
                        } else {
                            System.out.println("Can not find log in info");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }

    }

}
