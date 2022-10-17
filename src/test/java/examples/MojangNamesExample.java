package examples;

import me.kbrewster.mojangapi.MojangAPI;

import java.util.UUID;

public class MojangNamesExample {

    public static void main(String[] args) throws Exception {
        System.out.println("------Name -> UUID-----");
        String username = MojangAPI.getName(UUID.fromString("8233b1e5-bd74-441b-aa34-ee812263cca9"));
        System.out.println("UUID (8233b1e5-bd74-441b-aa34-ee812263cca9) is " + username);
        System.out.println("--------------------------\n");

        System.out.println("------UUID -> Username-----");
        UUID uuid = MojangAPI.getUUID("Sk1er");
        System.out.println("Sk1ers UUID is " + uuid);
        System.out.println("--------------------------\n");

    }
}
