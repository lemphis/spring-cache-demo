package com.lemphis.cache.interfaces

import com.lemphis.cache.domain.User

data class UserResponse(
	val email: String,
	val nickname: String,
	val phone: String,
	val name: String,
) {

	companion object {
		fun from(user: User) = UserResponse(
			email = user.email,
			nickname = user.nickname,
			phone = user.phone,
			name = user.name,
		)
	}

}
