package app.util;

import app.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String USERS_DIR = "data/users/";

    static {
        File dir = new File(USERS_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static List<String> listUsers() {
        File dir = new File(USERS_DIR);
        String[] files = dir.list((d, name) -> name.endsWith(".dat"));
        List<String> usernames = new ArrayList<>();
        if (files != null) {
            for (String file : files) {
                usernames.add(file.substring(0, file.lastIndexOf('.')));
            }
        }
        return usernames;
    }

    public static boolean createUser(String username) {
        File userFile = new File(USERS_DIR + username + ".dat");
        if (userFile.exists()) return false; // user already exists

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userFile))) {
            out.writeObject(new User(username));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUser(String username) {
        File userFile = new File(USERS_DIR + username + ".dat");
        return userFile.delete();
    }

    public static User loadUser(String username) {
        File userFile = new File(USERS_DIR + username + ".dat");
        if (!userFile.exists()) return null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(userFile))) {
            return (User) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean saveUser(User user) {
        File userFile = new File(USERS_DIR + user.getUsername() + ".dat");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userFile))) {
            out.writeObject(user);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
