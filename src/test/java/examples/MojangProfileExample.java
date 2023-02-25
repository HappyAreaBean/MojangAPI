package examples;

import cc.happyareabean.mojangapi.MojangAPI;
import cc.happyareabean.mojangapi.profile.Cape;
import cc.happyareabean.mojangapi.profile.Profile;

import java.util.UUID;

public class MojangProfileExample {

    public static void main(String[] args) throws Exception {

        // They do the same thing, however two different ways to access them :)
        System.out.println("------Profile vai UUID-----");
        Profile uuidProfile = MojangAPI.getProfile(UUID.fromString("1a5c41c8-a952-4ddf-a19c-66f6bb3707a1"));
        Cape uuidCape = uuidProfile.getTextures().getCape();
        System.out.println("Username: " + uuidProfile.getUsername());
        System.out.println("ID: " + uuidProfile.getUniqueId());
        System.out.println("Skin URL: " + uuidProfile.getTextures().getSkin().getUrl());
        System.out.println("Cape URL: " + (uuidCape == null ? null : uuidCape.getUrl()));
        System.out.println("--------------------------\n");

        System.out.println("------Profile vai Username-----");
        Profile userProfile = MojangAPI.getProfile("prplz");
        Cape userCape = userProfile.getTextures().getCape();
        System.out.println("Username: " + userProfile.getUsername());
        System.out.println("ID: " + userProfile.getUniqueId());
        System.out.println("Skin URL: " + userProfile.getTextures().getSkin().getUrl());
        System.out.println("Cape URL: " + (userCape == null ? null : userCape.getUrl()));
        System.out.println("--------------------------\n");

    }
}
