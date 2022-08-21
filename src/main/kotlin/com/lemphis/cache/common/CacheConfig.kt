package com.lemphis.cache.common

import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration


@EnableCaching
@Configuration
class CacheConfig {

	@Bean
	fun cacheManager(redisConnectionFactory: RedisConnectionFactory) = RedisCacheManagerBuilder
		.fromConnectionFactory(redisConnectionFactory)
		.cacheDefaults(redisCacheDefaultConfiguration())
		.build()


	private fun redisCacheDefaultConfiguration() = RedisCacheConfiguration
		.defaultCacheConfig()
		.serializeKeysWith(
			RedisSerializationContext.SerializationPair
				.fromSerializer(StringRedisSerializer()),
		)
		.serializeValuesWith(
			RedisSerializationContext.SerializationPair
				.fromSerializer(GenericJackson2JsonRedisSerializer()),
		)
		.entryTtl(Duration.ofMinutes(30))

}
