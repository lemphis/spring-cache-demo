package com.lemphis.cache.interfaces

import com.lemphis.cache.application.`in`.UserUseCase
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(
	private val userUseCase: UserUseCase,
) {

	@Cacheable(cacheNames = ["user"], key = "#userId", cacheManager = "cacheManager")
	@GetMapping("/users/{userId}")
	fun findUser(@PathVariable userId: Long): UserResponse {
		val findUser = userUseCase.findUser(userId)
		return UserResponse.from(findUser)
	}

	@PostMapping("/users")
	fun createUser(@RequestBody userRequest: UserRequest): UserResponse {
		val user = userUseCase.createUser(userRequest.toUser())
		return UserResponse.from(user)
	}

	@CacheEvict(cacheNames = ["user"], key = "#userId")
	@PatchMapping("/users/{userId}")
	fun updateUser(@PathVariable userId: Long, @RequestBody userRequest: UserRequest): UserResponse {
		userUseCase.updateUser(userId, userRequest.toUser())
		return UserResponse(
			email = userRequest.email,
			nickname = userRequest.nickname,
			phone = userRequest.nickname,
			name = userRequest.name,
		)
	}

}
