package com.grupo2.cloud.final2.app.feign;

import java.util.List;

import com.grupo2.cloud.final2.app.service.SongObj;

import feign.Param;
import feign.RequestLine;

public interface PlaylistClient {

	@RequestLine("GET /playlist/{id}")
	public List<SongObj> getPlaylist (@Param("id") Integer id);
}