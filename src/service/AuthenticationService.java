package service;

import model.User;
import util.FileConstants;
import util.FileManager;
import util.IdGenerator;
import util.Messages;
import util.Validator;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {

    private List<User> users;

    /**
     * Loads existing users from file.
     */
    public AuthenticationService() {

        users = FileManager.loadData(
                FileConstants.USERS_FILE
        );

        if (users == null) {
            users = new ArrayList<>();
        }
    }

    /**
     * Registers a new user.
     *
     * @param fullName User name
     * @param email User email
     * @param phoneNumber User phone
     * @param password User password
     * @return true if registration successful
     */
    public boolean registerUser(String fullName,
                                String email,
                                String phoneNumber,
                                String password) {

        if (!Validator.isValidEmail(email)) {
            System.out.println(Messages.INVALID_EMAIL);
            return false;
        }

        if (!Validator.isValidPhoneNumber(phoneNumber)) {
            System.out.println(Messages.INVALID_PHONE);
            return false;
        }

        if (!Validator.isValidPassword(password)) {
            System.out.println(Messages.INVALID_PASSWORD);
            return false;
        }

        if (emailExists(email)) {
            System.out.println(Messages.USER_ALREADY_EXISTS);
            return false;
        }

        User user = new User(
                IdGenerator.generateUserId(),
                fullName,
                email,
                phoneNumber,
                password
        );

        users.add(user);

        FileManager.saveData(
                FileConstants.USERS_FILE,
                users
        );

        System.out.println(Messages.REGISTRATION_SUCCESS);

        return true;
    }

    /**
     * Authenticates user login.
     *
     * @param email Email
     * @param password Password
     * @return User object if login successful,
     *         otherwise null
     */
    public User login(String email,
                      String password) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)
                    && user.checkPassword(password)) {

                System.out.println(
                        Messages.LOGIN_SUCCESS
                );

                return user;
            }
        }

        System.out.println(
                Messages.LOGIN_FAILED
        );

        return null;
    }

    /**
     * Changes password.
     *
     * @param user Logged-in user
     * @param newPassword New password
     * @return true if password updated
     */
    public boolean changePassword(User user,
                                  String newPassword) {

        if (!Validator.isValidPassword(
                newPassword)) {

            System.out.println(
                    Messages.INVALID_PASSWORD
            );

            return false;
        }

        user.setPassword(newPassword);

        FileManager.saveData(
                FileConstants.USERS_FILE,
                users
        );

        System.out.println(
                Messages.PASSWORD_CHANGED
        );

        return true;
    }

    /**
     * Checks if email already exists.
     *
     * @param email Email to check
     * @return true if found
     */
    private boolean emailExists(String email) {

        for (User user : users) {

            if (user.getEmail()
                    .equalsIgnoreCase(email)) {

                return true;
            }
        }

        return false;
    }

    /**
     * Returns all registered users.
     *
     * @return users list
     */
    public List<User> getUsers() {
        return users;
    }
}
