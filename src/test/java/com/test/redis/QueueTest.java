package com.test.redis;

import junit.framework.TestCase;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Пользователь on 22.05.2015.
 */
public class QueueTest extends TestCase {

    @Test
    public void testQueue() throws Exception {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost");
            jedis.connect();

            jedis.rpush("queue", "first");
            jedis.rpush("queue", "second");

            Thread.sleep(100);

            String result = jedis.lpop("queue");
            assertEquals(result, "first");
            assertEquals(jedis.lpop("queue"), "second");

            jedis.rpush("queue", "third");
            jedis.rpush("queue", "fourth");

            Thread.sleep(100);

            List<String> resultList = jedis.blpop(0, "queue");
            assertEquals(resultList.get(0), "queue");
            assertEquals(resultList.get(1), "third");
            assertEquals(jedis.rpop("queue"), "fourth");
        } finally {
            if(jedis != null) {
                jedis.del("queue");
                jedis.disconnect();
            }
        }


    }
}
