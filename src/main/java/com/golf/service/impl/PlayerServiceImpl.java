package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.PlayerDao;
import com.golf.entity.Player;
import com.golf.service.PlayerService;
import com.golf.tools.PagedTool;

public class PlayerServiceImpl implements InitializingBean, PlayerService {

	private PlayerDao m_playerDao;

	private Map<Integer, Player> m_players = new LinkedHashMap<Integer, Player>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Player> categories = m_playerDao.findAllPlayer();

		for (Player player : categories) {
			m_players.put(player.getId(), player);
		}
	}

	@Override
	public List<Player> queryAllPlayers() {
		return new ArrayList<Player>(m_players.values());
	}

	@Override
	public int insertPlayer(Player player) {
		int id = m_playerDao.insert(player);
		if (id > 0) {
			m_players.put(player.getId(), player);
		}
		return id;
	}

	@Override
	public int updatePlayer(Player player) {
		int id = m_playerDao.update(player);
		if (id > 0) {
			m_players.put(player.getId(), player);
		}
		return id;
	}

	@Override
	public int deletePlayer(int playerId) {
		int id = m_playerDao.delete(playerId);
		if (id > 0) {
			m_players.remove(playerId);
		}
		return id;
	}

	@Override
	public Player findPlayer(int playerId) {
		Player player = m_players.get(playerId);
		if (player == null) {
			Player temp = m_playerDao.findById(playerId);
			if (temp != null) {
				m_players.put(playerId, temp);
			}
			return temp;
		}
		return player;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		m_playerDao = playerDao;
	}

	@Override
	public List<Player> queryAllPlayers(String sort) {
		List<Player> players = queryAllPlayers();
		Collections.sort(players, new PlayerCompator(sort));
		return players;
	}

	public static class PlayerCompator implements Comparator<Player> {

		private String m_sort;

		public PlayerCompator(String sort) {
			m_sort = sort;
		}

		@Override
		public int compare(Player o1, Player o2) {
			if (m_sort.equals("score")) {
				return (int) ((o2.getScore() - o1.getScore()) * 100);
			} else {
				return (int) ((o2.getBonus() - o1.getBonus()) * 100);
			}
		}
	}

	@Override
	public List<Player> queryPagedPlayers(PagedTool pagedTool, String sort) {
		List<Player> result = queryAllPlayers(sort);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}

}
