package com.parkingsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.parkingsystem.model.dto.FriendDTO;

public class FriendListMapper implements RowMapper<List<FriendDTO>> {

	@Override
	public List<FriendDTO> mapRow(ResultSet rs, int rowNum) throws SQLException {

		List<FriendDTO> friendList = new ArrayList<FriendDTO>();

		while (rs.next()) {
			FriendDTO friendDTO = new FriendDTO();
			friendDTO.setId(rs.getInt(1));
			friendDTO.setName(rs.getString(2));
			friendDTO.setGender(rs.getString(3));
			friendDTO.setEmail(rs.getString(4));
			friendDTO.setPhoneNumber(rs.getString(5));
			friendDTO.setCompany(rs.getString(6));
			friendList.add(friendDTO);
		}
		return friendList;
	}

}
