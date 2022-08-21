package com.lemphis.cache.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
class User(
	email: String,
	nickname: String,
	phone: String,
	name: String,
	password: String,
) : BaseEntityModel() {

	@Id
	@GeneratedValue
	var id: Long? = null

	@Column(unique = true, nullable = false)
	var email: String = email
		private set

	@Column(unique = true, nullable = false)
	var nickname: String = nickname
		private set

	@Column(unique = true, nullable = false)
	var phone: String = phone
		private set

	@Column(nullable = false)
	var name: String = name
		private set

	@Column(nullable = false)
	var password: String = password
		private set

}
