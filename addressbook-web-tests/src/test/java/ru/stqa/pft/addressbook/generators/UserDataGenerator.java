package ru.stqa.pft.addressbook.generators;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UserDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main (String[] args) throws IOException {
        UserDataGenerator generator = new UserDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<UserData> users = generateUsers(count);
        if (format.equals("csv")) {
            saveAsCsv(users, new File(file));
        } else if (format.equals("xml")){
            saveAsXML(users, new File(file));
        } else if (format.equals("json")){
            saveAsJson(users, new File(file));
        } else {
            System.out.println("Unrecognized format: " + format);
        }
    }

    private void saveAsJson(List<UserData> users, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(users);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsXML(List<UserData> users, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(UserData.class);
        String xml = xstream.toXML(users);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<UserData> users, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (UserData user : users) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", user.getFirstname(), user.getLastname()
                        , user.getAddress1(), user.getAddress2(), user.getUsermail(), user.getEmail2(), user.getEmail3()
                        , user.getHomePhone(), user.getMobilePhone(), user.getWorkPhone(), user.getPhoto()));
            }
        }

    }

    private List<UserData> generateUsers(int count) {
        List<UserData> users = new ArrayList<UserData>();
        for (int i = 0; i < count; i++) {
            users.add(new UserData().withFirstname(String.format("Aleksandr %s", i)).withLastname(String.format("Petrov %s", i))
                    .withAddress1(String.format("Lenina street, %s", i)).withAddress2(String.format("Kirova street, %s", i))
                    .withUsermail(String.format("Aleksandr%s@mail.org", i)).withEmail2(String.format("Petrov%s@mail.org", i)).withEmail3(String.format("AleksPetrov%s@mail.org", i))
                    .withHomePhone(String.format("8-495-..-%s", i)).withMobilePhone(String.format("8-903-..-%s", i)).withWorkPhone(String.format("42-0%s", i))
                    .withPhoto(new File("src/test/resources/ph.png")));
        }
        return users;
    }


}
