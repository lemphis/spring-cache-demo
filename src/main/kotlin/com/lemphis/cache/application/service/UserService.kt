package com.lemphis.cache.application.service

import com.lemphis.cache.application.`in`.UserUseCase
import com.lemphis.cache.domain.User
import com.lemphis.cache.domain.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
	private val userRepository: UserRepository,
) : UserUseCase {

	override fun findUser(userId: Long): User {
		return userRepository.findById(userId).orElseThrow { RuntimeException() }
	}

	override fun createUser(user: User): User {
		return userRepository.save(user)
	}

	override fun updateUser(userId: Long, user: User): Long {
		user.id = userId
		val savedUser = userRepository.save(user)
		return savedUser.id!!
	}

}
