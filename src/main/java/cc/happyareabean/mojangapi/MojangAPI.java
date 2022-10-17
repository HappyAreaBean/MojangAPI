package cc.happyareabean.mojangapi;

import cc.happyareabean.API;
import cc.happyareabean.exceptions.APIException;
import cc.happyareabean.exceptions.InvalidPlayerException;
import cc.happyareabean.mojangapi.profile.Profile;
import cc.happyareabean.mojangapi.profile.UsernameHistory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cc.happyareabean.mojangapi.stats.MetricKeys;
import cc.happyareabean.mojangapi.stats.MojangStatistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Allows access to the MojangAPI
 * Full Documentation of API found here: http://wiki.vg/Mojang_API
 */
@API.Reference(apiName = "Mojang API", apiVersion = "1.5")
public class MojangAPI extends API {

    private final static String BASE_URL = "https://api.ashcon.app/mojang/v2/user/";
    private final static String STATUS_URL = "https://status.mojang.com/check";

    private final static Pattern STRIPPED_UUID_PATTERN = Pattern.compile("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})");
    private final static Pattern UUID_PATTERN = Pattern.compile("(\\w{8})-(\\w{4})-(\\w{4})-(\\w{4})-(\\w{12})");

    /**
     * Gets Mojang Service Status's
     * Possible keys can be found here: http://wiki.vg/Mojang_API
     *
     * @return status of various Mojang services. Possible values are green (no issues), yellow (some issues), red (service unavailable).
     * @throws IOException
     */
    public static Map<String, String> getStatus() throws IOException {
        Map<String, String> map = new TreeMap<>();
        String json = sendGet(STATUS_URL);
        JsonArray status = new JsonParser().parse(json).getAsJsonArray();
        for (JsonElement element : status) {
            JsonObject obj = element.getAsJsonObject();
            obj.entrySet().forEach(s -> map.put(s.getKey(), s.getValue().getAsString()));
        }
        return map;
    }

    /**
     * Gets player profile
     * @param uuid
     * @return {@see me.kbrewster.mojangapi.profile.Profile}
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
     * @return {@see me.kbrewster.mojangapi.profile.Profile}
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
     * Gets Minecraft Username from {@see java.util.UUID}
     * @param uuid
     * @return
     */
    public static String getName(UUID uuid) throws IOException, APIException {
        List<UsernameHistory> names = getNameHistory(uuid);
        if(names.size() == 0) return uuid.toString();
        return names.get(names.size() - 1).getUsername(); // i mean i could get it vai profile, but im hacky af
    }

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
     * Strips away dashes from {@see java.util.UUID}
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
     * Gets Name History of a Minecraft Username
     * @param username
     * @return List of {@see me.kbrewster.mojangapi.profile.Name}
     * @throws IOException
     * @throws APIException
     */
    public static List<UsernameHistory> getNameHistory(String username) throws IOException, APIException {
        return getProfile(username).getUsernameHistory();
    }

    /**
     * Gets Name History of a Minecraft UUID
     * @param uuid
     * @return List of {@see me.kbrewster.mojangapi.profile.Name}
     * @throws IOException
     * @throws APIException
     */
    public static List<UsernameHistory> getNameHistory(UUID uuid) throws IOException, APIException {
        return getProfile(uuid).getUsernameHistory();
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
        return UUID.fromString(addDashes(getProfile(username).getUuid()));
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
            System.out.println(names);
            Profile profile = getProfile(names);
            if (profile.getCode() == 404) {
                throw new InvalidPlayerException();
            }
            uuids.add(UUID.fromString(addDashes(profile.getUuid())));
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
            System.out.println(names);
            Profile profile = getProfile(names);
            if (profile.getCode() == 404) {
                throw new InvalidPlayerException();
            }
            uuids.add(UUID.fromString(addDashes(profile.getUuid())));
        }
        return uuids;
    }

    /**
     * Used to get Mojang's game statistics
     * @param key
     * @return {@see me.kbrewster.mojangapi.MojangStatistics}
     * @throws IOException
     */
    public static MojangStatistics getStatistics(MetricKeys key) throws IOException {
        String json = sendPost("https://api.mojang.com/orders/statistics", "{\"metricKeys\": [\"" + key.getKey() + "\"]}");
        JsonElement obj = new JsonParser().parse(json);
        return new Gson().fromJson(obj, MojangStatistics.class);
    }

}
