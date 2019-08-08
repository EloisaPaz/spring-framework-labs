package com.grupo2.cloud.final2.playlist.service;

import java.util.List;

import com.grupo2.cloud.final2.playlist.command.PlaylistCommand;

public class PlaylistService {
	
	public static List<SongObj> getPlaylist (Integer id) {
		return new PlaylistCommand(id).execute();
	}

}
