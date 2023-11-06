package com.resort.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Room {

	@Id
	@Column(name = "room_id")
	private Integer roomId;

	@Column
	private String type;

}
