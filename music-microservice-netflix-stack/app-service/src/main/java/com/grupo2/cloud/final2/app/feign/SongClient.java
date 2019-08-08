package com.grupo2.cloud.final2.app.feign;

import com.grupo2.cloud.final2.app.service.SongObj;

import feign.Param;
import feign.RequestLine;

public interface SongClient {

	@RequestLine("GET /song/{id}")
	public SongObj getSong (@Param("id") Integer id);
}
