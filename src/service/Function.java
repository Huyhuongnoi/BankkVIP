package service;

import dao.Implement.UserDAOImpl;
import dao.Implement.CardDAOImpl;
import model.Card;
import model.User;

import java.util.Objects;


public class Function {
    private static final float MAX = 2000000000;

    public void register(String username, String password, float balance, String fullName,
                         int age, String sex, String address) {

        boolean flag = UserDAOImpl.getInstance().CheckExistence(username);
        if (flag) {
            System.out.println("This account has already existed!");
            return;
        }
        User user = new User(username, fullName, age, sex, address);
        Card card = new Card(username, password, balance);
        if (card.getBalance() > MAX) {
            return;
        }
        UserDAOImpl.getInstance().insert(user);
        CardDAOImpl.getInstance().insert(card);
        System.out.println("Sign Up Success!");
    }

    public boolean login(String username, String passWord) {
        Card card = CardDAOImpl.getInstance().selectById(username);
        if (card == null) {
            return false;
        }
        if (Objects.equals(card.getPassword(), passWord)) {
            System.out.println("Logged in successfully!");
            return true;
        }
        return false;
    }

    public void transfer(String userName, String recipientAccount, float amountOfMoney) {
        Card card = CardDAOImpl.getInstance().selectById(userName);
        Card recipientCard = CardDAOImpl.getInstance().selectById(recipientAccount);
        if (recipientCard == null) {
            System.out.println("The card is not valid");
            return;
        }
        float newRecipientBalance = recipientCard.getBalance() + amountOfMoney;
        recipientCard.setBalance(newRecipientBalance);
        float newBalance = card.getBalance() - amountOfMoney;
        card.setBalance(newBalance);
        if (card.getBalance() > MAX || recipientCard.getBalance() > MAX) {
            return;
        }
        CardDAOImpl.getInstance().update(card);
        CardDAOImpl.getInstance().update(recipientCard);
        System.out.println("Transfer money successfully!");
    }

    public User viewAccountInformation(String userName) {
        return UserDAOImpl.getInstance().selectById(userName);
    }

    public void changePassWord(String userName, String oldPassWord, String newPassWord) {
        Card card = CardDAOImpl.getInstance().selectById(userName);
        if (Objects.equals(card.getPassword(), oldPassWord)) {
            card.setPassword(newPassWord);
            CardDAOImpl.getInstance().update(card);
            System.out.println("changed password successfully!");
            return;
        }
        System.out.println("Password entered is incorrect!");
    }
}
