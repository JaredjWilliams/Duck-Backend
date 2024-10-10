package com.duck.project.config;

import com.duck.project.entities.Credentials;
import com.duck.project.entities.Duck;
import com.duck.project.entities.Profile;
import com.duck.project.entities.User;
import com.duck.project.repositories.DuckRepository;
import com.duck.project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final DuckRepository duckRepository;
    private static final Random random = new Random();

    private final List<String> names = Arrays.asList("Andres", "Charles", "Ben", "Brice", "Diego", "Dylan", "Jacob",
            "Kevin", "Krit", "Stanley", "Will", "William");

    @Override
    public void run(String... args) throws Exception {

        List<Duck> ducks = createDucks();
        List<User> users = createUsers();

        userRepository.saveAllAndFlush(users);
        duckRepository.saveAllAndFlush(ducks);

        for (Duck duck : ducks) {
            User randomUser = users.get(random.nextInt(users.size()));

            List<User> usersFound = getUsersFound(duck);
            usersFound.add(randomUser);
            duck.setUsersFound(usersFound);

            List<Duck> ducksFound = getDucksFound(randomUser);
            ducksFound.add(duck);
            randomUser.setDucks(ducksFound);
        }

        userRepository.saveAllAndFlush(users);
        duckRepository.saveAllAndFlush(ducks);
    }

    private List<User> getUsersFound(Duck duck) {
        List<User> users = duck.getUsersFound();

        return users != null && !users.isEmpty() ? users : new ArrayList<User>();
    }

    private List<Duck> getDucksFound(User user) {
        List<Duck> ducks = user.getDucks();

        return ducks != null && !ducks.isEmpty() ? ducks : new ArrayList<Duck>();
    }


    private List<Duck> createDucks() {
        ArrayList<Duck> ducks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ducks.add(createDuck());
        }

        return ducks;
    }

    private Duck createDuck() {
        Duck duck = new Duck();

        return duck;
    }

    private List<User> createUsers() {
        ArrayList<User> users = new ArrayList<>();

        for (String name : names) {
            Profile profile = createProfile(name, "Last");
            Credentials credentials = createCredentials();
            users.add(createUser(profile, credentials));
        }

        return users;
    }

    private User createUser(Profile profile, Credentials credentials) {
        User user = new User();

        user.setProfile(profile);
        user.setCredentials(credentials);

        return user;
    }

    private Credentials createCredentials() {
        Credentials credentials = new Credentials();

        credentials.setPassword("admin");
        credentials.setUsername("admin");

        return credentials;
    }

    private Profile createProfile(String firstName, String lastName) {
        Profile profile = new Profile();

        profile.setEmail(firstName + "." + lastName + "@gmail.com");
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setPhone("888-888-8888");

        return profile;
    }
}
