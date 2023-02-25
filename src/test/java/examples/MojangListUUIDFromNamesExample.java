package examples;

import cc.happyareabean.mojangapi.MojangAPI;

import java.util.Arrays;
import java.util.List;

public class MojangListUUIDFromNamesExample {

    public static void main(String[] args) throws Exception {
        List<String> names = Arrays.asList("Sk1er", "prplz");

        System.out.println("------ Names -> UUID -----");
        for (String name : names) {
            System.out.printf("(%s) UUID is (%s)%n", name, MojangAPI.getUUID(name));
        }
        System.out.println("--------------------------\n");

        System.out.println("------ Names -> UUID (UUIDsMap) -----");
        MojangAPI.getUUIDsMap(names).forEach((name, uuid) -> {
            System.out.printf("(%s) UUID is (%s)%n", name, uuid);
        });
        System.out.println("--------------------------\n");
    }
}
