package com.enic.RedisUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
* 利用redis实现分布式锁
* @version v1.0.0
* @author jibang
* @date 2019年10月16日 下午2:01:24
 */
@Component
public class DistributedLockHandler {
	public static final int LOCK_EXPIRE_TIME = 10; // 锁的有效时间(S)
	private final static int LOCK_TRY_INTERVAL = 500;// 最大0.5s尝试一次
	private final static int LOCK_TRY_TIMEOUT = 8;// 默认尝试8s
    private static final String LOCKED = "LOCKED";// 存储到redis中的锁标志
    
	@Autowired
	private StringRedisTemplate template;
	
	/**
	 * 操作redis尝试获取全局锁
	 * NOTE:默认锁的有效期为10s，最大间隔1s尝试一次获取锁，尝试重复获取锁的最大时间8s
	 *
	 * @param lock 锁的名称
	 * @return true 获取成功，false获取失败
	 * @author jibang
	 * @Date 2017年8月15日 下午2:10:40
	 */
	public boolean tryLock(String lock) {
		return tryLock(lock, LOCK_EXPIRE_TIME, LOCK_TRY_INTERVAL, LOCK_TRY_TIMEOUT);
	}

	/**
	 * 操作redis尝试获取全局锁
	 * 
	 * @param lock 锁的名称
	 * @param expireTime 锁的有效期(单位:秒)
	 * @param tryInterval 重试获取锁的最大间隔时间(单位:毫秒)
	 * @param tryTimeOut 尝试获取锁的超时时间(单位:秒)
	 * @return true 获取成功，false获取失败
	 * @author jibang
	 * @Date 2017年8月15日 下午1:38:54
	 */
	public boolean tryLock(String lock, long expireTime, int tryInterval, int tryTimeOut) {
		if (StringUtils.isBlank(lock)) {
			return false;
		}
		
		long startTime = System.currentTimeMillis();
		
		boolean flag = Boolean.FALSE;
		final Random r = new Random();
		
		do {
			if (template.opsForValue().setIfAbsent(lock,LOCKED)) {
	        	template.expire(lock, expireTime, TimeUnit.SECONDS);
	        	flag = Boolean.TRUE;
	        } else {
				LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(r.nextInt(tryInterval)));
	        }
		} while (!flag && System.currentTimeMillis() - startTime <= tryTimeOut * 1000);
	
		return flag;
	}
	
	/**
	 * 释放锁
	 * @param lock 锁的名称
	 * @author jibang
	 * @Date 2017年8月15日 下午2:10:24
	 */
	public void releaseLock(String lock) {
		if (!StringUtils.isEmpty(lock)) {
			template.delete(lock);
		}
	}
}
