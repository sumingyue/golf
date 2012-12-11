package com.golf.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Player;
import com.golf.service.PlayerService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class PlayerAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(PlayerAction.class);

	private List<Player> m_players;

	private int m_playerId;

	private PlayerService m_playerService;

	private Player m_player = new Player();

	private String m_sort = "";

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String playerList() {
		try {
			//m_pagedTool.setTotalNumber(m_playerService.queryAllPlayers(m_sort).size());
			//m_players = m_playerService.queryPagedPlayers(m_pagedTool,m_sort);
			m_players = m_playerService.queryAllPlayers(m_sort);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String playerAddSubmit() {
		try {
			m_player.setModifyDate(new Date());
			int id = m_playerService.insertPlayer(m_player);
			if (id > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String playerUpdate() {
		try {
			m_player = m_playerService.findPlayer(m_playerId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String playerUpdateSubmit() {
		try {
			m_player.setModifyDate(new Date());
			int count = m_playerService.updatePlayer(m_player);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String playerDelete() {
		try {
			int count = m_playerService.deletePlayer(m_playerId);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public Player getPlayer() {
		return m_player;
	}

	public void setPlayer(Player player) {
		m_player = player;
	}

	public void setPlayerService(PlayerService playerService) {
		m_playerService = playerService;
	}

	public List<Player> getPlayers() {
		return m_players;
	}

	public void setPlayerId(int playerId) {
		m_playerId = playerId;
	}

	public void setSort(String sort) {
		m_sort = sort;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}
}