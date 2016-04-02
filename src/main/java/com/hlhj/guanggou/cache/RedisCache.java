package com.hlhj.guanggou.cache;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hlhj.guanggou.utils.SerializeUtil;

import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;



public class RedisCache implements Cache { 

    private static Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug("mybatis cache : id is {}", id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        int result = 0;
        boolean success = true;
        Jedis client = RedisClient.getResource();
        try {
            result = NumberUtils.toInt(client.dbSize().toString());
        } catch (Exception e) {
            success = false;
            if (client != null) {
                RedisClient.getPool().close();
            }
        } finally {
            if (success) {
            	RedisClient.getPool().close();
            }
        }
        logger.debug("mybatis cache : get size is {}", result);
        return result;
    }

    @Override
    public void putObject(Object key, Object value) {
        boolean success = true;
        Jedis client = RedisClient.getResource();
        try {
            client.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
        } catch (Exception e) {
            success = false;
            if (client != null) {
            	client.close();
            }
        } finally {
            if (success) {
            	client.close();
            }
        }
        logger.debug("mybatis cache : put object : key is {}, value is {}", key, value);
    }

    @Override
    public Object getObject(Object key) {
        Object value = null;
        boolean success = true;
        Jedis client = RedisClient.getResource();
        try {
            value = SerializeUtil.unserialize(client.get(SerializeUtil.serialize(key)));
        } catch (Exception e) {
            success = false;
            if (client != null) {
                //RedisClient.returnBrokenResource(client);
            }
        } finally {
            if (success) {
                //RedisClient.returnResource(client);
            }
        }
        logger.debug("mybatis cache : get object : key is {}, value is {}", key, value);
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        Object value = null;
        boolean success = true;
        Jedis client = RedisClient.getResource();
        try {
            value = client.expire(SerializeUtil.serialize(key), 0);
        } catch (Exception e) {
            success = false;
            if (client != null) {
                //RedisClient.returnBrokenResource(client);
            }
        } finally {
            if (success) {
               // RedisClient.returnResource(client);
            }
        }
        logger.debug("mybatis cache : remove object : key is {}, value is {}", key, value);
        return value;
    }

    @Override
    public void clear() {
        boolean success = true;
        Jedis client = RedisClient.getResource();
        try {
            client.flushDB();
            client.flushAll();
        } catch (Exception e) {
            success = false;
            if (client != null) {
               // RedisClient.returnBrokenResource(client);
            }
        } finally {
            if (success) {
               // RedisClient.returnResource(client);
            }
        }
        logger.debug("mybatis cache : clear DB");
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}