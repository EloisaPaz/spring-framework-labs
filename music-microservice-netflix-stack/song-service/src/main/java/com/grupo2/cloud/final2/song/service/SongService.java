package com.grupo2.cloud.final2.song.service;

import com.grupo2.cloud.final2.song.command.SongCommand;

public class SongService {

	public static SongObj getSong(Integer id) {
		return new SongCommand(id).execute();
	}

}
