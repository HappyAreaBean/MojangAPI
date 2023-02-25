package cc.happyareabean.mojangapi;

import cc.happyareabean.mojangapi.api.API;
import cc.happyareabean.mojangapi.api.exceptions.APIException;
import cc.happyareabean.mojangapi.api.exceptions.InvalidPlayerException;
import cc.happyareabean.mojangapi.profile.Profile;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Allows access to the MojangAPI
 * Full Documentation of API found here: http://wiki.vg/Mojang_API
 */
@API.Reference(apiName = "Mojang API", apiVersion = "3.0.0")
public class MojangAPI extends API {

    private final static String BASE_URL = "https://api.ashcon.app/mojang/v2/user/";

    private final static Pattern STRIPPED_UUID_PATTERN = Pattern.compile("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})");
    private final static Pattern UUID_PATTERN = Pattern.compile("(\\w{8})-(\\w{4})-(\\w{4})-(\\w{4})-(\\w{12})");

    /**
     * Gets player profile
     * @param uuid
     * @return {@link Profile}
     * @throws IOException
     * @throws APIException
     */
    public static Profile getProfile(UUID uuid) throws IOException, APIException {
        String json = sendGet(BASE_URL + stripDashes(uuid));
        JsonElement jsonElement = new JsonParser().parse(json);
        if (jsonElement.isJsonNull()) throw new APIException("This shouldn't happen");
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.get("error") instanceof JsonNull)
            throw new APIException(jsonObject.get("errorMessage").getAsString());
        return new Gson().fromJson(jsonObject, Profile.class);
    }

    /**
     * Gets player profile
     * @param username
     * @return {@link Profile}
     * @throws IOException
     * @throws APIException
     */
    public static Profile getProfile(String username) throws IOException, APIException {
        String json = sendGet(BASE_URL + username);
        JsonElement jsonElement = new JsonParser().parse(json);
        if (jsonElement.isJsonNull()) throw new APIException("This shouldn't happen");
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.get("error") instanceof JsonNull)
            throw new APIException(jsonObject.get("errorMessage").getAsString());
        return new Gson().fromJson(jsonObject, Profile.class);
    }

    /**
     * Gets Minecraft Username from {@link UUID}
     * @param uuid UUID
     * @return Minecraft Username
     */
    public static String getName(UUID uuid) throws IOException, APIException {
        return getUsername(uuid);
    }

    /**
     * Gets Minecraft Username from {@link UUID}
     * @param uuid UUID
     * @return Minecraft Username
     */
    public static String getUsername(UUID uuid) throws IOException, APIException {
        return getProfile(uuid).getUsername();
    }

    /**
     * Strips away dashes from string
     * @param uuid
     * @return uuid w/o dashes
     */
    public static String stripDashes(String uuid) {
        return uuid.replaceAll("-", "");
    }

    /**
     * Strips away dashes from {@link java.util.UUID}
     * @param uuid
     * @return uuid w/o dashes
     */
    public static String stripDashes(UUID uuid) {
        return stripDashes(uuid.toString());
    }

    /**
     * Addes dashes to uuid String
     * @param uuid
     * @return
     */
    public static String addDashes(String uuid) {
        return STRIPPED_UUID_PATTERN.matcher(uuid).replaceAll("$1-$2-$3-$4-$5");
    }

    /**
     * Gets minecraft UUID from Username
     * @param username
     * @return uuid
     * @throws IOException
     * @throws APIException
     * @throws InvalidPlayerException
     */
    public static UUID getUUID(String username) throws IOException, APIException, InvalidPlayerException {
        return getProfile(username).getUniqueId();
    }

    /**
     * Gets minecraft UUID from Username return with Map
     * @param usernames
     * @return map with username as key and uuid as value
     * @throws InvalidPlayerException
     */
    public static Map<String, UUID> getUUIDsMap(List<String> usernames) throws InvalidPlayerException, APIException, IOException {
        Map<String, UUID> uuids = new HashMap<>();
        for (String names : usernames) {
            Profile profile = getProfile(names);
            if (profile.getCode() == 404) {
                throw new InvalidPlayerException();
            }
            uuids.put(names, profile.getUniqueId());
        }
        return uuids;
    }

    /**
     * Gets minecraft UUID from Username
     * @param usernames
     * @return uuid
     * @throws InvalidPlayerException
     */
    public static List<UUID> getUUIDs(List<String> usernames) throws InvalidPlayerException, APIException, IOException {
        List<UUID> uuids = new ArrayList<>();
        for (String names : usernames) {
            Profile profile = getProfile(names);
            if (profile.getCode() == 404) {
                throw new InvalidPlayerException();
            }
            uuids.add(profile.getUniqueId());
        }
        return uuids;
    }

    /**
     * Gets minecraft UUID from Username
     * @param usernames
     * @return uuid
     * @throws InvalidPlayerException
     */
    public static List<UUID> getUUIDs(String... usernames) throws InvalidPlayerException, APIException, IOException {
        List<UUID> uuids = new ArrayList<>();
        for (String names : usernames) {
            Profile profile = getProfile(names);
            if (profile.getCode() == 404) {
                throw new InvalidPlayerException();
            }
            uuids.add(profile.getUniqueId());
        }
        return uuids;
    }

}
