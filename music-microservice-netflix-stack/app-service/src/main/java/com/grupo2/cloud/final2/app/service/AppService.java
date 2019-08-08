package com.grupo2.cloud.final2.app.service;

import java.util.List;

import com.grupo2.cloud.final2.app.commands.PlaylistCommand;

public class AppService {

	public static List<SongObj> getPlaylist(Integer id) {
		return new PlaylistCommand(id).execute();
	}

}
