package com.ivanslushko.training.web.caching;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
	public static void main(String[] args) {
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost", 6379);
		System.out.println("Connection to server sucessfully");
		// set the data in redis string
		jedis.set("tutorial-name", "Redis tutorial");
		jedis.set("id", "1");
		jedis.set("id", "2");		
		jedis.set("passenger", "1");
		jedis.set("clas", "1");
		jedis.set("price", "7.05");
		jedis.set("bag", "true");
		jedis.set("first_reg", "true");
		
		
		
		System.out.println("----------------------------");
		System.out.println("id 1 "+jedis.get("id"));
		System.out.println("id 2 "+jedis.get("id"));
		System.out.println(jedis.get("passenger"));
		System.out.println(jedis.get("clas"));
		System.out.println(jedis.get("price"));
		System.out.println(jedis.get("bag"));
		System.out.println(jedis.get("first_reg"));
		
		
	}
}