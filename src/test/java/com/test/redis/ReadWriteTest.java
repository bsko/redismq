package com.test.redis;

import junit.framework.TestCase;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Пользователь on 22.05.2015.
 */
public class ReadWriteTest extends TestCase {

    @Test
    public void testReadWrite() {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost");
            jedis.connect();

            jedis.set("message", "testing");
            assertEquals(jedis.get("message"), "testing");
            jedis.del("message");
            assertNull(jedis.get("message"));
        } finally {
            if(jedis != null) {
                jedis.disconnect();
            }
        }
    }
}
