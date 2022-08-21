package com.lemphis.cache.application.`in`

import com.lemphis.cache.domain.User

interface UserUseCase {

	fun findUser(userId: Long): User

	fun createUser(user: User): User

	fun updateUser(userId: Long, user: User): Long

}
