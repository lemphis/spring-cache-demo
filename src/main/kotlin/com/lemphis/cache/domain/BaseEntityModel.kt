package com.lemphis.cache.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntityModel(

	@CreatedDate
	@Column(name = "created_dt", updatable = false)
	protected var createdDateTime: LocalDateTime = LocalDateTime.MIN,

	@LastModifiedDate
	@Column(name = "modified_dt")
	protected var modifiedDateTime: LocalDateTime = LocalDateTime.MIN,

	)
