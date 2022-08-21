package com.lemphis.cache.interfaces

import com.lemphis.cache.domain.User

data class UserRequest(
	val email: String,
	val nickname: String,
	val phone: String,
	val name: String,
	val password: String,
) {

	fun toUser() = User(
		email = email,
		nickname = nickname,
		phone = phone,
		name = name,
		password = password,
	)

}
