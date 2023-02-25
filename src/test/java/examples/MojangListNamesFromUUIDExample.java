package examples;

import cc.happyareabean.mojangapi.MojangAPI;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MojangListNamesFromUUIDExample {

    public static void main(String[] args) throws Exception {
        List<String> uuids = Arrays.asList("8233b1e5-bd74-441b-aa34-ee812263cca9", "1a5c41c8-a952-4ddf-a19c-66f6bb3707a1");

        System.out.println("------ UUID -> Names -----");
        for (String uuid : uuids) {
            System.out.printf("UUID (%s) is (%s)%n", uuid, MojangAPI.getName(UUID.fromString(uuid)));
        }
        System.out.println("--------------------------\n");
    }
}
