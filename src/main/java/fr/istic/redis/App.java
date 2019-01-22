package fr.istic.redis;

import redis.clients.jedis.Jedis;

public class App {

    public static void main(String[] args) throws InterruptedException {
        String cacheKey = "languages";
        Jedis jedis = new Jedis("localhost");
        // Adding a set as value
        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "C#");
        jedis.sadd(cacheKey, "Python");
        // Getting all values in the set: SMEMBERS
        System.out.println("Languages: " + jedis.smembers(cacheKey));
        // Adding new values
        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "Ruby");
        // Getting the values... it doesn't allow duplicates
        System.out.println("Languages: " + jedis.smembers(cacheKey));
    }

}
