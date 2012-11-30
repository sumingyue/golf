package com.golf.service;

import java.util.List;

import com.golf.entity.Player;
import com.golf.tools.PagedTool;

public interface PlayerService {

	public List<Player> queryAllPlayers();
	
	public List<Player> queryAllPlayers(String sort);

	public int insertPlayer(Player player);

	public int updatePlayer(Player player);

	public int deletePlayer(int playerId);

	public Player findPlayer(int playerId);

	public List<Player> queryPagedPlayers(PagedTool pagedTool, String sort);

}
