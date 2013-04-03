package com.golf.service;

import java.util.List;

import com.golf.entity.Player;
import com.golf.tools.PagedTool;

public interface PlayerService {

	public int deletePlayer(int playerId);
	
	public Player findPlayer(int playerId);

	public int insertPlayer(Player player);

	public List<Player> queryAllPlayers();

	public List<Player> queryAllPlayers(String sort);

	public List<Player> queryPagedPlayers(PagedTool pagedTool, String sort);

	public List<Player> queryPlayers(String sort,int size);

	public int updatePlayer(Player player);

}
